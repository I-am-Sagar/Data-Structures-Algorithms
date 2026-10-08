# Find Maximum Element in Binary Tree

## Problem Statement
Given the root of a binary tree, find and return the **maximum element value** present in the tree.

## Mental Model
- Base Case: For `null`, return identity element for max: `Integer.MIN_VALUE`.
- Composition: `Math.max(root.val, Math.max(maxVal(left), maxVal(right)))`.

## Constraints
- $1 \le N \le 10^4$
- $-10^9 \le \text{Node.val} \le 10^9$
