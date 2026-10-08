import java.util.*;

public class Solution {
    static class Node {
        int val, arrIdx, elemIdx;
        Node(int v, int a, int e) { val = v; arrIdx = a; elemIdx = e; }
    }

    static List<Integer> mergeKArrays(List<int[]> arrays) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < arrays.size(); i++) {
            if (arrays.get(i).length > 0) {
                minHeap.offer(new Node(arrays.get(i)[0], i, 0));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            result.add(curr.val);
            if (curr.elemIdx + 1 < arrays.get(curr.arrIdx).length) {
                minHeap.offer(new Node(arrays.get(curr.arrIdx)[curr.elemIdx + 1], curr.arrIdx, curr.elemIdx + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int k = sc.nextInt();
        sc.nextLine();
        List<int[]> arrays = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                arrays.add(new int[0]);
                continue;
            }
            String[] tok = line.split("\\s+");
            int[] arr = new int[tok.length];
            for (int j = 0; j < tok.length; j++) arr[j] = Integer.parseInt(tok[j]);
            arrays.add(arr);
        }
        List<Integer> res = mergeKArrays(arrays);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(res.get(i));
        }
        System.out.println(sb);
    }
}
