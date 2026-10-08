import java.util.*;

public class Solution {
    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            Integer.compare(b[0]*b[0] + b[1]*b[1], a[0]*a[0] + a[1]*a[1])
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = maxHeap.poll();
        Arrays.sort(res, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        int[][] res = kClosest(points, k);
        for (int[] p : res) {
            System.out.println(p[0] + " " + p[1]);
        }
    }
}
