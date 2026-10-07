import java.util.*;

public class Solution {
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length, L = 0, idx = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int R = 0; R < n; R++) {
            // Evict smaller elements from back
            while (!dq.isEmpty() && 
                   a[dq.peekLast()] <= a[R]) {
                dq.pollLast();
            }
            dq.addLast(R);
            if (R - L + 1 == k) {
                res[idx++] = a[dq.peekFirst()];
                if (dq.peekFirst() == L) dq.pollFirst();
                L++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int[] result = maxSlidingWindow(a, k);
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
