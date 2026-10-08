# Check If Binary Tree is Full (Strict)

## Problem Statement
A binary tree is **Full** (or Strict/Proper) if every node has either strictly **0 or 2 children**. Determine if a given binary tree is full.

## Mental Model
- Leaf node (degree 0): Valid.
- One child node (degree 1): Invalid! Return `false`.
- Two child node (degree 2): Valid if both left and right subtrees are also full.
