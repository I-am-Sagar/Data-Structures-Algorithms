import java.util.*;

public class Solution {
    static long minCost(int[] ropes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : ropes) pq.offer((long) x);
        long totalCost = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long cost = first + second;
            totalCost += cost;
            pq.offer(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] tok = sc.nextLine().trim().split("\\s+");
        int[] ropes = new int[tok.length];
        for (int i = 0; i < tok.length; i++) ropes[i] = Integer.parseInt(tok[i]);
        System.out.println(minCost(ropes));
    }
}
