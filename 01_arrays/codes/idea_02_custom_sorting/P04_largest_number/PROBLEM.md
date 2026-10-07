# Largest Number (LeetCode 179)

## Problem Statement
Given a list of **non-negative integers**, arrange them such that they form the **largest possible number** when concatenated, and return it as a string.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
```
<largest number as a string>
```

## Constraints
- `1 ≤ N ≤ 100`
- `0 ≤ a[i] ≤ 10^9`

## Examples

### Example 1
**Input:**
```
5
3 30 34 5 9
```
**Output:**
```
9534330
```

### Example 2
**Input:**
```
3
0 0 0
```
**Output:**
```
0
```

### Example 3
**Input:**
```
2
9 98
```
**Output:**
```
998
```
**Explanation:** "9"+"98"="998" > "98"+"9"="989". So 9 comes first.

## Algorithm
Convert integers to strings. Sort with comparator `(a,b) -> (b+a).compareTo(a+b)`.
The concatenation invariant: if `A+B > B+A`, then A should come before B.
- **Time Complexity:** O(N log N · K) where K = average string length
- **Space Complexity:** O(N)
