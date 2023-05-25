class A {
    public void show() {
        System.out.println("a_show");
    }

    public void old() {
        System.out.println("a_old_func");
    }
}

class B extends A {
    @Override
    public void show() {
        System.out.println("b_show");
    }

    @SuppressWarnings({ "deprecation" })
    @Deprecated
    public void old() {
        System.out.println("b_old_func");
    }
}

public class AnnoDemo {
    public static void main(String[] args) {
        B testB = new B();
        testB.show();
        testB.old();
    }
}
