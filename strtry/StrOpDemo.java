public class StrOpDemo{
    public static void main(String[] args){
        String strA  = "hello";
        byte[] aData = strA.getBytes();
        System.out.println(aData);
        System.out.println(new String(aData));
    }
}