# Sort Strings by Length

## Problem Statement
Given `N` strings, sort them in **ascending order of their lengths**. If two strings have the same length, their relative order is undefined (any valid order is accepted).

## Input Format
```
N
word_1 word_2 ... word_N
```

## Output Format
```
word_1 word_2 ... word_N   (sorted by ascending length)
```

## Constraints
- `1 ≤ N ≤ 10^4`
- `1 ≤ |word_i| ≤ 100`
- Words contain only lowercase English letters.

## Examples

### Example 1
**Input:**
```
4
banana apple fig kiwi
```
**Output:**
```
fig kiwi apple banana
```
**Explanation:** Lengths are 6, 5, 3, 4 → sorted: 3, 4, 5, 6.

### Example 2
**Input:**
```
3
dog elephant cat
```
**Output:**
```
dog cat elephant
```

## Algorithm
Use `Arrays.sort` with a custom lambda: `(a, b) -> Integer.compare(a.length(), b.length())`.
- **Time Complexity:** O(N log N)
- **Space Complexity:** O(N) for object references
