# Sort 2D Points by Distance from Origin

## Problem Statement
Given `N` 2D integer points `(x, y)`, sort them in **ascending order of their Euclidean distance** from the origin `(0, 0)`.

**Key insight**: Since `sqrt` is monotonically increasing, comparing `x₁²+y₁²` vs `x₂²+y₂²` gives the same order — no floating-point arithmetic needed.

## Input Format
```
N
x_1 y_1
x_2 y_2
...
x_N y_N
```

## Output Format
Print each point on its own line, sorted by ascending squared distance.
```
(x_1, y_1)
(x_2, y_2)
...
```

## Constraints
- `1 ≤ N ≤ 10^4`
- `-10^4 ≤ x, y ≤ 10^4`

## Examples

### Example 1
**Input:**
```
3
1 1
-1 2
2 -1
```
**Output:**
```
(1, 1)
(2, -1)
(-1, 2)
```
**Explanation:** d²(1,1)=2, d²(2,-1)=5, d²(-1,2)=5. Equal distance: original order used.

## Algorithm
- **Time Complexity:** O(N log N)
- **Space Complexity:** O(N)
