# Valid Anagram (LeetCode 242)

## Problem Statement
Given two strings `s` and `t`, return `true` if `t` is an **anagram** of `s`, and `false` otherwise.

An **anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Mental Model & The Balance Sheet Invariant
- **Length Pre-condition**: Anagrams must possess identical lengths. If `s.length() != t.length()`, return `false` immediately.
- **Supply & Consume Metaphor**:
  - String $s$ produces characters (increment frequency in `map`).
  - String $t$ consumes characters (decrement frequency in `map`).
- **The Zero-Balance Invariant**:
  - When scanning $t$, if any character $c$ has `count == 0` (or is absent from the map), $t$ demands more copies than $s$ supplied $\to$ return `false`!
  - Because lengths are matched up front, if no character ever drops below zero, then every character must end at exactly zero balance. Hence, `return true`.

## Input Format
```
Line 1: String s
Line 2: String t
```

## Output Format
```
true if t is an anagram of s, otherwise false.
```

## Constraints
- $1 \le s.\text{length}, t.\text{length} \le 5 \times 10^4$
- `s` and `t` consist of lowercase English letters.

## Examples
### Example 1
**Input:**
```
anagram
nagaram
```
**Output:**
```
true
```

### Example 2
**Input:**
```
rat
car
```
**Output:**
```
false
```

### Example 3
**Input:**
```
a
ab
```
**Output:**
```
false
```
**Explanation:** Lengths do not match.

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ where $N$ is the length of the strings.
- **Space Complexity:** $\mathcal{O}(|\Sigma|) = \mathcal{O}(1)$ bounded by alphabet size $26$.
