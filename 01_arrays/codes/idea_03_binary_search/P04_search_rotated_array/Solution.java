import java.util.*;

public class Solution {

    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1; // Target in left sorted half
                } else {
                    low = mid + 1;  // Target in right half
                }
            } else {
                // Right half is sorted
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;  // Target in right sorted half
                } else {
                    high = mid - 1; // Target in left half
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        System.out.println(search(arr, target));
    }
}
