# Linear Probing Hash Table

## Problem Statement
Unlike Separate Chaining, which uses auxiliary linked lists, **Linear Probing** is an **Open Addressing** technique where all elements reside directly within a single contiguous flat array. When a collision occurs at index $h$, the algorithm sequentially probes adjacent slots:
$$h_i = (h + i) \pmod M \quad \text{for } i = 0, 1, 2, \dots$$
until an empty slot is located.

Implement a hash table of fixed capacity $M$ using Linear Probing with the ASCII sum modulo $M$ hash function:
$$\text{hash}(s) = \left( \sum_{i=0}^{|s|-1} \text{ASCII}(s[i]) \right) \pmod M$$

The table supports two operations:
1. `PUT key`: Inserts the string `key` into the table. If `key` is already present, do nothing. If the table is full, output `FULL`.
2. `CONTAINS key`: Returns `true` if `key` exists in the table, or `false` otherwise.

## Mental Model & Probing Invariant
- **Flat Memory Layout**: Zero pointers, zero heap node allocations. All keys are stored directly in `String[] table`.
- **Search Termination Invariant**:
  - A search begins at the preferred hash slot $h = \text{hash}(\text{key})$.
  - If `table[h]` matches `key`, return `true`.
  - If `table[h]` contains a different key, probe the next seat: $(h + 1) \pmod M$.
  - **Crucial Rule**: Encountering an **empty slot (`null`)** guarantees that `key` was never inserted into the table, allowing search to immediately terminate with `false`!
- **Cache Locality**: Sequential array scans provide near-optimal CPU L1 cache line prefetching.

## Input Format
```
Line 1: Two integers M (table capacity) and Q (number of operations).
The next Q lines each contain an operation:
  - PUT key
  - CONTAINS key
```

## Output Format
```
For each CONTAINS operation, output true or false on a new line.
If a PUT operation is performed on a completely full table without finding the key, output FULL.
```

## Constraints
- $1 \le M \le 1000$
- $1 \le Q \le 10^4$
- $1 \le |key| \le 100$

## Examples
### Example 1
**Input:**
```
5 5
PUT cat
PUT act
CONTAINS cat
CONTAINS act
CONTAINS dog
```
**Output:**
```
true
true
false
```
**Explanation:** `"cat"` and `"act"` both hash to index $2$. `"cat"` occupies slot 2. When `"act"` arrives, slot 2 is busy, so it probes to slot 3 and is inserted there. Both are successfully found. `"dog"` hashes to slot 4, which is empty, so `CONTAINS dog` terminates immediately with `false`.

### Example 2
**Input:**
```
3 4
PUT a
PUT b
CONTAINS a
CONTAINS c
```
**Output:**
```
true
false
```

## Complexity
- **Time Complexity:**
  - $\mathcal{O}(1)$ average for `PUT` and `CONTAINS` when load factor $\alpha = N/M < 0.7$.
  - $\mathcal{O}(M)$ worst-case under primary clustering as the table fills up.
- **Space Complexity:** $\mathcal{O}(M)$ — Flat array with zero pointer overhead.
