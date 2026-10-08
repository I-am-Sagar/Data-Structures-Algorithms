# First Unique Character in a String (LeetCode 387)

## Problem Statement
Given a string `s`, find the **first non-repeating character** in it and return its **index**. If it does not exist, return `-1`.

## Mental Model & The Two-Pass Frequency Invariant
- **Why One Pass is Insufficient**: At index 0, encountering `'l'` provides local visibility, but we cannot know whether `'l'` reappears at index 10 without looking ahead.
- **Pass 1 (Global Frequency Accumulation)**:
  - Traverse the entire string once to record frequency counts in a `HashMap<Character, Integer>` using the idiomatic pattern:
    `count.put(c, count.getOrDefault(c, 0) + 1);`
- **Pass 2 (Chronological Invariant Verification)**:
  - Scan `s` a second time from index $0$ to $N-1$.
  - Query `count.get(s.charAt(i))`. The very first index where $\text{frequency} == 1$ is guaranteed to be the earliest non-repeating character in chronological order!
  - If the loop finishes without finding any frequency equal to 1, return `-1`.

## Input Format
```
A single string s consisting of lowercase English letters.
```

## Output Format
```
A single integer representing the 0-based index of the first non-repeating character, or -1.
```

## Constraints
- $1 \le s.\text{length} \le 10^5$
- `s` consists of only lowercase English letters.

## Examples
### Example 1
**Input:**
```
leetcode
```
**Output:**
```
0
```
**Explanation:** The character `'l'` at index 0 appears only once in the entire string.

### Example 2
**Input:**
```
loveleetcode
```
**Output:**
```
2
```
**Explanation:** `'l'` and `'o'` repeat later. The character `'v'` at index 2 is the first unique character.

### Example 3
**Input:**
```
aabb
```
**Output:**
```
-1
```
**Explanation:** Every character appears more than once.

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ — Two sequential passes over the string of length $N$.
- **Space Complexity:** $\mathcal{O}(|\Sigma|) = \mathcal{O}(1)$ — At most $26$ distinct lowercase English characters in the hash map.
