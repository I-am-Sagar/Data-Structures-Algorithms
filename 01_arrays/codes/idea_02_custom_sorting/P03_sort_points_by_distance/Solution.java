import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pts = new int[n][2];
        for (int i = 0; i < n; i++) {
            pts[i][0] = sc.nextInt();
            pts[i][1] = sc.nextInt();
        }

        Arrays.sort(pts, (p1, p2) -> {
            long d1 = 1L * p1[0] * p1[0] + 1L * p1[1] * p1[1];
            long d2 = 1L * p2[0] * p2[0] + 1L * p2[1] * p2[1];
            return Long.compare(d1, d2);
        });

        StringBuilder sb = new StringBuilder();
        for (int[] p : pts) {
            sb.append('(').append(p[0]).append(", ").append(p[1]).append(")\n");
        }
        System.out.print(sb);
    }
}
