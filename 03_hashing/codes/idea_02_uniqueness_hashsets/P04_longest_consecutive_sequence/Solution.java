import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-026 (LC 128).
     * Sequence anchor pattern: checks !set.contains(x - 1) before expansion.
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);

        int maxStreak = 0;
        for (int x : set) {
            // Only start expanding if 'x' is anchor!
            if (!set.contains(x - 1)) {
                int currNum = x, currStreak = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                maxStreak = Math.max(maxStreak, currStreak);
            }
        }
        return maxStreak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(nums));
    }
}
