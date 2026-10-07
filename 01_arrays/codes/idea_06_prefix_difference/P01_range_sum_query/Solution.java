import java.util.*;

public class Solution {
    public static class PrefixSum {
        private final long[] P;

        public PrefixSum(int[] a) {
            P = new long[a.length + 1];
            for (int i = 0; i < a.length; i++) {
                P[i + 1] = P[i] + a[i];
            }
        }

        public long query(int L, int R) {
            return P[R + 1] - P[L]; // O(1)
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        PrefixSum prefixSum = new PrefixSum(a);
        while (q-- > 0) System.out.println(prefixSum.query(sc.nextInt(), sc.nextInt()));
    }
}

