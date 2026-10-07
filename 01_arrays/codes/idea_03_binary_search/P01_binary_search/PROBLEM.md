# Classic Binary Search

## Problem Statement
Given a **sorted** (non-decreasing) array of `N` integers and a `target` value, return the **index** of `target` in the array. If not found, return `-1`.

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
- `1 ≤ N ≤ 10^6`
- `-10^9 ≤ a[i], target ≤ 10^9`
- Array is sorted in non-decreasing order.
- All elements are distinct.

## Examples

### Example 1
**Input:**
```
10
2 5 8 12 16 23 38 56 72 91
23
```
**Output:**
```
5
```

### Example 2
**Input:**
```
5
1 3 5 7 9
4
```
**Output:**
```
-1
```

## Algorithm
Safe midpoint: `mid = low + (high - low) / 2` avoids integer overflow.
- **Time Complexity:** O(log N)
- **Space Complexity:** O(1)
