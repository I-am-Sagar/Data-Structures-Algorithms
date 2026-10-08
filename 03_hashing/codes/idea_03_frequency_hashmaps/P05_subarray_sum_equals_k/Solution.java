import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-044 (LC 560).
     * Running prefix sum frequency map with essential {0: 1} base case.
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: prefix 0 occurs once
        int currSum = 0, count = 0;

        for (int x : nums) {
            currSum += x;
            // Count previous prefixes satisfying P_i = P_j - K
            count += map.getOrDefault(currSum - k, 0);
            // Record current prefix in running map
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine().trim();
        if (line.isEmpty() || !sc.hasNextInt()) return;

        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        int k = sc.nextInt();

        Solution sol = new Solution();
        System.out.println(sol.subarraySum(nums, k));
    }
}
