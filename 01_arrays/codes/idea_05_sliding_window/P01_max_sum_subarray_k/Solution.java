import java.util.*;

public class Solution {
    public static long maxSubarraySum(int[] arr, int k) {
        long currentSum = 0, maxSum = Long.MIN_VALUE;
        int L = 0;
        for (int R = 0; R < arr.length; R++) {
            currentSum += arr[R]; // Ingest
            if (R - L + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[L]; // Evict
                L++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(maxSubarraySum(arr, k));
    }
}

