import java.util.*;

public class Solution {
    public static int longestSubarraySumK(int[] a, long k) {
        long currentSum = 0;
        int maxLen = 0, L = 0;
        for (int R = 0; R < a.length; R++) {
            currentSum += a[R]; // Expand
            while (currentSum > k && L <= R) {
                currentSum -= a[L]; // Shrink
                L++;
            }
            if (currentSum == k) {
                maxLen = Math.max(maxLen, R - L + 1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); long k = sc.nextLong();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println(longestSubarraySumK(a, k));
    }
}

