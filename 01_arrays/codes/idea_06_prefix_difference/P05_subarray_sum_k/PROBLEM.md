# Subarray Sum Equals K

## Problem Statement
Given an integer array and integer K, count the contiguous subarrays whose sum is exactly K.

## Input Format
    N K
    a[0] a[1] ... a[N-1]

## Output Format
Print the count.

## Constraints
- 1 <= N <= 20000
- -1000 <= a[i] <= 1000
- -10000000 <= K <= 10000000

## Example
Input:
    3 2
    1 1 1

Output:
    2

## Algorithm
For each prefix sum P, a previous prefix of P - K identifies a subarray ending here with sum K. Store prefix frequencies in a hash map.

- Time: O(N) expected
- Space: O(N)

