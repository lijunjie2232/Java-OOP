class Person1 {
    public void show() {
        System.out.println("a person");
    }
}

class Man1 extends Person1 {
    @Override
    public void show() {
        System.out.println("a max");
    }

    public void iAmMan() {
        System.out.println("i am man");
    }
}

public class InstanceDemo {
    public static void main(String[] args) {
        // class upper
        Person1 m1 = new Man1();
        m1.show();
        Man1 m2 = (Man1) m1;
        m2.iAmMan();

        // class lower
        Person1 m3 = new Person1();
        m3.show();
        // Man1 m4 = (Man1) m3;// throw ClassCastException
        // m4.iAmMan();

        // instance of
        Man1 m5 = new Man1();
        System.out.println(m1 instanceof Person1);
        System.out.println(m1 instanceof Man1);
        System.out.println(m2 instanceof Person1);
        System.out.println(m2 instanceof Man1);
        System.out.println(m3 instanceof Person1);
        System.out.println(m3 instanceof Man1);
        System.out.println(m5 instanceof Person1);
        System.out.println(m5 instanceof Man1);
    }
}
