# Range Update with Difference Array

## Problem Statement
Start with an array of N zeroes. For each operation (L, R, V), add V to every position from zero-based index L through R, inclusive. Print the final array.

## Input Format
    N Q
    L1 R1 V1
    ...
    LQ RQ VQ

## Output Format
Print the final N values, separated by spaces.

## Constraints
- 1 <= N, Q <= 100000
- 0 <= L <= R < N
- -10^9 <= V <= 10^9
- The final values fit in a 32-bit signed integer.

## Example
Input:
    5 3
    1 3 2
    2 4 3
    0 2 -2

Output:
    -2 0 3 5 3

## Algorithm
Record each range update as two boundary changes in a difference array, then take one prefix sweep to reconstruct the final values.

- Time: O(N + Q)
- Space: O(N)

