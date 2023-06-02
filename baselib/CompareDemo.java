package baselib;
import java.util.Arrays;
import java.util.Comparator;

class MyComparableClass implements Comparable<MyComparableClass> {
    private String name;

    public String getName() {
        return name;
    }

    public MyComparableClass(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(MyComparableClass b) {
        return -this.name.compareTo(b.getName());
    }
}

class MyUncomparableClass {
    private String name;

    public String getName() {
        return name;
    }

    public MyUncomparableClass(String name) {
        this.name = name;
    }
}

class MyUncomparableClassComparator implements Comparator<MyUncomparableClass>{
    @Override
    public int compare(MyUncomparableClass a, MyUncomparableClass b){
        return a.getName().compareTo(b.getName());
    }
}

public class CompareDemo {
    public static void main(String[] args) {
        MyComparableClass m0 = new MyComparableClass("ada");
        MyComparableClass m1 = new MyComparableClass("nba");
        MyComparableClass m2 = new MyComparableClass("a31a");
        System.out.println(m0.compareTo(m2));
        System.out.println("***********");
        MyComparableClass [] m = new MyComparableClass[3];
        m[0] = m0;
        m[1] = m1;
        m[2] = m2;
        for(MyComparableClass mc : m){
            System.out.println(mc.getName());
        }
        System.out.println("****** sorted *****");
        Arrays.sort(m);
        for(MyComparableClass mc : m){
            System.out.println(mc.getName());
        }
        // MyUnComparableClass
        System.out.println("****** MyUnComparableClass *****");
        MyUncomparableClass um0 = new MyUncomparableClass("ada");
        MyUncomparableClass um1 = new MyUncomparableClass("nba");
        MyUncomparableClass um2 = new MyUncomparableClass("a31a");
        MyUncomparableClass [] um = new MyUncomparableClass[3];
        um[0] = um0;
        um[1] = um1;
        um[2] = um2;
        for(MyUncomparableClass umc : um){
            System.out.println(umc.getName());
        }
        System.out.println("****** sorted *****");
        Arrays.sort(um, new MyUncomparableClassComparator());
        for(MyUncomparableClass umc : um){
            System.out.println(umc.getName());
        }
    }
}
