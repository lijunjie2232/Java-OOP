class Test {
    private String a = "1";
    public String b = "2";

    private void testA() {
        System.out.println(this.getClass());
        System.out.println("Test A");
    }

    public void testB() {
        testA();
        System.out.println(this.getClass());
        System.out.println("Test B");
        System.out.println(a + '\n' + b);
    }
}

class TestFromTest extends Test {

    private String a = "10";// var 覆蓋
    public String b = "20";

    public void testA() {// private func of Test is invisable for TestFromTest
        System.out.println(this.getClass());
        System.out.println("TestFromTest A");
    }

    public void testB() {
        /*
         * if defined as private but defined as public on Test (father class)
         * then compiler throw:
         * "Cannot reduce the visibility of the inherited method from Test"
         **/
        testA();
        System.out.println(this.getClass());
        System.out.println("TestFromTest B");
        System.out.println(a + '\n' + b);
        System.out.println("-----");
        super.testB();
    }
}

class OverrideDemo {
    public static void main(String[] args) {
        Test a = new Test();
        a.testB();
        System.out.println(a.b);// var b of Test
        System.out.println("*******************");

        TestFromTest b = new TestFromTest();
        b.testB();
        System.out.println(b.b);// var b of TestFromTest
        System.out.println("*******************");

        Test c = new TestFromTest();
        c.testB();
        System.out.println(c.b);// var b of Test
    }
}