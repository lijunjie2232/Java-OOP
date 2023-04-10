public class StrCmpDemo {
    public static void main(String[] args) {
        String strA = "a";
        String strB = "a";
        String strC = new String("a");
        System.out.println("strA = StrB? | " + (strA == strB));// T
        System.out.println("strA equals StrB? | " + strA.equals(strB));// T
        System.out.println("strA = StrC? | " + (strA == strC));// F
        System.out.println("strA equals StrC? | " + strA.equals(strC));// T
        System.out.println("a = a? | " + "a" == "a");// F
        System.out.println("a = a? | " + "a" == new String("a"));// F
        System.out.println("a = a? | " + "a".equals(new String("a")));// T
    }
}