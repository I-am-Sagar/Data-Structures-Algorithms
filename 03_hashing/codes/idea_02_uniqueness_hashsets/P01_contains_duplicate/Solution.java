import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-021 (LC 217).
     * Leverages the .add() return invariant for early exit duplicate detection.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true; // Early exit on duplicate!
            }
        }
        return false; // All elements unique
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            System.out.println(false);
            return;
        }
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println(false);
            return;
        }
        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        Solution sol = new Solution();
        System.out.println(sol.containsDuplicate(nums));
    }
}
