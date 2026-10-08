# Separate Chaining Hash Map

## Problem Statement
When two distinct keys produce the same array index (e.g. `"cat"` and `"act"`), a collision occurs. Instead of overwriting slots, **Separate Chaining** equips every array slot (bucket) with an independent linked list. Colliding elements are chained together within the bucket.

Implement a hash map using Separate Chaining of fixed capacity $M$ with the ASCII sum modulo $M$ hash function:
$$\text{hash}(s) = \left( \sum_{i=0}^{|s|-1} \text{ASCII}(s[i]) \right) \pmod M$$

The map must support the following operations:
1. `PUT key value`: Inserts the key-value pair. If `key` already exists in the chain, update its value.
2. `GET key`: Returns the value associated with `key`, or `-1` if the key is not present.
3. `REMOVE key`: Removes `key` from the chain. Outputs `true` if removed, or `false` if `key` was not found.

## Mental Model & Chain Invariant
- **Bucket Array**: An array of size $M$ where `table[i]` is a pointer to the head of a singly linked list `Node(key, val, next)`.
- **Search Invariant**:
  1. Jump directly to bucket $h = \text{hash}(\text{key})$ in $\mathcal{O}(1)$ time.
  2. Sequentially scan the linked list at `table[h]`.
  3. Under uniform hashing, average chain length is $\alpha = N / M = \mathcal{O}(1)$.
- **Isolation Guarantee**: Collisions in slot 2 (such as `"cat"` and `"act"`) do not displace or contaminate entries in any other slot.

## Input Format
```
Line 1: Two integers M (table capacity) and Q (number of operations).
The next Q lines each describe an operation:
  - PUT key value
  - GET key
  - REMOVE key
```

## Output Format
```
For each GET operation, output the integer value (or -1).
For each REMOVE operation, output true or false.
```

## Constraints
- $1 \le M \le 1000$
- $1 \le Q \le 10^4$
- $1 \le |key| \le 100$
- $-10^9 \le value \le 10^9$

## Examples
### Example 1
**Input:**
```
5 6
PUT cat 10
PUT act 20
GET cat
GET act
PUT cat 30
GET cat
```
**Output:**
```
10
20
30
```
**Explanation:** Both `"cat"` and `"act"` hash to bucket $2$ ($312 \pmod 5 = 2$). Both exist in the bucket chain without overwriting each other. Updating `"cat"` modifies its existing node.

### Example 2
**Input:**
```
5 4
GET dog
PUT dog 50
GET dog
REMOVE dog
```
**Output:**
```
-1
50
true
```

## Complexity
- **Time Complexity:**
  - $\mathcal{O}(1)$ average for `PUT`, `GET`, `REMOVE` when load factor $\alpha = N/M$ is bounded.
  - $\mathcal{O}(N)$ worst-case if all keys hash to the same bucket.
- **Space Complexity:** $\mathcal{O}(M + N)$ where $M$ is table size and $N$ is number of stored nodes.
