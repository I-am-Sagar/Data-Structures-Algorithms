# Happy Number (LeetCode 202)

## Problem Statement
Write an algorithm to determine if a positive integer $n$ is a **happy number**.

A **happy number** is a number defined by the following process:
1. Starting with any positive integer, replace the number by the sum of the squares of its digits.
2. Repeat the process until the number equals $1$ (where it will stay), or it **loops endlessly in a cycle** which does not include $1$.
3. Those numbers for which this process ends in $1$ are happy numbers.

Return `true` if $n$ is a happy number, and `false` if not.

## Mental Model & The Cycle Detection Invariant
- **Discrete State Transition**: Every number $n$ transitions deterministically to a next state $f(n) = \sum d_i^2$.
- **Graph Topology**: Because $f(n) < n$ for all $n \ge 100$, the state space is strictly finite ($\le 243$ for 3-digit numbers). Therefore, the sequence must either:
  1. Reach state $1$ (Happy!).
  2. Enter a directed cycle of recurring numbers (Unhappy!).
- **Seen Set Cycle Invariant**:
  A cycle occurs if and only if we encounter an integer $n$ that was **already observed in a previous iteration**.
  By testing `seen.add(n)` on each step:
  - If `n` is novel, `seen.add(n)` returns `true` and the simulation continues.
  - If `n` was previously visited, `seen.add(n)` returns `false`, immediately breaking the `while` loop!

## Input Format
```
A single positive integer n.
```

## Output Format
```
true if n is a happy number, otherwise false.
```

## Constraints
- $1 \le n \le 2^{31} - 1$

## Examples
### Example 1
**Input:**
```
19
```
**Output:**
```
true
```
**Explanation:**
- $1^2 + 9^2 = 82$
- $8^2 + 2^2 = 68$
- $6^2 + 8^2 = 100$
- $1^2 + 0^2 + 0^2 = 1$ (Terminates at 1)

### Example 2
**Input:**
```
2
```
**Output:**
```
false
```
**Explanation:** $2 \to 4 \to 16 \to 37 \to 58 \to 89 \to 145 \to 42 \to 20 \to 4$ (Enters the cycle containing 4).

## Complexity
- **Time Complexity:** $\mathcal{O}(\log n)$ — The sum of squared digits shrinks quickly to bounded states $\le 243$, after which cycle detection takes at most $\mathcal{O}(1)$ steps.
- **Space Complexity:** $\mathcal{O}(\log n)$ — Bounded hash set of visited states.
