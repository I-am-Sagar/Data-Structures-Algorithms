# Rabin-Karp Substring Matching

## Problem Statement
Given two strings `text` and `pat`, find the **first occurrence** of the pattern `pat` in `text` using the **Rabin-Karp rolling hash algorithm**.

Return the **0-based starting index** of the first match, or `-1` if `pat` is not found within `text`.

## Mental Model & The Rolling Hash Invariant
- **The Naive Dilemma**: Comparing strings directly takes $\mathcal{O}(m)$ time at each of the $(n - m + 1)$ window positions, leading to $\mathcal{O}(n \cdot m)$ worst-case time complexity.
- **Polynomial Rolling Hash**:
  Map a substring of length $m$ into a polynomial hash:
  $$H = \left( \sum_{j=0}^{m-1} s[j] \cdot B^{m - 1 - j} \right) \pmod Q$$
  where $B = 31$ is the base and $Q = 10^9 + 7$ is a large prime modulo.
- **The Odometer Window Slide ($\mathcal{O}(1)$ Update)**:
  When shifting the window from index $i$ to $i + 1$:
  1. **Subtract** the highest-order term (the leaving character):
     $$\text{drop} = (text[i] \cdot B^{m-1}) \pmod Q$$
  2. **Multiply** by base $B$ to shift all remaining powers up by 1.
  3. **Add** the incoming character $text[i + m]$.
  4. Modulo compress the result:
     $$H_{\text{new}} = ((H_{\text{old}} - \text{drop} + Q) \cdot B + text[i + m]) \pmod Q$$
- **Spurious Hit Protection**: When `winHash == patHash`, perform a verification check `text.startsWith(pat, i)` to guard against hash collisions.

## Input Format
```
Line 1: String text
Line 2: String pat
```

## Output Format
```
A single integer representing the 0-based index of the first match, or -1.
```

## Constraints
- $1 \le \text{text.length} \le 10^5$
- $1 \le \text{pat.length} \le 10^4$
- `text` and `pat` consist of printable ASCII characters.

## Examples
### Example 1
**Input:**
```
abracadabra
cad
```
**Output:**
```
4
```
**Explanation:** Pattern `"cad"` appears at index 4 of `"abracadabra"`.

### Example 2
**Input:**
```
hello
ll
```
**Output:**
```
2
```

### Example 3
**Input:**
```
mississippi
issip
```
**Output:**
```
4
```

### Example 4
**Input:**
```
abc
abcd
```
**Output:**
```
-1
```
**Explanation:** Pattern is longer than the text.

## Complexity
- **Time Complexity:**
  - $\mathcal{O}(n + m)$ average and best case.
  - $\mathcal{O}(n \cdot m)$ worst case (extremely rare with large prime $Q = 10^9 + 7$).
- **Space Complexity:** $\mathcal{O}(1)$ auxiliary space (rolling variables only).
