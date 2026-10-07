# Two Sum (Sorted Array) — LeetCode 167

## Problem Statement
Given a **sorted** (non-decreasing) 1-indexed array of integers and a `target` sum, return the **1-based indices** `[left, right]` of the two numbers that add up to `target`. Exactly one solution is guaranteed.

## Input Format
```
N
a[0] a[1] ... a[N-1]
target
```

## Output Format
```
<left> <right>   (1-based indices)
```

## Constraints
- `2 ≤ N ≤ 3 × 10^4`
- `-1000 ≤ a[i] ≤ 1000`
- `-1000 ≤ target ≤ 1000`
- Exactly one valid pair exists.

## Examples

### Example 1
**Input:**
```
4
2 7 11 15
18
```
**Output:**
```
2 3
```
**Explanation:** numbers[2]+numbers[3] = 7+11 = 18.

## Algorithm
Start with `left=0`, `right=N-1`. If sum < target, `left++`. If sum > target, `right--`. If equal, return.
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)
