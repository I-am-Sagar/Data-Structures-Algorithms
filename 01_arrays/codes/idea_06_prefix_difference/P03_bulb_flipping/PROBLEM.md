# Bulb Flipping / Range Parity Inversion

## Problem Statement
There are N bulbs, initially off. Each query flips every bulb in an inclusive zero-based range [L, R]. After all queries, print the number of bulbs that are on.

## Input Format
    N Q
    L1 R1
    ...
    LQ RQ

## Output Format
Print the number of bulbs that are on.

## Constraints
- 1 <= N, Q <= 100000
- 0 <= L <= R < N

## Example
Input:
    5 3
    0 2
    1 3
    2 4

Output:
    3

## Algorithm
A bulb is on exactly when its number of covering flips is odd. Use a difference array to count flips at each index.

- Time: O(N + Q)
- Space: O(N)

