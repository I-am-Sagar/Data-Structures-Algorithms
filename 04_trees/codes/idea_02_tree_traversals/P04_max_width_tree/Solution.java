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

    static class Pair {
        TreeNode node;
        long idx;
        Pair(TreeNode n, long i) { node = n; idx = i; }
    }

    static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        long maxWidth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            long minIdx = q.peek().idx;
            long first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                long curIdx = p.idx - minIdx;
                if (i == 0) first = curIdx;
                if (i == size - 1) last = curIdx;
                if (p.node.left != null) q.offer(new Pair(p.node.left, 2 * curIdx + 1));
                if (p.node.right != null) q.offer(new Pair(p.node.right, 2 * curIdx + 2));
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return (int) maxWidth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        System.out.println(widthOfBinaryTree(root));
    }
}
