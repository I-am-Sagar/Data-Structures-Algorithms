import java.util.Scanner;

public class Solution {

    /**
     * Exact implementation from Slide S03-053.
     * Rabin-Karp rolling polynomial hash with O(1) sliding window update.
     */
    public static int search(String text, String pat) {
        int n = text.length(), m = pat.length();
        if (m > n) return -1;
        long B = 31, Q = 1_000_000_007L, highPower = 1;
        long patHash = 0, winHash = 0;

        for (int i = 0; i < m - 1; i++) highPower = (highPower * B) % Q;
        for (int i = 0; i < m; i++) {
            patHash = (patHash * B + pat.charAt(i)) % Q;
            winHash = (winHash * B + text.charAt(i)) % Q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (winHash == patHash && text.startsWith(pat, i)) return i;
            if (i < n - m) {
                long drop = (text.charAt(i) * highPower) % Q;
                winHash = ((winHash - drop + Q) * B + text.charAt(i + m)) % Q;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;
        String text = sc.next();
        if (!sc.hasNext()) {
            System.out.println(-1);
            return;
        }
        String pat = sc.next();
        System.out.println(search(text, pat));
    }
}
