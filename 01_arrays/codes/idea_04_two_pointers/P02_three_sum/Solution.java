import java.util.*;

public class Solution {

    public static List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            int L = i + 1, R = a.length - 1;
            while (L < R) {
                int sum = a[i] + a[L] + a[R];
                if (sum == 0) {
                    res.add(List.of(a[i], a[L], a[R]));
                    while (L < R && a[L] == a[L + 1]) L++;
                    while (L < R && a[R] == a[R - 1]) R--;
                    L++; R--;
                } else if (sum < 0) L++;
                else R--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        List<List<Integer>> result = threeSum(nums);
        if (result.isEmpty()) {
            System.out.println("[]");
        } else {
            for (List<Integer> t : result) {
                System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
            }
        }
    }
}
