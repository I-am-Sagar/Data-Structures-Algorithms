#!/usr/bin/env bash
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
CLASS="Solution"
TC_DIR="$DIR/tc"
if command -v javac >/dev/null 2>&1; then
  javac "$DIR/Solution.java" -d "$DIR"
fi
PASS=0; FAIL=0; TOTAL=0
for input_file in "$TC_DIR"/tc*.txt; do
  [ -f "$input_file" ] || continue
  tc_name=$(basename "$input_file" .txt)
  num=${tc_name#tc}
  expected_file="$TC_DIR/expected${num}.txt"
  [ -f "$expected_file" ] || { echo "SKIP $tc_name (no expected file)"; continue; }
  actual=$(if command -v javac >/dev/null 2>&1; then java -cp "$DIR" "$CLASS" < "$input_file"; else java "$DIR/Solution.java" < "$input_file"; fi)
  expected=$(cat "$expected_file")
  TOTAL=$((TOTAL+1))
  if [ "$actual" = "$expected" ]; then
    echo "PASS  $tc_name"; PASS=$((PASS+1))
  else
    echo "FAIL  $tc_name"
    echo "      Expected : $(echo "$expected" | head -3)"
    echo "      Got      : $(echo "$actual"   | head -3)"
    FAIL=$((FAIL+1))
  fi
done
echo "──────────────────────────────"
echo "Results: $PASS/$TOTAL passed  |  $FAIL failed"
[ "$FAIL" -eq 0 ] && exit 0 || exit 1
