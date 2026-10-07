import java.util.*;

public class Solution {

    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        // Binary search: find first index where (arr[i] - (i+1)) >= k
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // low = first index where missing >= k
        // Answer = low + k (k-th missing after arr[low-1])
        return low + k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findKthPositive(arr, k));
    }
}
