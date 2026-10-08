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

    static boolean findPath(TreeNode root, int target, List<Integer> path) {
        if (root == null) return false;
        path.add(root.val);
        if (root.val == target) return true;
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }

    static List<Integer> pathBetween(TreeNode root, int u, int v) {
        List<Integer> pathU = new ArrayList<>();
        List<Integer> pathV = new ArrayList<>();
        findPath(root, u, pathU);
        findPath(root, v, pathV);

        int i = 0;
        while (i < pathU.size() && i < pathV.size() && pathU.get(i).equals(pathV.get(i))) {
            i++;
        }
        // LCA is at index i - 1
        List<Integer> res = new ArrayList<>();
        for (int j = pathU.size() - 1; j >= i - 1; j--) res.add(pathU.get(j));
        for (int j = i; j < pathV.size(); j++) res.add(pathV.get(j));
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        if (!sc.hasNextInt()) return;
        int u = sc.nextInt();
        int v = sc.nextInt();
        List<Integer> path = pathBetween(root, u, v);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(path.get(i));
        }
        System.out.println(sb);
    }
}
