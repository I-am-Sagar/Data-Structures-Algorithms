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

    static int xDepth = -1, yDepth = -1;
    static TreeNode xParent = null, yParent = null;

    static void find(TreeNode root, TreeNode parent, int d, int x, int y) {
        if (root == null) return;
        if (root.val == x) {
            xDepth = d;
            xParent = parent;
        }
        if (root.val == y) {
            yDepth = d;
            yParent = parent;
        }
        find(root.left, root, d + 1, x, y);
        find(root.right, root, d + 1, x, y);
    }

    static boolean isCousins(TreeNode root, int x, int y) {
        xDepth = -1; yDepth = -1;
        xParent = null; yParent = null;
        find(root, null, 0, x, y);
        return xDepth == yDepth && xParent != yParent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        if (!sc.hasNextInt()) return;
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(isCousins(root, x, y));
    }
}
