public class StrInstDemo {
    public static void main(String[] args) {
        String strA = "haeshe";
        String strB = "haeshe";
        String strC = new String("haeshe");
        String strD = new String("haeshe").intern();
        System.out.println(strA == strB);// T
        System.out.println(strA == strC);// F
        System.out.println(strA == strD);// T
        

        String strAa = "baidu.com";
        String strAb = "baidu" + '.' + "com";
        String strAc = ".";
        String strAd = "baidu" + strAc + "com";
        System.out.println(strAa == strAb);// T
        System.out.println(strAa == strAd);// F
    }
}
