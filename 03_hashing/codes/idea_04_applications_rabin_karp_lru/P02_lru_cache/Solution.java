import java.util.*;

public class Solution {

    /**
     * Exact implementation from Slides S03-058 & S03-059 (LC 146).
     * HashMap<Integer, Node> + Doubly Linked List with dummy head/tail sentinels.
     */
    static class LRUCache {
        class Node {
            int key, val;
            Node prev, next;
            Node(int k, int v) { this.key = k; this.val = v; }
        }

        private final int capacity;
        private final Map<Integer, Node> map = new HashMap<>();
        private final Node head = new Node(0, 0); // Dummy Head
        private final Node tail = new Node(0, 0); // Dummy Tail

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head; // Initialize empty list
        }

        // Atomic Helper 1: Unlink from anywhere
        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Atomic Helper 2: Splice right after HEAD
        private void insertAtHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Helper 3: Promote to MRU
        private void moveToHead(Node node) {
            remove(node);
            insertAtHead(node);
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1; // Cache miss
            
            moveToHead(node); // Cache hit: promote to MRU
            return node.val;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) { // Key exists: update & promote
                node.val = value;
                moveToHead(node);
            } else { // New key
                if (map.size() == capacity) { // Evict LRU
                    Node lru = tail.prev;
                    remove(lru);
                    map.remove(lru.key);
                }
                Node newNode = new Node(key, value);
                insertAtHead(newNode);
                map.put(key, newNode);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int capacity = sc.nextInt();
        int Q = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        for (int q = 0; q < Q; q++) {
            String op = sc.next();
            if (op.equalsIgnoreCase("put")) {
                int key = sc.nextInt();
                int val = sc.nextInt();
                cache.put(key, val);
            } else if (op.equalsIgnoreCase("get")) {
                int key = sc.nextInt();
                System.out.println(cache.get(key));
            }
        }
    }
}
