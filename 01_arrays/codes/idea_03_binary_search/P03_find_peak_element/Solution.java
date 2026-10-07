import java.util.*;

public class Solution {

    public static int findPeakElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;  // Peak must be on right
            } else {
                high = mid;     // Peak must be on left (or mid itself)
            }
        }
        return low; // low == high == peak index
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(findPeakElement(arr));
    }
}
