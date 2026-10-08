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

    static boolean find(TreeNode root, int target, StringBuilder sb) {
        if (root == null) return false;
        if (root.val == target) return true;
        sb.append('L');
        if (find(root.left, target, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        sb.append('R');
        if (find(root.right, target, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        find(root, startValue, startPath);
        find(root, destValue, destPath);

        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        StringBuilder res = new StringBuilder();
        for (int j = i; j < startPath.length(); j++) res.append('U');
        res.append(destPath.substring(i));
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        if (!sc.hasNextInt()) return;
        int s = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(getDirections(root, s, d));
    }
}
