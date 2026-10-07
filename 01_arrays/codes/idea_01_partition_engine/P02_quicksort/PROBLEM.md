# QuickSort (Lomuto Partition)

## Problem Statement
Sort an array of `N` integers in **non-decreasing order** using QuickSort with the **Lomuto partition scheme**.

## Background
QuickSort follows a Divide & Conquer strategy:
1. **Partition**: Choose `arr[high]` as pivot. Rearrange elements so all values `< pivot` are to its left and all values `≥ pivot` are to its right. The pivot lands in its final sorted index `pIndex`.
2. **Recurse**: Independently sort `arr[low..pIndex-1]` and `arr[pIndex+1..high]`.
3. **Combine**: No extra merge step needed.

**Lomuto Partition Invariant**: Boundary pointer `i` tracks the next empty slot in the left (smaller) partition. Scanner `j` walks all elements. If `arr[j] < pivot`, swap `arr[i]` and `arr[j]`, then `i++`.

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
- `1 ≤ N ≤ 10^5`
- `-10^9 ≤ a[i] ≤ 10^9`

## Examples

### Example 1
**Input:**
```
5
4 7 2 6 3
```
**Output:**
```
2 3 4 6 7
```

### Example 2
**Input:**
```
6
10 80 30 90 40 50
```
**Output:**
```
10 30 40 50 80 90
```

## Algorithm
- **Time Complexity:** O(N log N) average — O(N²) worst case (already sorted input with Lomuto).
- **Space Complexity:** O(log N) average recursion stack depth.
