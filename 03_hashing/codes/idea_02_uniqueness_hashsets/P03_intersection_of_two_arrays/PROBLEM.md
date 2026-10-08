# Intersection of Two Arrays (LeetCode 349)

## Problem Statement
Given two integer arrays `nums1` and `nums2`, return an array of their **intersection**. Each element in the result must be **unique**, and you may return the result in **any order** (for verification, our runner displays elements in sorted ascending order).

## Mental Model & Dual-Set Filtering
- **Query Oracle Construction**: Insert all elements of `nums1` into a `HashSet<Integer> set1`. This pre-processing step converts arbitrary membership queries into $\mathcal{O}(1)$ average-time operations.
- **Probe and Filter**: Iterate through `nums2`. For each element $x$:
  - If `set1.contains(x)` is `true`, $x$ belongs to both arrays!
  - Add $x$ to a `HashSet<Integer> resultSet`. The set automatically eliminates duplicate matches from `nums2`.
- **Result Extraction**: Convert `resultSet` into the output array.

## Input Format
```
Line 1: Space-separated integers representing nums1.
Line 2: Space-separated integers representing nums2.
(If an array is empty, the corresponding line is blank).
```

## Output Format
```
Space-separated integers representing the unique intersection elements in sorted ascending order.
If the intersection is empty, print a blank line.
```

## Constraints
- $1 \le \text{nums1.length}, \text{nums2.length} \le 1000$
- $0 \le \text{nums1}[i], \text{nums2}[i] \le 1000$

## Examples
### Example 1
**Input:**
```
1 2 2 1
2 2
```
**Output:**
```
2
```
**Explanation:** Only $2$ appears in both arrays. Each element in the result must be unique.

### Example 2
**Input:**
```
4 9 5
9 4 9 8 4
```
**Output:**
```
4 9
```
**Explanation:** Elements $4$ and $9$ are shared by both arrays.

### Example 3
**Input:**
```
1 3 5
2 4 6
```
**Output:**
```

```
**Explanation:** Disjoint sets have no intersection elements.

## Complexity
- **Time Complexity:** $\mathcal{O}(N + M)$ average where $N = |\text{nums1}|$ and $M = |\text{nums2}|$.
- **Space Complexity:** $\mathcal{O}(N + \min(N, M))$ to maintain `set1` and `resultSet`.
