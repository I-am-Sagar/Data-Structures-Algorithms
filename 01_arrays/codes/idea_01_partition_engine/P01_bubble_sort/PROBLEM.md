# Bubble Sort

## Problem Statement
Given an array of `N` integers, sort the array in **non-decreasing order** using the Bubble Sort algorithm.

## Background
Bubble Sort is the most brute-force sorting algorithm. The key intuition is:
- Imagine bubbles in a lake — the largest bubble rises to the surface first.
- In each pass, adjacent pairs are compared and swapped if out of order.
- After Pass `k`, the `k`-th largest element is permanently in its final position.

## Input Format
```
N
a[0] a[1] ... a[N-1]
```

## Output Format
```
a[0] a[1] ... a[N-1]   (space-separated, sorted)
```

## Constraints
- `1 ≤ N ≤ 10^4`
- `-10^9 ≤ a[i] ≤ 10^9`

## Examples

### Example 1
**Input:**
```
5
5 2 8 3 1
```
**Output:**
```
1 2 3 5 8
```
**Explanation:** Pass 1 bubbles 8 → index 4. Pass 2 bubbles 5 → index 3. And so on.

### Example 2
**Input:**
```
4
4 3 2 1
```
**Output:**
```
1 2 3 4
```

## Algorithm
- **Time Complexity:** O(N²) — Two nested loops; outer counts passes, inner scans unsorted prefix.
- **Space Complexity:** O(1) — In-place swaps; no extra memory allocated.
