# Container With Most Water (LeetCode 11)

## Problem Statement
Given `N` non-negative integers representing heights of vertical lines, find two lines that together with the x-axis form a container that holds the **most water**.

Container capacity = `(right - left) × min(height[left], height[right])`.

## Input Format
```
N
h[0] h[1] ... h[N-1]
```

## Output Format
```
<maximum water>
```

## Constraints
- `2 ≤ N ≤ 10^5`
- `0 ≤ h[i] ≤ 10^4`

## Examples

### Example 1
**Input:**
```
9
1 8 6 2 5 4 8 3 7
```
**Output:**
```
49
```

### Example 2
**Input:**
```
2
1 1
```
**Output:**
```
1
```

## Algorithm
Greedy bottleneck elimination: always advance the pointer at the shorter bar. Any pair with the shorter bar produces a smaller area than the current (smaller width + non-increasing height).
- **Time Complexity:** O(N)
- **Space Complexity:** O(1)
