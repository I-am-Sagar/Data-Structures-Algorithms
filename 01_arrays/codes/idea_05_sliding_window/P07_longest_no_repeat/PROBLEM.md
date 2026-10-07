# Longest Substring Without Repeating Characters

## Problem Statement
Given an ASCII string, find the length of its longest substring with no repeated character.

## Input Format
```
s
```

## Output Format
Print the maximum length.

## Constraints
- `1 <= |s| <= 10^5`
- `s` uses 7-bit ASCII characters.

## Example
```
Input
abcabcbb

Output
3
```

## Algorithm
Maintain a window whose characters are all marked in a boolean array. Remove from the left until the incoming character is absent.

- Time: `O(N)`
- Space: `O(1)`

