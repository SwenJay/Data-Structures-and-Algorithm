import java.util.HashMap;

public class LinkedHashSetSequencedSetDemo {

    // Main custom set class
    public static class LinkedHashSetSequencedSet<T> {
        private HashMap<T, Node<T>> map;
        private Node<T> head, tail;
        private int size;

        // Node for doubly linked list
        private static class Node<T> {
            T data;
            Node<T> prev, next;

            Node(T data) {
                this.data = data;
            }
        }

        public LinkedHashSetSequencedSet() {
            map = new HashMap<>();
            head = null;
            tail = null;
            size = 0;
        }

        // Add element if not already present
        public boolean add(T data) {
            if (map.containsKey(data)) return false;

            Node<T> newNode = new Node<>(data);
            map.put(data, newNode);

            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }

            size++;
            return true;
        }

        // Remove element
        public boolean remove(T data) {
            Node<T> node = map.remove(data);
            if (node == null) return false;

            if (node.prev != null) node.prev.next = node.next;
            else head = node.next;

            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;

            size--;
            return true;
        }

        // Check if the set contains an element
        public boolean contains(T data) {
            return map.containsKey(data);
        }

        // Get element by index
        public T get(int index) {
            if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index);

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        // Return size
        public int size() {
            return size;
        }

        // Check if empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Clear all elements
        public void clear() {
            map.clear();
            head = tail = null;
            size = 0;
        }

        // Print all elements in insertion order
        public void printAll() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedHashSetSequencedSet<String> set = new LinkedHashSetSequencedSet<>();

        set.add("Alpha");
        set.add("Beta");
        set.add("Gamma");
        set.add("Beta"); // Duplicate, won't be added
        set.add("Delta");

        set.printAll(); // Alpha -> Beta -> Gamma -> Delta -> null

        System.out.println("Contains Beta? " + set.contains("Beta")); // true
        System.out.println("Element at index 2: " + set.get(2)); // Gamma

        set.remove("Beta");
        set.printAll(); // Alpha -> Gamma -> Delta -> null

        System.out.println("Size: " + set.size()); // 3
        System.out.println("Is empty? " + set.isEmpty()); // false

        set.clear();
        set.printAll(); // null
        System.out.println("Size after clear: " + set.size()); // 0
    }
}
