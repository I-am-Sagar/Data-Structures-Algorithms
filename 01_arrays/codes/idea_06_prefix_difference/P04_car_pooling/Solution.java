import java.util.*;

public class Solution {
    public static boolean carPooling(
        int[][] trips, int capacity) {
        int[] timeline = new int[1001];
        for (int[] t : trips) {
            timeline[t[1]] += t[0]; // pickup
            timeline[t[2]] -= t[0]; // dropoff
        }
        int currentLoad = 0;
        for (int passengers : timeline) {
            currentLoad += passengers;
            if (currentLoad > capacity) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), capacity = sc.nextInt();
        int[][] trips = new int[m][3];
        for (int i = 0; i < m; i++) {
            trips[i][0] = sc.nextInt();
            trips[i][1] = sc.nextInt();
            trips[i][2] = sc.nextInt();
        }
        System.out.println(carPooling(trips, capacity));
    }
}

