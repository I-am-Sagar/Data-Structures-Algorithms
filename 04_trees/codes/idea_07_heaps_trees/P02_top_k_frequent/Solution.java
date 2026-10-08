import java.util.*;

public class Solution {
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) minHeap.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = minHeap.poll();
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] tok = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[tok.length];
        for (int i = 0; i < tok.length; i++) nums[i] = Integer.parseInt(tok[i]);
        if (!sc.hasNextInt()) return;
        int k = sc.nextInt();
        int[] res = topKFrequent(nums, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(res[i]);
        }
        System.out.println(sb);
    }
}
