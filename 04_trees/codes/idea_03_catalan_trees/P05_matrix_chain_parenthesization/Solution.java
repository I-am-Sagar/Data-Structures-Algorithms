import java.util.*;

public class Solution {
    static long matrixChainWays(int k) {
        if (k <= 1) return 1;
        int n = k - 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int k = sc.nextInt();
        System.out.println(matrixChainWays(k));
    }
}
