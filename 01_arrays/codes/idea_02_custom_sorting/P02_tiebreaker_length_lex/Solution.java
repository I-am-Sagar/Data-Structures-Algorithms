import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = sc.next();

        Arrays.sort(words, (a, b) -> {
            // Primary: Compare by length
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            // Secondary: Lexicographical tiebreaker
            return a.compareTo(b);
        });

        System.out.println(String.join(" ", words));
    }
}
