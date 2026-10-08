import java.util.*;

public class Solution {
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) {
            minHeap.offer(x);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] tok = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[tok.length];
        for (int i = 0; i < tok.length; i++) nums[i] = Integer.parseInt(tok[i]);
        if (!sc.hasNextInt()) return;
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
    }
}
