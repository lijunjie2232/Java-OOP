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

        String strD = "csdn";
        String strE = "CSDN";

        System.out.println(strD.equals(strE));// F
        System.out.println(strD.equalsIgnoreCase(strE));// T

        System.out.println(strD.compareTo(strE));// 32
        System.out.println(strE.compareTo(strD));// -32

        System.out.println(strD.compareToIgnoreCase(strE));// 0

    }
}