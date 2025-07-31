import java.util.LinkedList;

public class HashSetSetDemo {

    // HashSetSet class
    public static class HashSetSet<T> {
        private static final int INITIAL_CAPACITY = 16;
        private LinkedList<T>[] buckets;
        private int size;

        @SuppressWarnings("unchecked")
        public HashSetSet() {
            buckets = new LinkedList[INITIAL_CAPACITY];
        }

        // Add an element (no duplicates)
        public boolean add(T value) {
            int index = getBucketIndex(value);
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }

            if (buckets[index].contains(value)) {
                return false; // Duplicate
            }

            buckets[index].add(value);
            size++;
            return true;
        }

        // Check if element exists
        public boolean contains(T value) {
            int index = getBucketIndex(value);
            if (buckets[index] == null) return false;
            return buckets[index].contains(value);
        }

        // Remove an element
        public boolean remove(T value) {
            int index = getBucketIndex(value);
            if (buckets[index] == null) return false;

            boolean removed = buckets[index].remove(value);
            if (removed) size--;
            return removed;
        }

        // Size of the set
        public int size() {
            return size;
        }

        // Check if empty
        public boolean isEmpty() {
            return size == 0;
        }

        // Print all elements
        public void printAll() {
            for (LinkedList<T> bucket : buckets) {
                if (bucket != null) {
                    for (T item : bucket) {
                        System.out.print(item + " ");
                    }
                }
            }
            System.out.println();
        }

        // Hash function to find index
        private int getBucketIndex(T value) {
            return (value == null) ? 0 : Math.abs(value.hashCode()) % buckets.length;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        HashSetSet<String> set = new HashSetSet<>();

        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java"); // duplicate, will not be added

        set.printAll(); // Java Python C++ (order may vary due to hashing)

        System.out.println("Contains Python? " + set.contains("Python")); // true
        System.out.println("Contains Go? " + set.contains("Go")); // false

        set.remove("Python");
        set.printAll(); // Java C++

        System.out.println("Size: " + set.size()); // 2
        System.out.println("Is empty? " + set.isEmpty()); // false
    }
}
