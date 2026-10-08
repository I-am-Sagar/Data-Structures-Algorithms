# Longest ZigZag Path in a Binary Tree (LeetCode 1372)

## Problem Statement
A ZigZag path for a binary tree is defined as follow:
1. Choose any node in the binary tree and a direction (right or left).
2. If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
3. Change the direction from right to left or from left to right.
4. Repeat the second and third steps until you cannot move in the tree.
Zigzag length is defined as the number of nodes visited - 1 (a single node has length 0).
Return the longest ZigZag path contained in the tree.
