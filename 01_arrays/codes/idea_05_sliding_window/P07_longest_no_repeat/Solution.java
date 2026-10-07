import java.util.*;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[128];
        int maxLen = 0, L = 0;
        for (int R = 0; R < s.length(); R++) {
            char in = s.charAt(R);
            while (visited[in]) {
                visited[s.charAt(L)] = false;
                L++;
            }
            visited[in] = true;
            maxLen = Math.max(maxLen, R - L + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring(sc.next()));
    }
}

