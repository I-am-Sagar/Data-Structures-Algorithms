import java.util.*;

public class Solution {

    public static int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length; // Default insertion point
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = mid;      // Candidate found
                high = mid - 1; // Search leftward
            } else {
                low = mid + 1;  // Search rightward
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length; // Default insertion point
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                ans = mid;      // Candidate found
                high = mid - 1; // Search leftward
            } else {
                low = mid + 1;  // Search rightward
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);
        System.out.println(lb + " " + ub + " " + (ub - lb));
    }
}
