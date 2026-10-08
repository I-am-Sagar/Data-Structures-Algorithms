# Contains Duplicate (LeetCode 217)

## Problem Statement
Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

## Mental Model & The Uniqueness Invariant
- **The "Seen" Set Pattern**: As we stream across the array, we maintain a `Set<Integer> seen` tracking every element encountered so far.
- **Atomic Insertion & Membership Check**: In Java, `seen.add(x)` returns:
  - `true` if $x$ was newly added (first time observed).
  - `false` if $x$ was already present (a duplicate has been detected!).
- **Early-Exit Optimization**: The moment `!seen.add(x)` triggers, we immediately return `true` without scanning the remainder of the array.

## Input Format
```
A single line containing space-separated integers representing the array nums.
(An empty line represents an empty array).
```

## Output Format
```
true if the array contains any duplicate, otherwise false.
```

## Constraints
- $1 \le \text{nums.length} \le 10^5$
- $-10^9 \le \text{nums}[i] \le 10^9$

## Examples
### Example 1
**Input:**
```
1 2 3 1
```
**Output:**
```
true
```
**Explanation:** Element $1$ appears at index 0 and index 3.

### Example 2
**Input:**
```
1 2 3 4
```
**Output:**
```
false
```
**Explanation:** All elements are pairwise distinct.

### Example 3
**Input:**
```
1 1 1 3 3 4 3 2 4 2
```
**Output:**
```
true
```

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ worst-case, $\mathcal{O}(1)$ best-case on early exit.
- **Space Complexity:** $\mathcal{O}(N)$ to store up to $N$ unique entries in the hash set.
