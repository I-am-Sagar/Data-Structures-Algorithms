#!/usr/bin/env bash
set -euo pipefail
DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
TC_DIR="$DIR/tc"
trap 'rm -f "$DIR"/*.class' EXIT
if command -v javac >/dev/null 2>&1; then
  javac "$DIR/Solution.java" -d "$DIR"
fi
pass=0; fail=0; total=0
for input_file in "$TC_DIR"/tc*.txt; do
  tc="$(basename "$input_file" .txt)"
  expected_file="$TC_DIR/expected${tc#tc}.txt"
  actual="$(if command -v javac >/dev/null 2>&1; then java -cp "$DIR" Solution < "$input_file"; else java "$DIR/Solution.java" < "$input_file"; fi)"
  expected="$(cat "$expected_file")"
  total=$((total + 1))
  if [[ "$actual" == "$expected" ]]; then echo "PASS  $tc"; pass=$((pass + 1)); else echo "FAIL  $tc"; fail=$((fail + 1)); echo "      Expected: $expected"; echo "      Got:      $actual"; fi
done
echo "Results: $pass/$total passed | $fail failed"
(( fail == 0 ))
