import java.util.*;

public class Solution {
    static String reorganizeString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) counts.put(c, counts.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(counts.get(b), counts.get(a)));
        maxHeap.addAll(counts.keySet());

        StringBuilder sb = new StringBuilder();
        Queue<Character> cooldown = new LinkedList<>();
        Queue<Integer> cooldownCount = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            char curr = maxHeap.poll();
            sb.append(curr);
            int remaining = counts.get(curr) - 1;

            cooldown.offer(curr);
            cooldownCount.offer(remaining);

            if (cooldown.size() >= 2) {
                char c = cooldown.poll();
                int cnt = cooldownCount.poll();
                if (cnt > 0) {
                    counts.put(c, cnt);
                    maxHeap.offer(c);
                }
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String s = sc.nextLine().trim();
        System.out.println(reorganizeString(s));
    }
}
