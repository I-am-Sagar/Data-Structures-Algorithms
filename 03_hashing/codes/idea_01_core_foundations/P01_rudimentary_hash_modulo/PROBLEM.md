# Rudimentary Hash and Modulo Compression

## Problem Statement
In hash tables, arbitrary keys (such as strings) cannot directly index into an array. A hash function bridges this gap by mapping an object into an integer hash code, which is subsequently compressed into a valid array index $[0, M-1]$ using the modulo operator ($\pmod M$).

Given a table size $M$ and a string $s$, compute the compressed array index using the rudimentary ASCII character sum hash function:
$$\text{hash}(s, M) = \left( \sum_{i=0}^{|s|-1} \text{ASCII}(s[i]) \right) \pmod M$$

## Mental Model & Invariant
1. **Character to Integer**: Every ASCII character $c$ has an integer code point (e.g., `'a' \to 97`, `'c' \to 99`, `'t' \to 116`).
2. **Hash Code**: Sum the ASCII values of all characters in $s$. For `"cat"`, $99 + 97 + 116 = 312$.
3. **Modulo Compression**: Array indices must lie in $[0, M-1]$. The operation $312 \pmod M$ guarantees a bounded slot. For $M = 5$, $312 \pmod 5 = 2$.
4. **Collision Insight**: Anagrams like `"cat"` and `"act"` produce the identical character sum ($312$), resulting in a hash collision at slot $2$.

## Input Format
```
Line 1: An integer M representing the hash table size.
Line 2: A string s consisting of printable ASCII characters.
```

## Output Format
```
A single integer representing the compressed array index: hash(s, M).
```

## Constraints
- $1 \le M \le 10^5$
- $1 \le |s| \le 10^4$
- $s$ contains ASCII characters with codes in $[0, 127]$.

## Examples
### Example 1
**Input:**
```
5
cat
```
**Output:**
```
2
```
**Explanation:** ASCII sum $= 99 + 97 + 116 = 312$. Then $312 \pmod 5 = 2$.

### Example 2
**Input:**
```
5
act
```
**Output:**
```
2
```
**Explanation:** ASCII sum $= 97 + 99 + 116 = 312$. Then $312 \pmod 5 = 2$. An identical hash collision occurs!

### Example 3
**Input:**
```
10
hello
```
**Output:**
```
2
```
**Explanation:** ASCII sum $= 104 + 101 + 108 + 108 + 111 = 532$. Then $532 \pmod{10} = 2$.

## Complexity
- **Time Complexity:** $\mathcal{O}(|s|)$ — Single linear pass over string characters.
- **Space Complexity:** $\mathcal{O}(1)$ — Only a running integer accumulator is maintained.
