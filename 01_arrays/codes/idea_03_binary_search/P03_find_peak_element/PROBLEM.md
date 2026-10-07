# Find Peak Element (LeetCode 162)

## Problem Statement
An array `arr` of integers contains a **peak element** — an element that is **strictly greater than its neighbors**. Given the array, find the index of **any** peak element.

You may assume `arr[-1] = arr[N] = -∞`. A peak always exists.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
```
<index of any peak element>
```

## Constraints
- `1 ≤ N ≤ 10^5`
- `-2^31 ≤ a[i] ≤ 2^31 - 1`
- `a[i] != a[i+1]` for all valid `i`.

## Examples

### Example 1
**Input:**
```
5
1 2 3 1 0
```
**Output:**
```
2
```

### Example 2
**Input:**
```
6
1 2 1 3 5 6
```
**Output:**
```
5
```
(Index 5 or index 1 both valid.)

## Algorithm
Binary search on the slope: if `arr[mid] < arr[mid+1]`, peak lies on the right; else on the left.
- **Time Complexity:** O(log N)
- **Space Complexity:** O(1)
