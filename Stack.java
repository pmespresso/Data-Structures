public class Stack {

    Node head = null;

    public void push(int data) {
        head = new Node(data, head);
    }

    public void pop() {
        if (head != null) {
            head = head.stack;
        }
    }

    public int peek() {
        if (head != null) {
            return head.data;
        }
        return -1;
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(4);
        stack.push(5);
        stack.push(1);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }

}

class Node {
    int data;
    Node stack;

    public Node(int newData, Node newStack) {
        data = newData;
        stack = newStack;
    }
}