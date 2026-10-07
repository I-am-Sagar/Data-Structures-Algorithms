# First Negative Integer in Every Window

## Problem Statement
For every contiguous window of size `K` in an array, print its first negative integer. Print `0` for a window with no negative integer.

## Input Format
```
N K
a[0] a[1] ... a[N-1]
```

## Output Format
Print one answer for each window, separated by spaces.

## Constraints
- `1 <= K <= N <= 10^5`
- `-10^9 <= a[i] <= 10^9`

## Example
```
Input
6 3
12 -1 -7 8 -15 30

Output
-1 -1 -7 -15
```

## Algorithm
Keep only negative values of the active window in a FIFO queue. Its front is the first negative value.

- Time: `O(N)`
- Space: `O(K)`

