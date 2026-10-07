# Sort Strings by Length then Lexicographically

## Problem Statement
Given `N` strings, sort them first by **ascending length** and, for equal lengths, **alphabetically (lexicographically)**.

## Input Format
```
N
word_1 word_2 ... word_N
```

## Output Format
```
word_1 word_2 ... word_N
```

## Constraints
- `1 ≤ N ≤ 10^4`
- `1 ≤ |word_i| ≤ 100`
- Words contain only lowercase English letters.

## Examples

### Example 1
**Input:**
```
5
kiwi pear fig apple plum
```
**Output:**
```
fig kiwi pear plum apple
```
**Explanation:** fig(3) < kiwi/pear/plum(4, sorted lex) < apple(5).

## Algorithm
Cascading comparator: primary key = length, secondary key = `a.compareTo(b)`.
- **Time Complexity:** O(N log N)
