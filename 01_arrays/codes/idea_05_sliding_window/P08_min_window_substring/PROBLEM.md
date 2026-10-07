# Minimum Window Substring

## Problem Statement
Given ASCII strings `s` and `t`, print the shortest substring of `s` that contains every character of `t`, including duplicate characters. Print `EMPTY` if no such window exists.

## Input Format
```
s
t
```

## Output Format
Print the shortest valid substring, or `EMPTY`.

## Constraints
- `1 <= |s|, |t| <= 10^5`
- Strings use 7-bit ASCII characters.

## Example
```
Input
ADOBECODEBANC
ABC

Output
BANC
```

## Algorithm
Expand until the window covers `t`, then repeatedly contract from the left while it stays valid.

- Time: `O(|s| + |t|)`
- Space: `O(1)` for the fixed ASCII frequency table

