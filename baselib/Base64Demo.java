package baselib;

import java.util.Base64;

class StringHandlerUtil{
    private static final String SALT = "salt";
    private static final int REPEAT = 7;
    /*
     * encode String
     */
    public static String encode(String str){
        String temp = "{" + SALT + "}" + str;
        for(int i = 0; i < REPEAT; i ++){
            temp = new String(Base64.getEncoder().encode(temp.getBytes()));
        }
        return temp;
    }
    /*
     * decode String
     */
    public static String decode(String str){
        String temp = str;
        for(int i = 0; i < REPEAT; i ++){
            temp = new String(Base64.getDecoder().decode(temp.getBytes()));
        }
        return temp.replaceFirst("\\{"+SALT+"\\}","");
    }
}

public class Base64Demo {
    public static void main(String[] args) {
        String msg = "hello world!";
        String encMsg = StringHandlerUtil.encode(msg);
        System.out.println(encMsg);
        System.out.println(StringHandlerUtil.decode(encMsg));
    }
}
