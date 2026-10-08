import java.util.*;

public class Solution {
    static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for (int x : pushed) {
            st.push(x);
            while (!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return j == popped.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) return;
        String line1 = sc.nextLine().trim();
        if (line1.isEmpty()) {
            System.out.println("true");
            return;
        }
        String[] tok1 = line1.split("\\s+");
        int[] pushed = new int[tok1.length];
        for (int i = 0; i < tok1.length; i++) pushed[i] = Integer.parseInt(tok1[i]);

        if (!sc.hasNextLine()) return;
        String[] tok2 = sc.nextLine().trim().split("\\s+");
        int[] popped = new int[tok2.length];
        for (int i = 0; i < tok2.length; i++) popped[i] = Integer.parseInt(tok2[i]);

        System.out.println(validateStackSequences(pushed, popped));
    }
}
