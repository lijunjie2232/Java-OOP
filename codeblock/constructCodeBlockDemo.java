class Person {
    public Person() {
        System.out.println("construct method of Person");
    }

    // construct code block
    {
        System.out.println("construct code block of Person");
    }
}

public class ConstructCodeBlockDemo {
    public static void main(String[] args) {
        new Person();
        new Person();
        new Person();
    }
}