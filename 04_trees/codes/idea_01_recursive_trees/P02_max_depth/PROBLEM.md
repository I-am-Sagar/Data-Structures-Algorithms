# Maximum Depth of Binary Tree (LeetCode 104)

## Problem Statement
Given the root of a binary tree, return its **maximum depth**. The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Mental Model
- **Base Case:** An empty tree has depth `0`.
- **Inductive Rule:** Depth at current node is $1 + \max(\text{depth}(\text{left}), \text{depth}(\text{right}))$.

## Constraints
- $0 \le N \le 10^4$
- $-100 \le \text{Node.val} \le 100$

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$
- **Space Complexity:** $\mathcal{O}(H)$
