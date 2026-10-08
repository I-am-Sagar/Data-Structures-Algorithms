# Subarray Sum Equals K (LeetCode 560)

## Problem Statement
Given an array of integers `nums` and an integer `k`, return the **total number of subarrays** whose sum equals to `k`.

A subarray is a contiguous non-empty sequence of elements within an array.

## Mental Model & The Prefix Sum Counter Invariant
- **Prefix Sum Decomposition**:
  The sum of any contiguous subarray $\text{nums}[i \dots j]$ can be expressed as the difference between two prefix sums:
  $$\text{Sum}(i \dots j) = P_j - P_{i-1}$$
  Setting this equal to $k$:
  $$P_j - P_{i-1} = k \iff P_{i-1} = P_j - k$$
- **The Running Counter Invariant**:
  - Maintain a running sum $P_j = \text{currSum}$ as we iterate left to right.
  - To count all subarrays ending at index $j$ that sum to $k$, we simply need the frequency of previously seen prefix sums equal to $P_j - k$.
  - We look up this count in $\mathcal{O}(1)$ time using `map.getOrDefault(currSum - k, 0)`.
- **The Critical Base Case (`map.put(0, 1)`)**:
  - A subarray starting at the very beginning (index 0) has sum $P_j - P_{-1} = P_j - 0$.
  - If $P_j = k$, then $P_j - k = 0$.
  - Without pre-populating `{0: 1}`, all valid subarrays originating at index 0 would be erroneously omitted!
- **Handling Negative Numbers**:
  Unlike sliding window / two pointers (which require monotonic positive numbers), this prefix sum frequency map works universally on arrays containing positive, negative, and zero values.

## Input Format
```
Line 1: Space-separated integers representing nums.
Line 2: An integer k.
```

## Output Format
```
A single integer representing the count of subarrays summing to k.
```

## Constraints
- $1 \le \text{nums.length} \le 2 \times 10^4$
- $-1000 \le \text{nums}[i] \le 1000$
- $-10^7 \le k \le 10^7$

## Examples
### Example 1
**Input:**
```
1 1 1
2
```
**Output:**
```
2
```
**Explanation:** The subarrays are `nums[0..1]` and `nums[1..2]`.

### Example 2
**Input:**
```
1 2 3
3
```
**Output:**
```
2
```
**Explanation:** Subarrays are `[1, 2]` (sum = 3) and `[3]` (sum = 3).

### Example 3
**Input:**
```
1 -1 0
0
```
**Output:**
```
3
```
**Explanation:** Subarrays with sum 0 are `[1, -1]`, `[0]`, and `[1, -1, 0]`.

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ — Single pass across the array.
- **Space Complexity:** $\mathcal{O}(N)$ — To store prefix sum frequencies in the hash map.
