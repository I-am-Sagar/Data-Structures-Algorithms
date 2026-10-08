# Group Anagrams (LeetCode 49)

## Problem Statement
Given an array of strings `strs`, group the **anagrams** together. You can return the answer in **any order**.

An **anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

## Mental Model & The Canonical Signature Invariant
- **Multi-Map Pattern (`Map<Key, List<Item>>`)**: We want to partition the input collection into equivalence classes (buckets).
- **Canonical Equivalence Signature**:
  - Two words $s_1$ and $s_2$ are anagrams if and only if their sorted character representations are identical.
  - Sorting the letters of `"eat"`, `"tea"`, and `"ate"` yields the identical signature string: `"aet"`.
- **The Grouping Invariant**:
  - For each string $s$, compute its canonical signature `key`.
  - Append $s$ to the bucket corresponding to `key` using Java's idiomatic `computeIfAbsent`:
    `map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);`
  - Finally, return all bucket lists: `new ArrayList<>(map.values())`.
- **Deterministic Verification**: For automated testing, words within each group are printed in alphabetical order, and groups are printed sorted by their first element.

## Input Format
```
A single line containing space-separated strings.
(If an element is an empty string, it is represented as "").
```

## Output Format
```
Each anagram group printed on its own line as space-separated words.
Within each line, words are sorted alphabetically.
Lines are sorted lexicographically by their first word.
```

## Constraints
- $1 \le \text{strs.length} \le 10^4$
- $0 \le \text{strs}[i].\text{length} \le 100$
- `strs[i]` consists of lowercase English letters.

## Examples
### Example 1
**Input:**
```
eat tea tan ate nat bat
```
**Output:**
```
ate eat tea
bat
nat tan
```
**Explanation:**
- `"eat"`, `"tea"`, `"ate"` all have signature `"aet"`.
- `"bat"` has signature `"abt"`.
- `"tan"`, `"nat"` both have signature `"ant"`.

### Example 2
**Input:**
```
a
```
**Output:**
```
a
```

## Complexity
- **Time Complexity:** $\mathcal{O}(N \cdot K \log K)$ where $N = \text{strs.length}$ and $K$ is the maximum length of a word in `strs`.
- **Space Complexity:** $\mathcal{O}(N \cdot K)$ to store keys and lists in the hash map.
