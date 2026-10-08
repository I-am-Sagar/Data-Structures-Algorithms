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

    static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val).append(" ");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString().trim();
    }

    static TreeNode deserializeHelper(Queue<String> q) {
        if (q.isEmpty()) return null;
        String val = q.poll();
        if (val.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }

    static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split("\\s+")));
        return deserializeHelper(q);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        String serialized = serialize(root);
        TreeNode reconstructed = deserialize(serialized);
        System.out.println(treeToLevelOrder(reconstructed));
    }
}
