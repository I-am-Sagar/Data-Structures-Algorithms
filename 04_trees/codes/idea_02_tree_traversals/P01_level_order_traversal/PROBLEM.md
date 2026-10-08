# Binary Tree Level Order Traversal (LeetCode 102)

## Problem Statement
Given the root of a binary tree, return the level order traversal of its nodes' values (i.e., from left to right, level by level). Each level should be printed on a new line.

## Mental Model
- Use a FIFO `Queue<TreeNode>`.
- **Level-Switching Invariant:** Freeze `int levelSize = queue.size()` at the start of each level loop.
- Pop exactly `levelSize` elements; push non-null children.
