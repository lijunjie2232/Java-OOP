package baselib;

import javax.xml.transform.Source;

class MyCloneableClass implements Cloneable {
    private String name;
    private int age;

    public MyCloneableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("name: " + this.name + "\nage: " + this.age);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloneableDemo {
    public static void main(String[] args) throws Exception {
        MyCloneableClass mcc = new MyCloneableClass("zon", 0);
        mcc.show();
        MyCloneableClass mcc2 = (MyCloneableClass) mcc.clone();
        mcc2.show();
    }
}
