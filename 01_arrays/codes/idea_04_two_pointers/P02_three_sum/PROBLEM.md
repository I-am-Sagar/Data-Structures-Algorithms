# 3Sum (LeetCode 15)

## Problem Statement
Given an integer array `nums`, return all unique triplets `[a, b, c]` such that `a + b + c = 0`. The solution set must not contain duplicate triplets.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
Each triplet on its own line (sorted in ascending order per triplet), one triplet per line. Print `[]` if none.
```
a b c
```

## Constraints
- `3 ≤ N ≤ 3000`
- `-10^5 ≤ a[i] ≤ 10^5`

## Examples

### Example 1
**Input:**
```
6
-1 0 1 2 -1 -4
```
**Output:**
```
-1 -1 2
-1 0 1
```

## Algorithm
Sort. Fix outer index `i`. Run two-pointer on `[i+1, N-1]`. Skip duplicates by pointer advancing.
- **Time Complexity:** O(N²)
- **Space Complexity:** O(1) auxiliary
