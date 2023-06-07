package reflecttry;

public class ClassDemo {
    public static void main(String[] args) throws Exception {
        String str = new String();
        System.out.println(str.getClass());
        System.out.println(str.getClass().getClass());
        System.out.println(java.lang.String.class);
        System.out.println(java.lang.Class.forName("java.lang.String"));
        Class<? extends String> strClass = java.lang.String.class;
        System.out.println(strClass.getDeclaredConstructor().newInstance().getClass());
    }
}
