package iotry;

import java.io.*;

public class DecodeDemo {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        File file = new File("iotry/test_code.txt");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try (OutputStream output = new FileOutputStream(file, false)) {
            output.write("こんにちわ".getBytes("ISO8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
