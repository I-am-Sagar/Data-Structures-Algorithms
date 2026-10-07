import java.util.*;

public class Solution {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: empty prefix
        int prefixSum = 0, count = 0;
        for (int x : nums) {
            prefixSum += x;
            int target = prefixSum - k;
            count += map.getOrDefault(target, 0);
            map.put(prefixSum, 
                map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        System.out.println(subarraySum(nums, k));
    }
}

