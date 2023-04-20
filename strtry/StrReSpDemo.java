public class StrReSpDemo {
    public static void main(String[] args) {
        String strA = """
                public class StrReplaceDemo{
                    public static void main(String [] args){
                        return ;
                    }
                }
                    """;

        // replace
        System.out.println(strA.replaceFirst("public ", ""));
        System.out.println(strA.replaceAll("Str", "str"));

        // split
        System.out.println(strA.split(" ", 2)[1]);

        // substr
        System.out.println(strA.substring(0, strA.indexOf("c")));

    }
}