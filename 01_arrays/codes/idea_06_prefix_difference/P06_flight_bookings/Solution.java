import java.util.*;

public class Solution {
    public static int[] corpFlightBookings(
        int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] b : bookings) {
            ans[b[0] - 1] += b[2];
            if (b[1] < n) ans[b[1]] -= b[2];
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1]; // In-place prefix
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] bookings = new int[m][3];
        for (int i = 0; i < m; i++) {
            bookings[i][0] = sc.nextInt();
            bookings[i][1] = sc.nextInt();
            bookings[i][2] = sc.nextInt();
        }
        int[] result = corpFlightBookings(bookings, n);
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
