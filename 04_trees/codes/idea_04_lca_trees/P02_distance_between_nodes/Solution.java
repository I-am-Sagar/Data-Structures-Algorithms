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

    static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    static int getDepth(TreeNode root, int target, int d) {
        if (root == null) return -1;
        if (root.val == target) return d;
        int left = getDepth(root.left, target, d + 1);
        if (left != -1) return left;
        return getDepth(root.right, target, d + 1);
    }

    static int findDistance(TreeNode root, int p, int q) {
        TreeNode ancestor = lca(root, p, q);
        return getDepth(ancestor, p, 0) + getDepth(ancestor, q, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        if (!sc.hasNextInt()) return;
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(findDistance(root, p, q));
    }
}
