import java.util.Scanner;

public class Solution {

    static class Node {
        String key;
        int val;
        Node next;

        Node(String key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    static class SeparateChainingMap {
        private final int capacity;
        private final Node[] table;

        public SeparateChainingMap(int capacity) {
            this.capacity = capacity;
            this.table = new Node[capacity];
        }

        private int hash(String key) {
            int sum = 0;
            for (int i = 0; i < key.length(); i++) {
                sum += key.charAt(i);
            }
            return sum % capacity;
        }

        public void put(String key, int value) {
            int idx = hash(key);
            for (Node curr = table[idx]; curr != null; curr = curr.next) {
                if (curr.key.equals(key)) {
                    curr.val = value; // Update existing key
                    return;
                }
            }
            // Prepend new node to bucket chain
            table[idx] = new Node(key, value, table[idx]);
        }

        public int get(String key) {
            int idx = hash(key);
            for (Node curr = table[idx]; curr != null; curr = curr.next) {
                if (curr.key.equals(key)) {
                    return curr.val;
                }
            }
            return -1; // Key absent
        }

        public boolean remove(String key) {
            int idx = hash(key);
            Node prev = null;
            for (Node curr = table[idx]; curr != null; prev = curr, curr = curr.next) {
                if (curr.key.equals(key)) {
                    if (prev == null) {
                        table[idx] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int M = sc.nextInt();
        int Q = sc.nextInt();

        SeparateChainingMap map = new SeparateChainingMap(M);

        for (int q = 0; q < Q; q++) {
            String op = sc.next();
            if (op.equals("PUT")) {
                String key = sc.next();
                int val = sc.nextInt();
                map.put(key, val);
            } else if (op.equals("GET")) {
                String key = sc.next();
                System.out.println(map.get(key));
            } else if (op.equals("REMOVE")) {
                String key = sc.next();
                System.out.println(map.remove(key));
            }
        }
    }
}
