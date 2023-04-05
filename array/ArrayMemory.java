
// package array;
import java.lang.Integer;

class ArrayMemory {
    public static void main(String[] args) throws Exception {
        Integer[] array = new Integer[] { 1, 2, 3 };// static initialization
        Integer[] temp = array;
        dumpArray(temp);
        temp[0] = 10;
        // System.out.println(array[0]);//10
        dumpArray(array);
        doubArray(array);
        dumpArray(array);
    }

    public static <T> void dumpArray(T[] array) throws Exception {
        System.out.println("***********************");
        for (T item : array) {
            System.out.println(item);
        }
        System.out.println("***********************");
    }

    public static void doubArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }

    }
}
