import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-036 (LC 242).
     * Single map delta balancing pattern with early exit on insufficient supply.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0) return false; // Insufficient supply!
            map.put(c, count - 1);
        }
        return true; // Exactly balanced
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        if (!sc.hasNext()) {
            System.out.println(false);
            return;
        }
        String t = sc.next();
        Solution sol = new Solution();
        System.out.println(sol.isAnagram(s, t));
    }
}
