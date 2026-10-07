# Lower Bound and Upper Bound

## Problem Statement
Given a **sorted** array with possible duplicates and a `target`, compute:
- **Lower Bound**: Index of first element `≥ target` (or `N` if none exists).
- **Upper Bound**: Index of first element `> target` (or `N` if none exists).
- **Count**: `upperBound - lowerBound` = number of occurrences of `target`.

## Input Format
```
N
a[0] a[1] ... a[N-1]
target
```

## Output Format
```
lowerBound upperBound count
```

## Constraints
- `1 ≤ N ≤ 10^6`
- `-10^9 ≤ a[i], target ≤ 10^9`
- Array sorted in non-decreasing order.

## Examples

### Example 1
**Input:**
```
7
1 2 4 4 4 6 7
4
```
**Output:**
```
2 5 3
```
**Explanation:** First `4` is at index 2. First element `> 4` is at index 5. Count = 3.

### Example 2
**Input:**
```
5
1 2 3 5 6
4
```
**Output:**
```
3 3 0
```

## Algorithm
Both bounds use the same binary search loop, differing only in the condition (`>= target` vs `> target`).
- **Time Complexity:** O(log N) each
- **Space Complexity:** O(1)
