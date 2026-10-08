import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-033 (LC 387).
     * Two-pass frequency counting using HashMap.getOrDefault().
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();

        // Pass 1: Build frequency map
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Pass 2: Find first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String s = sc.next();
        Solution sol = new Solution();
        System.out.println(sol.firstUniqChar(s));
    }
}
