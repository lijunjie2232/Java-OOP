package baselib;

import java.util.regex.*;

public class RegexDemo {
    public static void main(String[] args) {
        String str1 = "FHAWHFW>H/AFuwjIRH/215rT7O/3Q&%t$";
        System.out.println(str1);
        System.out.println(str1.replaceAll("\\W", ""));
        System.out.println("***************");
        for (String s : str1.split("\\W+"))
            System.out.println(s);
        System.out.println("***************");
        String mail1 = "asdah@sad.com";
        System.out.println(mail1.matches("[[\\w]&&[^_]]\\w+@\\w+\\.(com|jp|net|gov)"));
        System.out.println("***************");
        System.out.println("a".matches("\\p{Alpha}"));
        System.out.println("1".matches("\\p{Alpha}"));
        System.out.println("1".matches("\\p{Digit}"));
        System.out.println("as".matches("\\p{Alpha}"));
        System.out.println("as".matches("\\p{Alpha}{2}"));
        System.out.println("***************");
        String patternStr = "(\\d+)";
        Pattern pat = Pattern.compile(patternStr);
        for (String s : pat.split("1asd321dasd4a654sad"))
            System.out.println(s);
        String testStr = "ad132af4a6f4saf12sa";
        Matcher mat = pat.matcher(testStr);
        while(mat.find()){
            System.out.println(mat.group(0));
        }
        System.out.println("***************");
        System.out.println(mat.replaceAll("@"));
        System.out.println(mat.replaceAll("!"));
        System.out.println(testStr);
        System.out.println("***************");
        System.out.println("***************");

    }
}
