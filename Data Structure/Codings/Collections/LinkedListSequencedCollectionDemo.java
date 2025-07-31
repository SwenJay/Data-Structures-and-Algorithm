public class LinkedListSequencedCollectionDemo {

    // LinkedListSequencedCollection class
    public static class LinkedListSequencedCollection<T> {
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

        // Add to the end
        public void add(T data) {
            insertAt(size, data);
        }

        // Insert at a specific index
        public void insertAt(int index, T data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            Node<T> newNode = new Node<>(data);

            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node<T> prev = getNode(index - 1);
                newNode.next = prev.next;
                prev.next = newNode;
            }

            size++;
        }

        // Remove by index
        public T removeAt(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            T removedData;

            if (index == 0) {
                removedData = head.data;
                head = head.next;
            } else {
                Node<T> prev = getNode(index - 1);
                removedData = prev.next.data;
                prev.next = prev.next.next;
            }

            size--;
            return removedData;
        }

        // Get element at index
        public T get(int index) {
            return getNode(index).data;
        }

        // Return current size
        public int size() {
            return size;
        }

        // Check if empty
        public boolean isEmpty() {
            return size == 0;
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

        // Private method to get node at index
        private Node<T> getNode(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        LinkedListSequencedCollection<String> list = new LinkedListSequencedCollection<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        list.printAll(); // Apple -> Banana -> Cherry -> null

        list.insertAt(1, "Blueberry");
        list.printAll(); // Apple -> Blueberry -> Banana -> Cherry -> null

        System.out.println("Element at index 2: " + list.get(2)); // Banana

        list.removeAt(3);
        list.printAll(); // Apple -> Blueberry -> Banana -> null

        System.out.println("Size: " + list.size()); // 3
    }
}
