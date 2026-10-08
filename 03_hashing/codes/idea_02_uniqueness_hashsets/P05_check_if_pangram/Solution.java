import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-027 (LC 1832).
     * HashSet approach: Universal seen set cardinality verification.
     */
    public boolean checkIfPangram(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) seen.add(c);
        return seen.size() == 26;
    }

    /**
     * Array optimization from Slide S03-027.
     * Bounded universe (a-z) direct address table.
     */
    public boolean checkIfPangramArray(String s) {
        boolean[] seen = new boolean[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                count++;
            }
        }
        return count == 26;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        Solution sol = new Solution();
        System.out.println(sol.checkIfPangram(s));
    }
}
