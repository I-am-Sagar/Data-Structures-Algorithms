import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = sc.next();

        // Custom Comparator: Sort by length
        Arrays.sort(arr, (a, b) ->
            Integer.compare(a.length(), b.length()));

        System.out.println(String.join(" ", arr));
    }
}
