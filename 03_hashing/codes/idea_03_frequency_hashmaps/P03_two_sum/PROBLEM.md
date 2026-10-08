# Two Sum (LeetCode 1)

## Problem Statement
Given an array of integers `nums` and an integer `target`, return **indices of the two numbers** such that they add up to `target`.

You may assume that each input would have **exactly one solution**, and you may not use the same element twice.

You can return the answer in any order (for testing, return indices in the exact form `[index1, index2]` with `index1 < index2`).

## Mental Model & The Complement Lookup Invariant
- **Algebraic Reframing**: Instead of searching for two arbitrary numbers $x + y = \text{target}$ in $\mathcal{O}(N^2)$ nested loops, rewrite the equation for any current number $nums[i]$:
  $$\text{complement} = \text{target} - nums[i]$$
- **The One-Pass Invariant**:
  - Maintain a `HashMap<Integer, Integer> map` storing each previously encountered number mapped to its index: $\{ \text{value} \to \text{index} \}$.
  - On element $i$:
    1. Query `map.containsKey(complement)`.
    2. If found, the solution is immediate: `[map.get(complement), i]`.
    3. If absent, record `map.put(nums[i], i)` and proceed.
- **Prevention of Self-Pairing**: Because we query the complement *before* adding $nums[i]$ into the map, an element can never falsely pair with itself (e.g. If $\text{target} = 6$ and $nums[i] = 3$, it will not match itself unless another 3 appeared earlier).

## Input Format
```
Line 1: Space-separated integers representing nums.
Line 2: An integer target.
```

## Output Format
```
Two space-separated integers representing the 0-based indices of the matching pair.
```

## Constraints
- $2 \le \text{nums.length} \le 10^4$
- $-10^9 \le \text{nums}[i] \le 10^9$
- $-10^9 \le \text{target} \le 10^9$
- Exactly one valid answer exists.

## Examples
### Example 1
**Input:**
```
2 7 11 15
9
```
**Output:**
```
0 1
```
**Explanation:** Because `nums[0] + nums[1] == 2 + 7 == 9`, we return `0 1`.

### Example 2
**Input:**
```
3 2 4
6
```
**Output:**
```
1 2
```
**Explanation:** `nums[1] + nums[2] == 2 + 4 == 6`.

### Example 3
**Input:**
```
3 3
6
```
**Output:**
```
0 1
```

## Complexity
- **Time Complexity:** $\mathcal{O}(N)$ — Single linear scan with $\mathcal{O}(1)$ average hash map queries.
- **Space Complexity:** $\mathcal{O}(N)$ — Auxiliary hash map storing at most $N$ entries.
