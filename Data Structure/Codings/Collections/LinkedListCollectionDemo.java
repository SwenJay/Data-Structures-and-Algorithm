public class LinkedListCollectionDemo {

    // LinkedListCollection class
    public static class LinkedListCollection<T> {
        private Node<T> head;
        private int size;

        // Node class
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        // Add an element to the end
        public void add(T data) {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        // Remove first occurrence
        public boolean remove(T data) {
            if (head == null) return false;

            if (head.data.equals(data)) {
                head = head.next;
                size--;
                return true;
            }

            Node<T> current = head;
            while (current.next != null && !current.next.data.equals(data)) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
                size--;
                return true;
            }

            return false;
        }

        // Check if element exists
        public boolean contains(T data) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.equals(data)) return true;
                current = current.next;
            }
            return false;
        }

        // Return size
        public int size() {
            return size;
        }

        // Print all elements
        public void printAll() {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    // Main method
    public static void main(String[] args) {
        LinkedListCollection<String> list = new LinkedListCollection<>();

        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");

        list.printAll(); // Alice -> Bob -> Charlie -> null

        System.out.println("Contains Bob? " + list.contains("Bob")); // true

        list.remove("Bob");
        list.printAll(); // Alice -> Charlie -> null

        System.out.println("Size: " + list.size()); // 2
    }
}
