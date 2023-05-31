package baselib;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizeDemo {
    public static void main(String[] args) {
        System.out.println(new Locale("ja"));
        System.out.println(new Locale("ja", "JP"));
        System.out.println(Locale.getDefault());
        System.out.println(Locale.JAPAN);
        System.out.println(Locale.JAPANESE);
        System.out.println("**************");
        ResourceBundle res = ResourceBundle.getBundle("baselib.custom");
        System.out.println(res.getString("MYSTRING"));
        res = ResourceBundle.getBundle("baselib.custom", new Locale("ja", "JP"));
        System.out.println(res.getString("MYSTRING"));
        res = ResourceBundle.getBundle("baselib.custom", Locale.CHINA);
        System.out.println(res.getString("MYSTRING"));
        System.out.println(MessageFormat.format(res.getString("WELCOME"), "Admin", "noUseInfo"));
        System.out.println(MessageFormat.format(res.getString("WELCOME"), 1234567.654321));
    }
}
