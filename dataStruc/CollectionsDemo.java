package dataStruc;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 4, 8, 6, 7, 3, 643, 4, 867, 4);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("****** reverse ******");
        Collections.reverse(list);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("****** binarySearch before sort ******");
        System.out.println(Collections.binarySearch(list, 4));
        System.out.println("****** sort ******");
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("****** binarySearch after sort ******");
        System.out.println(Collections.binarySearch(list, 4));
        System.out.println("****** frequency ******");
        System.out.println(Collections.frequency(list, 4));
    }
}
