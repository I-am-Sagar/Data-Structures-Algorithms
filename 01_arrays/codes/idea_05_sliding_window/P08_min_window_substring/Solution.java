import java.util.*;

public class Solution {
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int count = t.length(), L = 0;
        int minLen = Integer.MAX_VALUE, start = 0;
        for (int R = 0; R < s.length(); R++) {
            if (map[s.charAt(R)]-- > 0) count--;
            while (count == 0) { // Valid!
                if (R - L + 1 < minLen) {
                    minLen = R - L + 1;
                    start = L;
                }
                if (++map[s.charAt(L)] > 0) count++;
                L++;
            }
        }
        return minLen == Integer.MAX_VALUE ? ""
            : s.substring(start, start + minLen);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = minWindow(sc.next(), sc.next());
        System.out.println(answer.isEmpty() ? "EMPTY" : answer);
    }
}

