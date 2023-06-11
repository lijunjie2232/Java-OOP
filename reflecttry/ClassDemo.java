package reflecttry;

import java.lang.reflect.*;

public class ClassDemo {
    public static void main(String[] args) throws Exception {
        String str = new String();
        System.out.println(str.getClass());
        System.out.println(str.getClass().getClass());
        System.out.println(java.lang.String.class);
        System.out.println(java.lang.Class.forName("java.lang.String"));
        Class<? extends String> strClass = java.lang.String.class;
        System.out.println(strClass.getDeclaredConstructor(byte[].class).newInstance("newInstance".getBytes()));
        System.out.println(strClass.getPackage().getName());
        System.out.println(strClass.getSuperclass());
        System.out.println("****************** getInterfaces:");
        for (Class<?> cls : strClass.getInterfaces())
            System.out.println(cls);
        System.out.println("****************** getConstructors");
        for (Constructor<?> cons : strClass.getConstructors())
            System.out.println(cons);
        System.out.println(strClass.getConstructors().length);

        System.out.println("****************** getMethods:");
        for (Method m : strClass.getMethods())
            System.out.println(m);
        System.out.println("****************** getMethods numbers: " + strClass.getMethods().length);

        System.out.println("****************** getDeclaredMethods:");
        for (Method m : strClass.getDeclaredMethods())
            System.out.println(m.getModifiers() + "  " + m.toString());
        System.out.println("****************** getDeclaredMethods numbers: " + strClass.getDeclaredMethods().length);

    }
}
