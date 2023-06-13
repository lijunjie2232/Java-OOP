package dataStruc;

import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3);
        for(Object i : list.toArray()){
            System.out.println(i);
        }
        System.out.println("************");
        list.forEach(System.out::println);
    }
}
