import java.util.Scanner;

public class Solution {

    /**
     * Rudimentary hash function: sums ASCII codes and compresses modulo M.
     * Matches the fundamental intuition presented in Slides S03-006 & S03-007.
     */
    public static int hash(String s, int M) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }
        return sum % M;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int M = sc.nextInt();
        String s = sc.next();
        System.out.println(hash(s, M));
    }
}
