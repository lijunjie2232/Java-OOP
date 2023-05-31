package baselib;

import java.math.BigInteger;

public class BigNumDemo {
    public static void main(String[] args) {
        BigInteger a = new BigInteger(
                "341654354153416543541534156446546543676876384601861071363415644654654367687638460186107136");
        BigInteger b = new BigInteger("-53454545341545345454534154546314687546314687");
        System.out.println(a.add(a));
        System.out.println(a);
        System.out.println("*******************");
        System.out.println(a.divide(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(b.abs());
        System.out.println(a.pow(2));
        System.out.println(a.divideAndRemainder(b)[1]);
    }
}
