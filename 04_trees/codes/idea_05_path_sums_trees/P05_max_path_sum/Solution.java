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

    static int maxSum = Integer.MIN_VALUE;

    static int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        int currentPathSum = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);
        return root.val + Math.max(leftGain, rightGain);
    }

    static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        System.out.println(maxPathSum(root));
    }
}
