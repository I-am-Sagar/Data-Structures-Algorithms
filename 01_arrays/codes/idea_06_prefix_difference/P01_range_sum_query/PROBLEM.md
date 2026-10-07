# Range Sum Query

## Problem Statement
Given a static integer array and Q inclusive index ranges, print the sum of each range.

## Input Format
    N Q
    a[0] a[1] ... a[N-1]
    L1 R1
    ...
    LQ RQ
Each query uses zero-based inclusive indices.

## Output Format
Print one range sum per line.

## Constraints
- 1 <= N, Q <= 100000
- -10^9 <= a[i] <= 10^9
- 0 <= L <= R < N

## Example
Input:
    5 2
    3 1 4 2 5
    1 3
    0 4

Output:
    7
    15

## Algorithm
Build a one-based prefix array. A range sum is P[R + 1] - P[L].

- Preprocessing: O(N)
- Per query: O(1)
- Space: O(N)

