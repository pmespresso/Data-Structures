public class QueueArray<T> {

    T[] arr;
    int front;
    int back;
    int counter;

    @SuppressWarnings("unchecked")
    public QueueArray(int size) {
        arr = (T[]) new Object[size];
        front = 0;
        back = -1;
        counter = 0;
    }

    public void enqueue(T data) {
        if (counter < arr.length) {
            arr[front] = data;
            if (back == -1) {
                back = 0;
            }
            counter += 1;
            front = (front + 1) % arr.length;
        }
    }

    public T dequeue() {
        T r = null;
        if (back != -1 && counter > 0) {
            r = arr[back];
            counter -= 1;
            back = (back + 1) % arr.length;
        }
        return r;
    }

    public static void main(String args[]) {

        QueueArray<Integer> qa = new QueueArray<Integer>(3);

        qa.enqueue(1);
        qa.enqueue(2);
        System.out.println(qa.dequeue());
        System.out.println(qa.dequeue());
        qa.enqueue(3);
        System.out.println(qa.dequeue());
        qa.enqueue(4);
        System.out.println(qa.dequeue());
    }

}
