package dataStruc;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2);
        for (Object i : list.toArray()) {
            System.out.println(i);
        }
        System.out.println("************");
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);
        list.forEach(System.out::println);
        System.out.println("************");
        list.remove((Object) 2);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("************");
        ListIterator<Integer> lit = list.listIterator();
        while (lit.hasNext())
            System.out.println(lit.next());
        System.out.println("--");
        while (lit.hasPrevious())
            System.out.println(lit.previous());
    }
}
