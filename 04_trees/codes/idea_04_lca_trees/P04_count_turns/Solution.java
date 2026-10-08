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

    static boolean getPath(TreeNode root, int target, StringBuilder sb) {
        if (root == null) return false;
        if (root.val == target) return true;
        sb.append('L');
        if (getPath(root.left, target, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        sb.append('R');
        if (getPath(root.right, target, sb)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }

    static int countTurns(TreeNode root, int u, int v) {
        TreeNode ancestor = lca(root, u, v);
        if (ancestor == null) return -1;
        StringBuilder pathU = new StringBuilder();
        StringBuilder pathV = new StringBuilder();
        getPath(ancestor, u, pathU);
        getPath(ancestor, v, pathV);

        // Path from u to LCA has reverse directions: 'L' up means was coming from Left
        // But coming from u towards LCA: if u came from left child of parent, direction is upward.
        // Actually, on tree: path from u to v goes: u -> ancestor (up) -> v (down).
        // Along u -> ancestor: each direction is parent direction.
        // Simple string representation:
        // Reverse pathU: if edge was L (down), going up is opposite of previous step if direction changes.
        // Specifically, standard definition of turns: count changes in edge direction.
        // For ancestor: path from ancestor to u: pathU; path from ancestor to v: pathV.
        // If ancestor == u: path is pathV. Turns = number of adjacent changes in pathV.
        // If ancestor == v: path is pathU. Turns = number of adjacent changes in pathU.
        // If ancestor is neither: u to ancestor (turning when direction changes) + turn at ancestor + ancestor to v.
        if (ancestor.val == u) {
            return countChanges(pathV.toString());
        } else if (ancestor.val == v) {
            return countChanges(pathU.toString());
        } else {
            // Path goes up from u to ancestor, then down to v.
            // Edge into ancestor from u-branch has direction pathU.charAt(0) ('L' or 'R').
            // Edge leaving ancestor into v-branch has direction pathV.charAt(0) ('L' or 'R').
            int turns = countChanges(pathU.reverse().toString()) + countChanges(pathV.toString());
            // At ancestor: if u-branch was L and v-branch was R (or vice versa), direction changed!
            // Wait, climbing up a Left child and going down a Right child is considered a turn.
            // Climbing up Left and going down Left is also considered a turn (direction reversed).
            // By convention, passing through LCA between two different subtrees adds 1 turn.
            return turns + 1;
        }
    }

    static int countChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        TreeNode root = buildTree(sc.nextLine());
        if (!sc.hasNextInt()) return;
        int u = sc.nextInt();
        int v = sc.nextInt();
        System.out.println(countTurns(root, u, v));
    }
}
