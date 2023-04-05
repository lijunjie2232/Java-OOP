package array;

public class arrayMemory {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3 };// static initialization
        int[] temp = array;
        for (int i : temp)
            System.out.println(i);
        temp[0] = 10;
        System.out.println(array[0]);//10
    }
}