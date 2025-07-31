import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueQueueDemo {

    // Custom Priority Queue Class
    public static class PriorityQueueQueue<T extends Comparable<T>> {
        private ArrayList<T> heap;

        public PriorityQueueQueue() {
            heap = new ArrayList<>();
        }

        // Add element (inserts and maintains min-heap order)
        public void add(T element) {
            heap.add(element);
            heapifyUp(heap.size() - 1);
        }

        // Remove and return the highest priority element (smallest)
        public T poll() {
            if (isEmpty()) return null;

            T root = heap.get(0);
            T last = heap.remove(heap.size() - 1);

            if (!isEmpty()) {
                heap.set(0, last);
                heapifyDown(0);
            }

            return root;
        }

        // Peek at the highest priority element
        public T peek() {
            return isEmpty() ? null : heap.get(0);
        }

        public boolean isEmpty() {
            return heap.isEmpty();
        }

        public int size() {
            return heap.size();
        }

        // Print all elements (not in priority order!)
        public void printAll() {
            System.out.println("Queue contents: " + heap);
        }

        // Restore min-heap upward
        private void heapifyUp(int index) {
            while (index > 0) {
                int parent = (index - 1) / 2;
                if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                    Collections.swap(heap, index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        // Restore min-heap downward
        private void heapifyDown(int index) {
            int size = heap.size();
            while (index < size) {
                int left = 2 * index + 1;
                int right = 2 * index + 2;
                int smallest = index;

                if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0)
                    smallest = left;

                if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0)
                    smallest = right;

                if (smallest != index) {
                    Collections.swap(heap, index, smallest);
                    index = smallest;
                } else {
                    break;
                }
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        PriorityQueueQueue<Integer> pq = new PriorityQueueQueue<>();

        pq.add(40);
        pq.add(10);
        pq.add(30);
        pq.add(20);

        pq.printAll(); // Queue contents: not necessarily in priority order

        System.out.println("Peek: " + pq.peek()); // 10

        while (!pq.isEmpty()) {
            System.out.println("Poll: " + pq.poll());
        }

        System.out.println("Is empty? " + pq.isEmpty()); // true
    }
}
