import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-022 (LC 202).
     * State cycle detection via HashSet.add() invariant.
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && seen.add(n)) {
            n = getSumOfSquares(n);
        }
        return n == 1; // 1 -> Happy, cycle -> Unhappy
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        Solution sol = new Solution();
        System.out.println(sol.isHappy(n));
    }
}
