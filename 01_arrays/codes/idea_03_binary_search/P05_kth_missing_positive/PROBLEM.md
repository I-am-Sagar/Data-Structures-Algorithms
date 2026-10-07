# Kth Missing Positive Number (LeetCode 1539)

## Problem Statement
Given a **sorted** array of **distinct positive integers** `arr` and a positive integer `k`, return the **k-th missing positive integer**.

## Input Format
```
N
a[0] a[1] ... a[N-1]
k
```

## Output Format
```
<k-th missing positive integer>
```

## Constraints
- `1 ≤ N ≤ 1000`
- `1 ≤ a[i] ≤ 1000`
- `1 ≤ k ≤ 1000`
- All elements in `arr` are distinct.

## Examples

### Example 1
**Input:**
```
5
2 3 4 7 11
5
```
**Output:**
```
9
```
**Explanation:** Missing positives: 1, 5, 6, 8, 9. The 5th is 9.

### Example 2
**Input:**
```
3
1 2 3
3
```
**Output:**
```
6
```

## Algorithm
Binary search on index: at index `i`, the count of missing numbers before `arr[i]` is `arr[i] - (i+1)`. Find the smallest index where missing count `>= k`.
- **Time Complexity:** O(log N)
- **Space Complexity:** O(1)
