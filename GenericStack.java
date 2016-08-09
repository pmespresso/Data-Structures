public class GenericStack<T> {

    Node<T> head = null;

    public void push(T data) {
        head = new Node(data, head);
    }

    public void pop() {
        if (head != null) {
            head = head.stack;
        }
    }

    public T peek() {
        if (head != null) {
            return head.data;
        }
        return null;
    }

    public static void main(String[] args) {

        GenericStack<Integer> stack = new GenericStack<Integer>();

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

class Node<T> {
    T data;
    Node<T> stack;

    public Node(T newData, Node newStack) {
        data = newData;
        stack = newStack;
    }
}