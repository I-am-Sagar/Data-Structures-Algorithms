import java.util.*;

public class Solution {
    public static int countAnagrams(String s, String p) {
        int[] pCount = new int[26], wCount = new int[26];
        for (char c : p.toCharArray()) pCount[c - 'a']++;
        int k = p.length(), L = 0, matches = 0;
        for (int R = 0; R < s.length(); R++) {
            wCount[s.charAt(R) - 'a']++; // Ingest
            if (R - L + 1 == k) {
                if (Arrays.equals(pCount, wCount)) matches++;
                wCount[s.charAt(L) - 'a']--; // Evict
                L++;
            }
        }
        return matches;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(countAnagrams(sc.next(), sc.next()));
    }
}

