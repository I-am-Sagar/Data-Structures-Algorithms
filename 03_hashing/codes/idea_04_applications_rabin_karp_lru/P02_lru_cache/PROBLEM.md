# LRU Cache (LeetCode 146)

## Problem Statement
Design a data structure that follows the constraints of a **Least Recently Used (LRU) cache**.

Implement the `LRUCache` class:
- `LRUCache(int capacity)`: Initialize the LRU cache with positive size `capacity`.
- `int get(int key)`: Return the value of the `key` if the key exists, otherwise return `-1`.
- `void put(int key, int value)`: Update the value of the `key` if the `key` exists. Otherwise, add the `key-value` pair to the cache. If the number of keys exceeds the `capacity` from this operation, **evict the least recently used key**.

The functions `get` and `put` must each run in **$\mathcal{O}(1)$ average time complexity**.

## Mental Model & The Hybrid Data Structure
- **The Core Conflict**:
  - A `HashMap` provides $\mathcal{O}(1)$ lookup by key, but has no concept of access recency or temporal ordering.
  - A linked list maintains strict temporal order, but searching for an arbitrary node takes $\mathcal{O}(N)$ time.
- **The Hybrid Solution (`HashMap<Key, Node>` + Doubly Linked List)**:
  - The hash map stores `{ key -> Node memory reference }`. This eliminates linear list traversal, letting us reach any node in $\mathcal{O}(1)$ time.
  - The Doubly Linked List maintains temporal ordering:
    - **MRU (Most Recently Used)**: Immediately after `dummyHead`.
    - **LRU (Least Recently Used)**: Immediately before `dummyTail`.
  - Dummy sentinel nodes (`dummyHead` and `dummyTail`) eliminate all null checks and edge-case branches during insertion and removal.
- **Atomic Pointer Surgery**:
  - `remove(node)`: Unlinks `node` from its current position in $\mathcal{O}(1)$ operations.
  - `insertAtHead(node)`: Slices `node` right behind `dummyHead` in $\mathcal{O}(1)$ operations.
  - `moveToHead(node)`: Promotes a accessed node to MRU by composing `remove(node)` followed by `insertAtHead(node)`.

## Input Format
```
Line 1: Two integers: capacity and Q (number of operations).
The next Q lines contain commands:
  - put key value
  - get key
```

## Output Format
```
For each get operation, print the retrieved value (or -1) on a new line.
```

## Constraints
- $1 \le \text{capacity} \le 3000$
- $0 \le \text{key} \le 10^4$
- $0 \le \text{value} \le 10^5$
- At most $2 \times 10^5$ calls will be made to `get` and `put`.

## Examples
### Example 1
**Input:**
```
2 8
put 1 1
put 2 2
get 1
put 3 3
get 2
put 4 4
get 1
get 3
```
**Output:**
```
1
-1
-1
3
```
**Explanation:**
- `put(1, 1)`: Cache is `[1:1]`
- `put(2, 2)`: Cache is `[2:2, 1:1]`
- `get(1)`: Returns 1. Cache becomes `[1:1, 2:2]`
- `put(3, 3)`: Evicts key 2 (LRU). Cache becomes `[3:3, 1:1]`
- `get(2)`: Returns -1 (not found)
- `put(4, 4)`: Evicts key 1 (LRU). Cache becomes `[4:4, 3:3]`
- `get(1)`: Returns -1 (not found)
- `get(3)`: Returns 3

### Example 2
**Input:**
```
1 4
put 2 1
get 2
put 3 2
get 2
```
**Output:**
```
1
-1
```

## Complexity
- **Time Complexity:** strictly $\mathcal{O}(1)$ for both `get` and `put`.
- **Space Complexity:** $\mathcal{O}(\text{capacity})$ to store up to `capacity` nodes and hash map entries.
