import java.util.*;

public class Solution {

    static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // Sort descending by concatenation: (b+a) vs (a+b)
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: Leading zeroes (e.g. [0, 0])
        if (strs[0].equals("0")) return "0";

        return String.join("", strs);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.println(largestNumber(nums));
    }
}
