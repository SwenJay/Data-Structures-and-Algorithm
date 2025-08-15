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
  
    public boolean isEmpty() { 
      return top == null; 
    }
}
