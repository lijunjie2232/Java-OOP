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
        System.out.println("****************** involk が　素晴らしい　です:");
        Object strObj = (Object) Class.forName("java.lang.String")
                .getDeclaredConstructor(Class.forName("java.lang.String")).newInstance("involk が　素晴らしい　です:");
        Method mth_toString = Class.forName("java.lang.String").getDeclaredMethod("toString");
        System.out.println(mth_toString.invoke(strObj));
        Method mth_substring = Class.forName("java.lang.String").getDeclaredMethod("substring", int.class, int.class);
        System.out.println(mth_substring.invoke(strObj, 0, 15));
        System.out.println("****************** involk が　素晴らしい　です ...");
        Field strValue = Class.forName("java.lang.String").getDeclaredField("value");
        System.out.println(strValue.getType());
        strValue.setAccessible(true);
        strValue.set(strObj, "jdk 9+ should add param: --add-opens java.base/java.lang=ALL-UNNAMED for setAccessible".getBytes());
        System.out.println(new String((byte[])strValue.get(strObj)));
    }
}
