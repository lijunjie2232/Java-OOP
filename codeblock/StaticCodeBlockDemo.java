class StaticCodeBlockDemoPerson {
    public StaticCodeBlockDemoPerson() {
        System.out.println("construct method of Person");
    }

    {
        System.out.println("construct code block of Person");
    }
    static {
        System.out.println("static code block of Person");
    }
}

public class StaticCodeBlockDemo {
    public static void main(String[] args) {
        new StaticCodeBlockDemoPerson();
        new StaticCodeBlockDemoPerson();
        new StaticCodeBlockDemoPerson();
    }
}