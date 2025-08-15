import java.util.*;

/* *
 * DSA_Assignments.java
 * 
 * Contains implementations for multiple Data Structures & Algorithms:
 *  1. ListStack
 *  2. LIFO Queue using Deque
 *  3. Queue using Stacks
 *  4. ArrayStack
 *  5. FIFO Queue using Deque
 *  6. Stack using Queues
 *  7. Dynamic ArrayStack
 *  8. ListQueue
 *  9. Bubble Sort
 *  10. Insertion Sort
 *  11. Selection Sort
 * 
 * Includes a menu for testing each implementation.
 */
public class DSA_Assignments {

    /* ========================= 1. ListStack ========================= */
    static class ListStack {
        private Node top;
        private class Node {
            int data; Node next;
            Node(int data) { this.data = data; }
        }
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top;
            top = newNode;
        }
        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack Underflow");
            int value = top.data;
            top = top.next;
            return value;
        }
        public int peek() {
            if (isEmpty()) throw new RuntimeException("Stack Empty");
            return top.data;
        }
        public boolean isEmpty() { return top == null; }
    }

    /* ========================= 2. LIFO Queue using Deque ========================= */
    static class LIFOQueueUsingDeque {
        private int[] deque;
        private int front, rear, size, capacity;
        public LIFOQueueUsingDeque(int capacity) {
            this.capacity = capacity;
            deque = new int[capacity];
            front = -1; rear = 0; size = 0;
        }
        public void insertFront(int value) {
            if (isFull()) throw new RuntimeException("Deque Full");
            if (front == -1) { front = rear = 0; }
            else if (front == 0) front = capacity - 1;
            else front--;
            deque[front] = value; size++;
        }
        public int deleteFront() {
            if (isEmpty()) throw new RuntimeException("Deque Empty");
            int value = deque[front];
            if (front == rear) front = rear = -1;
            else if (front == capacity - 1) front = 0;
            else front++;
            size--;
            return value;
        }
        public boolean isFull() { return size == capacity; }
        public boolean isEmpty() { return size == 0; }
    }

    /* ========================= 3. Queue using Stacks ========================= */
    static class QueueUsingStacks {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();
        public void enqueue(int x) {
            while (!s1.isEmpty()) s2.push(s1.pop());
            s1.push(x);
            while (!s2.isEmpty()) s1.push(s2.pop());
        }
        public int dequeue() {
            if (s1.isEmpty()) throw new RuntimeException("Queue Empty");
            return s1.pop();
        }
    }

    /* ========================= 4. ArrayStack ========================= */
    static class ArrayStack {
        private int[] stack; private int top;
        public ArrayStack(int capacity) {
            stack = new int[capacity]; top = -1;
        }
        public void push(int value) {
            if (top == stack.length - 1) throw new RuntimeException("Stack Overflow");
            stack[++top] = value;
        }
        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack Underflow");
            return stack[top--];
        }
        public boolean isEmpty() { return top == -1; }
    }

    /* ========================= 5. FIFO Queue using Deque ========================= */
    static class FIFOQueueUsingDeque {
        private int[] deque;
        private int front, rear, size, capacity;
        public FIFOQueueUsingDeque(int capacity) {
            this.capacity = capacity;
            deque = new int[capacity];
            front = 0; rear = -1; size = 0;
        }
        public void insertRear(int value) {
            if (isFull()) throw new RuntimeException("Deque Full");
            rear = (rear + 1) % capacity;
            deque[rear] = value; size++;
        }
        public int deleteFront() {
            if (isEmpty()) throw new RuntimeException("Deque Empty");
            int value = deque[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }
        public boolean isFull() { return size == capacity; }
        public boolean isEmpty() { return size == 0; }
    }

    /* ========================= 6. Stack using Queues ========================= */
    static class StackUsingQueues {
        private Queue<Integer> q1 = new LinkedList<>();
        private Queue<Integer> q2 = new LinkedList<>();
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) q2.add(q1.remove());
            Queue<Integer> temp = q1; q1 = q2; q2 = temp;
        }
        public int pop() {
            if (q1.isEmpty()) throw new RuntimeException("Stack Empty");
            return q1.remove();
        }
    }

    /* ========================= 7. Dynamic ArrayStack ========================= */
    static class DynamicArrayStack {
        private int[] stack; private int top;
        public DynamicArrayStack(int capacity) {
            stack = new int[capacity]; top = -1;
        }
        public void push(int value) {
            if (top == stack.length - 1) resize();
            stack[++top] = value;
        }
        private void resize() {
            int[] newStack = new int[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack Empty");
            return stack[top--];
        }
        public boolean isEmpty() { return top == -1; }
    }

    /* ========================= 8. ListQueue ========================= */
    static class ListQueue {
        private Node front, rear;
        private class Node {
            int data; Node next;
            Node(int data) { this.data = data; }
        }
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (rear == null) front = rear = newNode;
            else { rear.next = newNode; rear = newNode; }
        }
        public int dequeue() {
            if (isEmpty()) throw new RuntimeException("Queue Empty");
            int value = front.data;
            front = front.next;
            if (front == null) rear = null;
            return value;
        }
        public boolean isEmpty() { return front == null; }
    }

    /* ========================= 9. Bubble Sort ========================= */
    static class BubbleSort {
        public void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    /* ========================= 10. Insertion Sort ========================= */
    static class InsertionSort {
        public void sort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i]; int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j]; j--;
                }
                arr[j + 1] = key;
            }
        }
    }

    /* ========================= 11. Selection Sort =========================
     * Finds the smallest element in the unsorted part of the array
     * and swaps it with the first unsorted element.
     */
    static class SelectionSort {
        public void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /* ========================= Main Menu ========================= */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== DSA Assignments Menu ====");
            System.out.println("1. ListStack");
            System.out.println("2. LIFO Queue using Deque");
            System.out.println("3. Queue using Stacks");
            System.out.println("4. ArrayStack");
            System.out.println("5. FIFO Queue using Deque");
            System.out.println("6. Stack using Queues");
            System.out.println("7. Dynamic ArrayStack");
            System.out.println("8. ListQueue");
            System.out.println("9. Bubble Sort");
            System.out.println("10. Insertion Sort");
            System.out.println("11. Selection Sort");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: ListStack ls = new ListStack();
                        ls.push(10); ls.push(20); ls.push(30);
                        System.out.println("Popped: " + ls.pop()); break;
                case 2: LIFOQueueUsingDeque lifo = new LIFOQueueUsingDeque(5);
                        lifo.insertFront(10); lifo.insertFront(20);
                        System.out.println("Deleted Front: " + lifo.deleteFront()); break;
                case 3: QueueUsingStacks qs = new QueueUsingStacks();
                        qs.enqueue(10); qs.enqueue(20);
                        System.out.println("Dequeued: " + qs.dequeue()); break;
                case 4: ArrayStack as = new ArrayStack(5);
                        as.push(10); as.push(20);
                        System.out.println("Popped: " + as.pop()); break;
                case 5: FIFOQueueUsingDeque fifo = new FIFOQueueUsingDeque(5);
                        fifo.insertRear(10); fifo.insertRear(20);
                        System.out.println("Deleted Front: " + fifo.deleteFront()); break;
                case 6: StackUsingQueues sq = new StackUsingQueues();
                        sq.push(10); sq.push(20);
                        System.out.println("Popped: " + sq.pop()); break;
                case 7: DynamicArrayStack das = new DynamicArrayStack(2);
                        das.push(10); das.push(20); das.push(30);
                        System.out.println("Popped: " + das.pop()); break;
                case 8: ListQueue lq = new ListQueue();
                        lq.enqueue(10); lq.enqueue(20);
                        System.out.println("Dequeued: " + lq.dequeue()); break;
                case 9: int[] arr1 = {5, 2, 9, 1, 5};
                        new BubbleSort().sort(arr1);
                        System.out.println("Sorted: " + Arrays.toString(arr1)); break;
                case 10:int[] arr2 = {5, 2, 9, 1, 5};
                        new InsertionSort().sort(arr2);
                        System.out.println("Sorted: " + Arrays.toString(arr2)); break;
                case 11:int[] arr3 = {5, 2, 9, 1, 5};
                        new SelectionSort().sort(arr3);
                        System.out.println("Sorted: " + Arrays.toString(arr3)); break;
                case 0: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
