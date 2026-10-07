# Rhyming Words (Suffix Sorting)

## Problem Statement
Given `N` words, sort them so that **rhyming words** (words sharing the same suffix/ending) appear **adjacent** to each other.

**Technique**: By reversing each word inside the comparator and comparing lexicographically, suffix matching transforms into standard prefix sorting — rhyming words cluster together.

## Input Format
```
N
word_1 word_2 ... word_N
```

## Output Format
```
word_1 word_2 ... word_N   (suffix-grouped order)
```

## Constraints
- `1 ≤ N ≤ 10^4`
- `1 ≤ |word_i| ≤ 50`
- Words contain only lowercase English letters.

## Examples

### Example 1
**Input:**
```
5
rate bat date cat mat
```
**Output:**
```
bat cat mat date rate
```
**Explanation:** "bat","cat","mat" share suffix "-at"; "date","rate" share suffix "-ate".

## Algorithm
Comparator: `revA.compareTo(revB)` where `revA = new StringBuilder(a).reverse().toString()`.
- **Time Complexity:** O(N log N · K) where K = average word length
