import java.util.Scanner;

public class Solution {

    static class LinearProbingTable {
        private final int capacity;
        private final String[] table;
        private int size;

        public LinearProbingTable(int capacity) {
            this.capacity = capacity;
            this.table = new String[capacity];
            this.size = 0;
        }

        private int hash(String key) {
            int sum = 0;
            for (int i = 0; i < key.length(); i++) {
                sum += key.charAt(i);
            }
            return sum % capacity;
        }

        public boolean put(String key) {
            int startIdx = hash(key);
            int idx = startIdx;
            int count = 0;

            while (table[idx] != null && count < capacity) {
                if (table[idx].equals(key)) {
                    return true; // Key already present
                }
                idx = (idx + 1) % capacity;
                count++;
            }

            if (count == capacity) {
                return false; // Table full
            }

            table[idx] = key;
            size++;
            return true;
        }

        public boolean contains(String key) {
            int startIdx = hash(key);
            int idx = startIdx;
            int count = 0;

            while (table[idx] != null && count < capacity) {
                if (table[idx].equals(key)) {
                    return true;
                }
                idx = (idx + 1) % capacity;
                count++;
            }
            return false; // Reached null slot or circled completely
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int M = sc.nextInt();
        int Q = sc.nextInt();

        LinearProbingTable table = new LinearProbingTable(M);

        for (int q = 0; q < Q; q++) {
            String op = sc.next();
            if (op.equals("PUT")) {
                String key = sc.next();
                boolean ok = table.put(key);
                if (!ok) {
                    System.out.println("FULL");
                }
            } else if (op.equals("CONTAINS")) {
                String key = sc.next();
                System.out.println(table.contains(key));
            }
        }
    }
}
