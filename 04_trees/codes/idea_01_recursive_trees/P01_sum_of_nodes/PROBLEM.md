# Sum of All Nodes in Binary Tree

## Problem Statement
Given the root of a binary tree, return the **sum of all values** of the nodes in the tree.

## Mental Model & Subtree Composition
A binary tree is defined recursively:
- A tree is composed of a `root`, a `left` subtree, and a `right` subtree.
- **Base Case:** An empty subtree (`root == null`) contributes `0` to the sum.
- **Subtree Recurrence:** $\text{sum}(\text{root}) = \text{root.val} + \text{sum}(\text{root.left}) + \text{sum}(\text{root.right})$.

## Input Format
```
A single line with level-order traversal of the tree, using 'null' for missing children.
```

## Output Format
```
A single integer representing the sum of all node values.
```

## Constraints
- $0 \le N \le 10^4$
- $-10^4 \le \text{Node.val} \le 10^4$

## Examples
### Example 1
**Input:**
```
4 2 5 1 null null null
```
**Output:**
```
12
```
**Explanation:** Total sum = $4 + 2 + 5 + 1 = 12$.

### Example 2
**Input:**
```
null
```
**Output:**
```
0
```

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ — Each node visited exactly once.
- **Space Complexity:** $\mathcal{O}(H)$ — Recursion call stack bounded by tree height $H$.
