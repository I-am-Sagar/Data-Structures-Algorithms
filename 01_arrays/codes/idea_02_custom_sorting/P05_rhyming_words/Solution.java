import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = sc.next();

        Arrays.sort(words, (a, b) -> {
            String revA = new StringBuilder(a).reverse().toString();
            String revB = new StringBuilder(b).reverse().toString();
            return revA.compareTo(revB);
        });

        System.out.println(String.join(" ", words));
    }
}
