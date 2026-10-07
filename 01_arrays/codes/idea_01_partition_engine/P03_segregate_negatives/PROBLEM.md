# Segregate Negatives and Positives

## Problem Statement
Given an array of `N` integers, rearrange the array **in-place** so that all **negative integers appear before all positive integers** (and zeros). The relative order among negatives or among positives need not be preserved.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
Print the rearranged array. Any valid arrangement where all negatives precede all non-negatives is accepted.

## Constraints
- `1 ≤ N ≤ 10^5`
- `-10^9 ≤ a[i] ≤ 10^9`

## Examples

### Example 1
**Input:**
```
6
-1 3 -2 4 -5 6
```
**Output:**
```
-1 -2 -5 4 3 6
```
(Any arrangement with all negatives first is correct.)

### Example 2
**Input:**
```
4
1 2 3 4
```
**Output:**
```
1 2 3 4
```

## Algorithm
Partition predicate: `arr[j] < 0` (treat 0 as the pivot threshold).
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)
