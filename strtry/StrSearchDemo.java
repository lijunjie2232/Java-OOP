public class StrSearchDemo {
    public static void main(String [] args){
        String codeStr = """
            public class StrSearchDemo {
                public static void main(String [] args){
                    return ;
                }
            }
            """;

        System.out.println(codeStr.contains("return"));// T

        System.out.println(codeStr.indexOf("Str"));// 13
        System.out.println(codeStr.indexOf("String codeStr = "));// -1
        System.out.println(codeStr.indexOf("Str", codeStr.indexOf("Str") + 1));// 57
        System.out.println(codeStr.lastIndexOf("Str"));// 57
        
        System.out.println(codeStr.startsWith("public", 0));// T

    }
}
