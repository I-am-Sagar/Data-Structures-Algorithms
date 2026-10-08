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

    static String treeToLevelOrder(TreeNode root) {
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

    static int idx = 0;

    static TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    static TreeNode build(int[] preorder, int bound) {
        if (idx == preorder.length || preorder[idx] > bound) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String[] tok = sc.nextLine().trim().split("\\s+");
        int[] preorder = new int[tok.length];
        for (int i = 0; i < tok.length; i++) preorder[i] = Integer.parseInt(tok[i]);
        TreeNode root = bstFromPreorder(preorder);
        System.out.println(treeToLevelOrder(root));
    }
}
