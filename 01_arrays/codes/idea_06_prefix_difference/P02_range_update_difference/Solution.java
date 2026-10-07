import java.util.*;

public class Solution {
    public static class DifferenceArray {
        private final int[] D;
        private final int N;
        public DifferenceArray(int n) {
            this.N = n;
            this.D = new int[n + 1];
        }
        public void update(int L, int R, int val) {
            D[L] += val;
            if (R + 1 < N) D[R + 1] -= val;
        }
        public int[] reconstruct() {
            int[] res = new int[N];
            res[0] = D[0];
            for (int i = 1; i < N; i++) {
                res[i] = res[i - 1] + D[i];
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        DifferenceArray differenceArray = new DifferenceArray(n);
        while (q-- > 0) differenceArray.update(sc.nextInt(), sc.nextInt(), sc.nextInt());
        int[] result = differenceArray.reconstruct();
        for (int i = 0; i < result.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
