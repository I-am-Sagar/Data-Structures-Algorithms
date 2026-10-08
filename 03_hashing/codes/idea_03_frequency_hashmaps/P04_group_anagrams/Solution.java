import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slide S03-042 (LC 49).
     * Multi-map grouping using sorted-character canonical signatures.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars); // Signature
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line = sc.nextLine().trim();
        String[] strs;
        if (line.isEmpty()) {
            strs = new String[]{""};
        } else {
            strs = line.split("\\s+");
        }

        Solution sol = new Solution();
        List<List<String>> groups = sol.groupAnagrams(strs);

        // Deterministic sorting for testing
        List<String> outputLines = new ArrayList<>();
        for (List<String> group : groups) {
            Collections.sort(group);
            outputLines.add(String.join(" ", group));
        }
        Collections.sort(outputLines);

        for (String out : outputLines) {
            System.out.println(out);
        }
    }
}
