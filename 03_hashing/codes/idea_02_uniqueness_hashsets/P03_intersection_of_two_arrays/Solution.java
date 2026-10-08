import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-023 (LC 349).
     * Dual-set filtering for set intersection and membership queries.
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) set1.add(x);

        Set<Integer> resultSet = new HashSet<>();
        for (int x : nums2) {
            if (set1.contains(x)) resultSet.add(x);
        }
        int[] res = new int[resultSet.size()];
        int i = 0; for (int x : resultSet) res[i++] = x;
        return res;
    }

    private static int[] parseArray(String line) {
        if (line == null || line.trim().isEmpty()) return new int[0];
        String[] parts = line.trim().split("\\s+");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.hasNextLine() ? sc.nextLine() : "";
        String line2 = sc.hasNextLine() ? sc.nextLine() : "";

        int[] nums1 = parseArray(line1);
        int[] nums2 = parseArray(line2);

        Solution sol = new Solution();
        int[] res = sol.intersection(nums1, nums2);
        Arrays.sort(res);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(res[i]);
        }
        System.out.println(sb.toString());
    }
}
