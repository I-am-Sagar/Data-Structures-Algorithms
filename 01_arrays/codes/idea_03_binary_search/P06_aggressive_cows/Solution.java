import java.util.*;

public class Solution {

    private static boolean canPlace(int[] stalls, int cows, int dist) {
        int count = 1, lastPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
                if (count >= cows) return true;
            }
        }
        return false;
    }

    public static int maxMinDistance(int[] stalls, int cows) {
        Arrays.sort(stalls); // O(N log N)
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(stalls, cows, mid)) {
                ans = mid;     // Try larger distance
                low = mid + 1;
            } else {
                high = mid - 1;// Infeasible: shrink
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), cows = sc.nextInt();
        int[] stalls = new int[n];
        for (int i = 0; i < n; i++) stalls[i] = sc.nextInt();
        System.out.println(maxMinDistance(stalls, cows));
    }
}
