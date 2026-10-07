import java.util.*;

public class Solution {
    public static long[] firstNegative(long[] a, int n, int k) {
        long[] res = new long[n - k + 1];
        Queue<Long> q = new LinkedList<>();
        int L = 0, idx = 0;
        for (int R = 0; R < n; R++) {
            if (a[R] < 0) q.add(a[R]); // Ingest
            if (R - L + 1 == k) {
                res[idx++] = q.isEmpty() ? 0 : q.peek();
                if (!q.isEmpty() && a[L] == q.peek()) {
                    q.poll(); // Evict
                }
                L++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextLong();
        long[] result = firstNegative(a, n, k);
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
