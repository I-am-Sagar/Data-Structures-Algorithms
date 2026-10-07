import java.util.*;

public class Solution {
    public static int countBulbsOn(
        int n, int[][] queries) {
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            diff[q[0]]++;
            if (q[1] + 1 < n) diff[q[1] + 1]--;
        }
        int runningFlips = 0, onCount = 0;
        for (int i = 0; i < n; i++) {
            runningFlips += diff[i];
            if ((runningFlips & 1) == 1) {
                onCount++;
            }
        }
        return onCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        System.out.println(countBulbsOn(n, queries));
    }
}

