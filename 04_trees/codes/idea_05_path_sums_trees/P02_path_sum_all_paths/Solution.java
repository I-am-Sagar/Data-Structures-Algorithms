import java.util.*;

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode buildTree(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] tokens = line.trim().split("\\s+");
        if (tokens.length == 0 || tokens[0].equals("null") || tokens[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < tokens.length) {
            TreeNode curr = q.poll();
            if (i < tokens.length) {
                if (!tokens[i].equals("null") && !tokens[i].equals("-1")) {
                    curr.left = new TreeNode(Integer.parseInt(tokens[i]));
                    q.offer(curr.left);
                }
                i++;
            }
            if (i < tokens.length) {
                if (!tokens[i].equals("null") && !tokens[i].equals("-1")) {
                    curr.right = new TreeNode(Integer.parseInt(tokens[i]));
                    q.offer(curr.right);
                }
                i++;
            }
        }
        return root;
    }

    static void findPaths(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res) {
        if (root == null) return;
        curr.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(curr));
        } else {
            findPaths(root.left, sum - root.val, curr, res);
            findPaths(root.right, sum - root.val, curr, res);
        }
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        if (!sc.hasNextInt()) return;
        int target = sc.nextInt();
        List<List<Integer>> res = new ArrayList<>();
        findPaths(root, target, new ArrayList<>(), res);
        for (List<Integer> path : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) sb.append(" ");
                sb.append(path.get(i));
            }
            System.out.println(sb);
        }
    }
}
