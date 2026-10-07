# Longest Subarray with Sum K

## Problem Statement
Given an array of **non-negative** integers and `K`, find the maximum length of a contiguous subarray whose sum is exactly `K`. Print `0` if no such subarray exists.

## Input Format
```
N K
a[0] a[1] ... a[N-1]
```

## Output Format
Print the maximum length.

## Constraints
- `1 <= N <= 10^5`
- `0 <= a[i], K <= 10^9`

## Example
```
Input
5 5
1 2 3 2 5

Output
2
```

## Algorithm
Expand the window; while its sum is too large, remove values from the left. This technique requires non-negative values.

- Time: `O(N)`
- Space: `O(1)`

