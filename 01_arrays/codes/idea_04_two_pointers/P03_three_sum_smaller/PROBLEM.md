# 3Sum Smaller (LeetCode 259)

## Problem Statement
Given an array `nums` of `N` integers and an integer `target`, count the number of index triplets `(i, j, k)` with `i < j < k` such that `nums[i] + nums[j] + nums[k] < target`.

## Input Format
```
N target
a[0] a[1] ... a[N-1]
```

## Output Format
```
<count>
```

## Constraints
- `3 ≤ N ≤ 500`
- `-10^3 ≤ a[i], target ≤ 10^3`

## Examples

### Example 1
**Input:**
```
4 2
-2 0 1 3
```
**Output:**
```
2
```
**Explanation:** Triplets: (-2,0,1) and (-2,0,3) both sum < 2. Actually (-2,0,1)=-1<2, (-2,0,3)=1<2. Count=2.

## Algorithm
Sort. Fix `i`. Two pointers on rest. If `sum < target`, bulk-add `(R - L)` pairs, then `L++`. Else `R--`.
- **Time Complexity:** O(N²)
- **Space Complexity:** O(1)
