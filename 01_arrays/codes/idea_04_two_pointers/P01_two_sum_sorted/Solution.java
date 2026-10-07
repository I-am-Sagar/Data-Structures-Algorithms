import java.util.*;

public class Solution {

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;   // Prune row: sum too small
            } else {
                right--;  // Prune col: sum too large
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) numbers[i] = sc.nextInt();
        int target = sc.nextInt();
        int[] ans = twoSum(numbers, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
