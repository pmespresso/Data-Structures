public class Queue<T> {

    Node<T> front = null;
    Node<T> back = null;

    public void enqueue(T data) {
        if (back == null) {
            back = new Node<T>(data, null);
            front = back;
        }
        else {
            Node<T> temp = new Node<T>(data, null);
            front.stack = temp;
            front = temp;
        }
    }

    public T dequeue() {
        if (back != null) {
            T data = back.data;
            back = back.stack;
            return data;
        }
        return null;
    }

    public void printQueue() {
        Node<T> cur = back;

        while(cur != null) {
            System.out.print(cur.data +" ");
            cur = cur.stack;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Queue<Integer> nigga = new Queue<Integer>();

        nigga.enqueue(1);
        nigga.enqueue(2);
        nigga.enqueue(3);

        nigga.printQueue();
        System.out.println(nigga.dequeue());
        nigga.dequeue();
        nigga.dequeue();
        System.out.println(nigga.dequeue());
    }


}
