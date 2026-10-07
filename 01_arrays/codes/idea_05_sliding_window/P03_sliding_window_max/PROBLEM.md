# Sliding Window Maximum

## Problem Statement
For every contiguous window of size `K`, print its maximum value.

## Input Format
```
N K
a[0] a[1] ... a[N-1]
```

## Output Format
Print the maximum for each window, separated by spaces.

## Constraints
- `1 <= K <= N <= 10^5`
- `-10^9 <= a[i] <= 10^9`

## Example
```
Input
8 3
1 3 -1 -3 5 3 6 7

Output
3 3 5 5 6 7
```

## Algorithm
Maintain a deque of candidate indices in decreasing value order. The front is always the window maximum.

- Time: `O(N)` amortized
- Space: `O(K)`

