public class StrOtherOpDemo {
    public static void main(String[] args) {
        String strA = "www.baidu.com";
        String strB = "www".concat(".baidu.com");
        System.out.println(strA == strB);// F

        String strC = "www".concat(".baidu.com").intern();
        System.out.println(strA == strC);// T

        System.out.println("".isEmpty());// T

        String strD = " hello world ";
        System.out.println(strD);
        System.out.println(strD.trim());
        System.out.println(strD.length());
        System.out.println(strD.trim().length());

        System.out.println(strD.toUpperCase());
        System.out.println(strD.toLowerCase());
    }
}
