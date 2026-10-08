import java.util.*;

public class Solution {
    static void backtrack(int open, int close, int max, StringBuilder sb, List<String> res) {
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }
        if (open < max) {
            sb.append('(');
            backtrack(open + 1, close, max, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            backtrack(open, close + 1, max, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), res);
        Collections.sort(res);
        for (String s : res) System.out.println(s);
    }
}
