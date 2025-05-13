package codings;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque<T> {
    private Deque<T> deque;

    public StackUsingDeque() {
        deque = new LinkedList<>();
    }

    // Push an element onto the stack
    public void push(T item) {
        deque.addFirst(item); // LIFO
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return deque.removeFirst();
    }

    // Peek the top element without removing
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return deque.peekFirst();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return deque.size();
    }

    // Main method to test the stack
    public static void main(String[] args) {
        StackUsingDeque<Integer> stack = new StackUsingDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());     // 30
        System.out.println(stack.pop());      // 30
        System.out.println(stack.pop());      // 20
        System.out.println(stack.size());     // 1
        System.out.println(stack.isEmpty());  // false
    }
}
