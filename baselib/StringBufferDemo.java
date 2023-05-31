package baselib;

public class StringBufferDemo {
    public static void change(StringBuffer temp) {
        temp.append("...");
    }

    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("123456");
        change(sb1);
        System.out.println(sb1);
        System.out.println("******************");
        String str1 = "helloworld";
        String str2 = "hello" + "world";
        System.out.println(str1 == str2);
        StringBuffer sb2 = new StringBuffer("helloworld");
        StringBuffer sb3 = new StringBuffer("helloworld");
        StringBuffer sb4 = new StringBuffer("hello");
        sb4.append("world");
        System.out.println(sb2 == sb3);
        System.out.println(sb2 == sb4);
        System.out.println("******************");
        StringBuffer sb5 = new StringBuffer("world");
        System.out.println(sb5.capacity());
        sb5.insert(0, "hello");
        System.out.println(sb5.capacity());
        System.out.println(sb5);
        System.out.println("******************");
        sb5.delete(1,2);
        System.out.println(sb5);
        sb5.deleteCharAt(1);
        System.out.println(sb5);
        sb5.setCharAt(0, '%');
        System.out.println(sb5);
        sb5.replace(1, 3, "HELLO");
        System.out.println(sb5);
        System.out.println(sb5.reverse());
        System.out.println("******************");
        System.out.println(sb5.substring(1,6));
        System.out.println("******************");
        CharSequence substr = sb5.subSequence(1,6);
        System.out.println(substr);
        System.out.println("******************");

    }

}
