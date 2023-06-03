package iotry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOStreamDemo {
    public static void main(String[] args) {
        File file = new File("iotry/test.txt");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try (OutputStream output = new FileOutputStream(file, false)) {
            for (int i = 0; i < 10; i++) {
                output.write("hello world!\r\n".getBytes());
                output.write("hello world!\r\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(file.length());
        try (InputStream input = new FileInputStream(file)) {
            if (file.length() < 10240)
                System.out.println(new String(input.readAllBytes()));
            else {
                byte[] cache = new byte[128];
                for (int len = input.read(cache); len != -1; len = input.read(cache)) {
                    System.out.println(new String(cache, 0, len));
                    System.out.println(len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
