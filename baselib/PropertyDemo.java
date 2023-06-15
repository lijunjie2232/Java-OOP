package baselib;

import java.util.Properties;
import java.io.*;

public class PropertyDemo {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("MYSTRING", "HELLOWORLD");
        prop.store(System.out, "test");
        System.out.println(prop.getProperty("MYSTRING"));
        prop.store(new FileOutputStream(new File("baselib/test.properties")), "test properties");
    }
}
