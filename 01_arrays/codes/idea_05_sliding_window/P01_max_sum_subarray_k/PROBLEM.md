# Maximum Sum Subarray of Size K

## Problem Statement
Given an integer array of length `N` and an integer `K`, find the largest sum among all contiguous subarrays of exactly `K` elements.

## Input Format
```
N K
a[0] a[1] ... a[N-1]
```

## Output Format
Print the maximum window sum.

## Constraints
- `1 <= K <= N <= 10^5`
- `-10^9 <= a[i] <= 10^9`

## Example
```
Input
6 3
2 1 5 1 3 2

Output
9
```
The window `[5, 1, 3]` has the largest sum.

## Algorithm
Maintain the sum of the current window. Once its size reaches `K`, update the answer, evict the leftmost value, and advance `L`.

- Time: `O(N)`
- Space: `O(1)`

