import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstringKDistinct(
        String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, L = 0;
        for (int R = 0; R < s.length(); R++) {
            char in = s.charAt(R);
            map.put(in, map.getOrDefault(in, 0) + 1);
            while (map.size() > k) {
                char out = s.charAt(L);
                map.put(out, map.get(out) - 1);
                if (map.get(out) == 0) map.remove(out);
                L++;
            }
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstringKDistinct(sc.next(), sc.nextInt()));
    }
}

