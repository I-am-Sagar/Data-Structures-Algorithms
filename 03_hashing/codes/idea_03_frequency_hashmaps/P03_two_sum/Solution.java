import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-038 (LC 1).
     * One-pass hash map complement query avoiding self-pairing.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // num -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No pair");
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
        int target = sc.nextInt();

        Solution sol = new Solution();
        int[] res = sol.twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
