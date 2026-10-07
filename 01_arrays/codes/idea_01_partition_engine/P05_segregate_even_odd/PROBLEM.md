# Segregate Even and Odd Numbers

## Problem Statement
Given an array of `N` integers, rearrange the array **in-place** so that all **even integers appear before all odd integers**. The relative order among evens or odds need not be preserved.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
Print the rearranged array (any valid arrangement where all evens precede all odds is accepted).

## Constraints
- `1 ≤ N ≤ 10^5`
- `-10^9 ≤ a[i] ≤ 10^9`

## Examples

### Example 1
**Input:**
```
6
1 2 3 4 5 6
```
**Output:**
```
6 2 4 3 5 1
```

### Example 2
**Input:**
```
5
-3 4 -2 7 8
```
**Output:**
```
8 4 -2 7 -3
```

## Algorithm
Partition predicate: `(arr[j] & 1) == 0` (bitwise parity — robust for negative numbers where `% 2` can return -1).
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)
