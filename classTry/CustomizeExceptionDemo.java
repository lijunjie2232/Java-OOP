class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

class MyExceptionTest {
    public void testExp() throws MyException {
        throw new MyException("MyException test");
    }
}

public class CustomizeExceptionDemo {
    public static void main(String[] args) {
        MyExceptionTest test = new MyExceptionTest();
        try {
            test.testExp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}