import java.util.*;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSub = generateTrees(start, i - 1);
            List<TreeNode> rightSub = generateTrees(i + 1, end);
            for (TreeNode l : leftSub) {
                for (TreeNode r : rightSub) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    static String serialize(TreeNode root) {
        if (root == null) return "null";
        List<String> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr != null) {
                list.add(String.valueOf(curr.val));
                q.offer(curr.left);
                q.offer(curr.right);
            } else {
                list.add("null");
            }
        }
        int last = list.size() - 1;
        while (last >= 0 && list.get(last).equals("null")) last--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= last; i++) {
            if (i > 0) sb.append(" ");
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        List<TreeNode> trees = generateTrees(1, n);
        System.out.println("Total: " + trees.size());
        List<String> representations = new ArrayList<>();
        for (TreeNode t : trees) representations.add(serialize(t));
        Collections.sort(representations);
        for (String s : representations) System.out.println(s);
    }
}
