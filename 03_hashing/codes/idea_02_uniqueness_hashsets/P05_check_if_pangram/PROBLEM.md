# Check if the Sentence Is Pangram (LeetCode 1832)

## Problem Statement
A **pangram** is a sentence where every letter of the English alphabet appears at least once.

Given a string `sentence` containing only lowercase English letters, return `true` if `sentence` is a **pangram**, or `false` otherwise.

## Mental Model & Fixed Universe Invariant
- **The Alphabet Universe**: The English alphabet consists of exactly $26$ distinct lowercase letters ($'a'$ through $'z'$).
- **HashSet Cardinality Invariant**:
  - Insert every character of `sentence` into a `HashSet<Character> seen`.
  - The set automatically deduplicates repeated characters.
  - At the end of the pass, `sentence` is a pangram if and only if `seen.size() == 26`.
- **Bounded Universe Optimization**:
  - Because the universe of keys is strictly bounded to the $26$ ASCII characters $[ 'a' \dots 'z' ]$, a simple `boolean[26]` array functions as an allocation-free hash set, executing in $\mathcal{O}(1)$ space and avoiding object boxing.

## Input Format
```
A single string sentence consisting of lowercase English letters.
```

## Output Format
```
true if sentence is a pangram, otherwise false.
```

## Constraints
- $1 \le \text{sentence.length} \le 1000$
- `sentence` consists only of lowercase English letters (`'a'` to `'z'`).

## Examples
### Example 1
**Input:**
```
thequickbrownfoxjumpsoverthelazydog
```
**Output:**
```
true
```
**Explanation:** `sentence` contains at least one of every letter from `'a'` to `'z'`.

### Example 2
**Input:**
```
leetcode
```
**Output:**
```
false
```
**Explanation:** `sentence` does not contain `'a'`, `'b'`, `'f'`, etc.

### Example 3
**Input:**
```
abcdefghijklmnopqrstuvwxyz
```
**Output:**
```
true
```

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ where $N$ is the length of `sentence`.
- **Space Complexity:** $\mathcal{O}(1)$ auxiliary space, bounded by the alphabet size $|\Sigma| = 26$.
