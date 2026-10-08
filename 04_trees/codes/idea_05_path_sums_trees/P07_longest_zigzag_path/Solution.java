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

    static int maxLen = 0;

    // isLeft = true means we arrived at curr from parent's left branch
    static void dfs(TreeNode root, boolean isLeft, int len) {
        if (root == null) return;
        maxLen = Math.max(maxLen, len);
        if (isLeft) {
            dfs(root.right, false, len + 1); // switch direction
            dfs(root.left, true, 1);        // restart
        } else {
            dfs(root.left, true, len + 1);  // switch direction
            dfs(root.right, false, 1);       // restart
        }
    }

    static int longestZigZag(TreeNode root) {
        maxLen = 0;
        if (root == null) return 0;
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        System.out.println(longestZigZag(root));
    }
}
