public class Generics<T> {

    public void printArray(T[] arr) {
        for (T x : arr) {
            System.out.println(x);
        }
    }
//
//    public static void printArray(String[] thing) {
//        for (String x : thing) System.out.println(x);
//    }

//    public static <T> void printArray(T[] array) {for (T x : array) System.out.println(x);}



    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        String[] b = {"a", "b", "c"};
        Double[] c = {1.0, 2.0, 3.0};

//        printArray(a);
//        printArray(b);
//        printArray(c);

        Generics<Integer> integer = new Generics<Integer>();
        Generics<String> string = new Generics<String>();
        Generics<Double> doubl = new Generics<Double>();

        integer.printArray(a);
        string.printArray(b);
        doubl.printArray(c);
    }
}
