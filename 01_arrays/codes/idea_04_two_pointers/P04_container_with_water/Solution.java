import java.util.*;

public class Solution {

    public static int maxArea(int[] h) {
        int left = 0, right = h.length - 1;
        int maxWater = 0;
        while (left < right) {
            int width = right - left;
            int currentWater =
                width * Math.min(h[left], h[right]);
            maxWater = Math.max(maxWater, currentWater);
            if (h[left] < h[right]) {
                left++;   // Discard shorter left
            } else {
                right--;  // Discard shorter right
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = sc.nextInt();
        System.out.println(maxArea(h));
    }
}
