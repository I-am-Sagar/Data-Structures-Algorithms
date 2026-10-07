# Aggressive Cows (SPOJ AGGRCOW / GFG)

## Problem Statement
Given `N` stall positions and `C` cows, place the cows in the stalls such that the **minimum distance between any two cows is maximized**.

## Input Format
```
N C
x[0] x[1] ... x[N-1]
```

## Output Format
```
<maximum minimum distance>
```

## Constraints
- `2 ≤ C ≤ N ≤ 10^5`
- `0 ≤ x[i] ≤ 10^9`
- All stall positions are distinct.

## Examples

### Example 1
**Input:**
```
5 3
1 2 4 8 9
```
**Output:**
```
3
```
**Explanation:** Place cows at positions 1, 4, 8. Minimum distance = min(3, 4) = 3.

### Example 2
**Input:**
```
4 2
1 10 5 20
```
**Output:**
```
19
```

## Algorithm
Binary search on the answer (minimum distance `D`). Feasibility check: greedily place cows — if next stall is at least `D` away, place a cow.
- **Time Complexity:** O(N log N + N log(max_stall))
- **Space Complexity:** O(1)
