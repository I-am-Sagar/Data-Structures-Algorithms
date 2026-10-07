# Count Occurrences of Anagrams

## Problem Statement
Given lowercase strings `s` and `p`, count the substrings of `s` that are anagrams of `p`.

## Input Format
```
s
p
```

## Output Format
Print the number of matching substrings.

## Constraints
- `1 <= |p| <= |s| <= 10^5`
- Both strings contain lowercase English letters.

## Example
```
Input
cbaebabacd
abc

Output
2
```
The matching windows are `cba` and `bac`.

## Algorithm
Compare the 26-character frequency arrays for each fixed-size window of length `|p|`.

- Time: `O(|s|)`
- Space: `O(1)`

