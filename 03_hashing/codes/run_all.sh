#!/usr/bin/env bash
# =============================================================================
# Master Test Runner for Chapter 03: Hashing
# Executes all test suites across all 4 ideas and 15 problems
# =============================================================================

CODES_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TOTAL_PROBLEMS=0
PASSED_PROBLEMS=0
FAILED_PROBLEMS=0

echo "========================================================================"
echo "  CHAPTER 03: HASHING & HASH TABLES — COMPREHENSIVE RUNNABLE SUITE"
echo "========================================================================"

for idea_dir in "$CODES_DIR"/idea_*; do
  [ -d "$idea_dir" ] || continue
  idea_name=$(basename "$idea_dir")
  echo ""
  echo "────────────────────────────────────────────────────────────────────────"
  echo "  Running Idea: $idea_name"
  echo "────────────────────────────────────────────────────────────────────────"

  for prob_dir in "$idea_dir"/P*; do
    [ -d "$prob_dir" ] || continue
    prob_name=$(basename "$prob_dir")
    TOTAL_PROBLEMS=$((TOTAL_PROBLEMS + 1))
    
    printf "%-40s " "  Testing $prob_name..."
    out=$(bash "$prob_dir/run.sh" 2>&1)
    if [ $? -eq 0 ]; then
      echo "[PASS]"
      PASSED_PROBLEMS=$((PASSED_PROBLEMS + 1))
    else
      echo "[FAIL]"
      FAILED_PROBLEMS=$((FAILED_PROBLEMS + 1))
      echo "$out"
    fi
  done
done

echo ""
echo "========================================================================"
echo "  FINAL TEST SUMMARY"
echo "  Total Problems Tested : $TOTAL_PROBLEMS"
echo "  Passed                : $PASSED_PROBLEMS"
echo "  Failed                : $FAILED_PROBLEMS"
echo "========================================================================"

if [ "$FAILED_PROBLEMS" -eq 0 ]; then
  echo "  ✓ ALL $TOTAL_PROBLEMS PROBLEMS PASSED ALL TEST CASES!"
  exit 0
else
  echo "  ✗ SOME TESTS FAILED!"
  exit 1
fi
