# Unique Binary Search Trees Count (LeetCode 96)

## Problem Statement
Given an integer `n`, return the number of structurally unique **BST's** (binary search trees) which have exactly `n` nodes of unique values from `1` to `n`.

## Mental Model
- The answer is the $n$-th Catalan number $C_n$.
- Recurrence: $C_n = \sum_{i=0}^{n-1} C_i C_{n-1-i}$, with $C_0 = 1, C_1 = 1$.
