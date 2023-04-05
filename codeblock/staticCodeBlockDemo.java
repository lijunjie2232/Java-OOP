class StaticCodeBlockDemoPerson {
    public staticCodeBlockDemoPerson() {
        System.out.println("construct method of Person");
    }
    {
        System.out.println("construct code block of Person");
    }
    static {
        System.out.println("static code block of Person");
    }
}

public class staticCodeBlockDemo {
    public static void main(String[] args) {
        new staticCodeBlockDemoPerson();
        new staticCodeBlockDemoPerson();
        new staticCodeBlockDemoPerson();
    }
}