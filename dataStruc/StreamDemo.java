package dataStruc;

import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> lang = new ArrayList<String>();
        lang.add("Java");
        lang.add("JavaScript");
        lang.add("JSON");
        lang.add("Python");
        lang.add("Go");
        lang.add("Rust");
        Stream<String> stream = lang.stream();
        Predicate<String> filter = (elem) -> elem.toLowerCase().startsWith("j");
        List<String> result = stream.filter(filter).skip(1).limit(2).collect(Collectors.toList());
        System.out.println(result.getClass());
        System.out.println(result.getClass().getSuperclass());
        System.out.println(result.getClass().getSuperclass().getSuperclass());
        for (String str : result) {
            System.out.println(str);
        }
    }
}
