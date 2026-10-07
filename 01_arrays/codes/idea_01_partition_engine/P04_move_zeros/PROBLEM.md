# Move All Zeros to the End

## Problem Statement
Given an array of `N` integers, move all `0`s to the **end** of the array while maintaining the **relative order** of the non-zero elements. Do this **in-place** without allocating extra memory.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
```
a[0] a[1] ... a[N-1]   (non-zeros first in original order, then zeros)
```

## Constraints
- `1 ≤ N ≤ 10^5`
- `-10^9 ≤ a[i] ≤ 10^9`

## Examples

### Example 1
**Input:**
```
6
0 1 0 3 12 0
```
**Output:**
```
1 3 12 0 0 0
```

### Example 2
**Input:**
```
5
1 2 3 4 5
```
**Output:**
```
1 2 3 4 5
```

## Algorithm
Partition predicate: `arr[j] != 0` (keep non-zeros on the left). Relative order is preserved because elements only move forward, never backward.
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)
