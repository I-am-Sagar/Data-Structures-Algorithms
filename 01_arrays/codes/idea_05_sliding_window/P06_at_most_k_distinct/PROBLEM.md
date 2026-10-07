# Longest Substring with At Most K Distinct Characters

## Problem Statement
Given a string `s` and integer `K`, find the length of the longest substring containing at most `K` distinct characters.

## Input Format
```
s
K
```

## Output Format
Print the maximum length.

## Constraints
- `1 <= |s| <= 10^5`
- `0 <= K <= 128`
- `s` uses ASCII characters.

## Example
```
Input
eceba
2

Output
3
```
`ece` has two distinct characters.

## Algorithm
Track character frequencies in the active window. Contract it until it has at most `K` distinct characters.

- Time: `O(N)`
- Space: `O(K)`

