public class StackArray {
    int[] array;
    int sp;

    public StackArray(int size) {
        array = new int[size];
        sp = 0;
    }

    public boolean isEmpty() {
        return sp == 0;
    }

    public boolean isFull() {
        return sp == array.length;
    }

    public void push(int data) {
        if (!isFull()) {
            array[sp++] = data;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return array[sp - 1];
        }
        return -1;
    }

    public void pop() {
        if (!isEmpty()) {
            sp--;
        }

    }

    public static void main(String[] args) {
        StackArray stackArray = new StackArray(3);

        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(3);

        System.out.println(stackArray.peek());

        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();
        stackArray.pop();

        System.out.println(stackArray.peek());
    }

}