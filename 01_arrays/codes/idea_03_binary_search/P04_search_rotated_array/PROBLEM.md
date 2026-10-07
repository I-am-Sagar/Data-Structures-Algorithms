# Search in Rotated Sorted Array (LeetCode 33)

## Problem Statement
A sorted array has been **rotated** at some unknown pivot index. Given the rotated array and a `target`, return its **index** or `-1` if not present.

## Input Format
```
N
a[0] a[1] ... a[N-1]
target
```

## Output Format
```
<index or -1>
```

## Constraints
- `1 ≤ N ≤ 10^5`
- All elements are distinct.
- `-10^4 ≤ a[i], target ≤ 10^4`

## Examples

### Example 1
**Input:**
```
7
4 5 6 7 0 1 2
0
```
**Output:**
```
4
```

### Example 2
**Input:**
```
7
4 5 6 7 0 1 2
3
```
**Output:**
```
-1
```

## Algorithm
At each mid, identify which half is **sorted** (by comparing `arr[low]` and `arr[mid]`). Then check if target lies within the sorted half. Navigate accordingly.
- **Time Complexity:** O(log N)
- **Space Complexity:** O(1)
