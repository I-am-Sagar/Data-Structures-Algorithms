# Remove Duplicates from Sorted Array (LeetCode 26)

## Problem Statement
Given a **sorted** array of integers, remove duplicates **in-place** so each unique element appears exactly once. Return the new length `K`.

The first `K` elements of the modified array must contain the unique elements in sorted order.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
```
<K>
<a[0] a[1] ... a[K-1]>   (unique elements)
```

## Constraints
- `1 ≤ N ≤ 3 × 10^4`
- `-100 ≤ a[i] ≤ 100`
- Array is sorted in non-decreasing order.

## Examples

### Example 1
**Input:**
```
5
1 1 2 2 3
```
**Output:**
```
3
1 2 3
```

### Example 2
**Input:**
```
5
0 0 1 1 2
```
**Output:**
```
3
0 1 2
```

## Algorithm
Fast pointer (`fast`) reads every element. Slow pointer (`slow`) writes unique elements. When `nums[fast] != nums[slow]`: `slow++; nums[slow] = nums[fast]`.
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)
