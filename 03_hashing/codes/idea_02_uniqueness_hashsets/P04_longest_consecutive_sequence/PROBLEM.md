# Longest Consecutive Sequence (LeetCode 128)

## Problem Statement
Given an unsorted array of integers `nums`, return the length of the **longest consecutive elements sequence**.

You must write an algorithm that runs in **$\mathcal{O}(N)$ time**.

## Mental Model & The Sequence Anchor Pattern
- **Why Sorting is Inadequate**: Sorting achieves $\mathcal{O}(N \log N)$ time, which violates the strict $\mathcal{O}(N)$ complexity bound.
- **The HashSet as an $\mathcal{O}(1)$ Oracle**: Insert all numbers into a `HashSet<Integer> set`.
- **The Anchor Condition (`!set.contains(x - 1)`)**:
  - A number $x$ is the **anchor (start)** of a consecutive streak if and only if $x - 1$ is NOT in the set!
  - If $x - 1 \in \text{set}$, then $x$ is merely an internal node of a longer streak starting earlier. We skip it in $\mathcal{O}(1)$ time!
  - Only when $x$ is an anchor do we enter the `while` loop, checking $x + 1, x + 2, \dots$ until the streak breaks.
- **Strict Linear Complexity**: Every element in the set is visited as an anchor at most once, and traversed as a successor at most once. Hence, total transitions across all loops is at most $2N = \mathcal{O}(N)$.

## Input Format
```
A single line of space-separated integers representing nums.
(An empty line represents an empty array).
```

## Output Format
```
A single integer representing the length of the longest consecutive sequence.
```

## Constraints
- $0 \le \text{nums.length} \le 10^5$
- $-10^9 \le \text{nums}[i] \le 10^9$

## Examples
### Example 1
**Input:**
```
100 4 200 1 3 2
```
**Output:**
```
4
```
**Explanation:** The longest consecutive elements sequence is `[1, 2, 3, 4]`. Its length is $4$.

### Example 2
**Input:**
```
0 3 7 2 5 8 4 6 0 1
```
**Output:**
```
9
```
**Explanation:** The longest sequence is `[0, 1, 2, 3, 4, 5, 6, 7, 8]`. Length is $9$.

### Example 3
**Input:**
```
9 1 4 7 3 -1 0 5 8 -1 6
```
**Output:**
```
7
```
**Explanation:** The sequence is `[3, 4, 5, 6, 7, 8, 9]`. Length is $7$. (`[-1, 0, 1]` has length $3$).

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ — Each number is processed at most twice.
- **Space Complexity:** $\mathcal{O}(N)$ — To store array elements in a hash set.
