package iotry;

import java.io.*;

public class IOBitDemo {
    public static void main(String[] args) {
        File file = new File("iotry/test.txt");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        try (Writer writer = new FileWriter(file, false)) {
            writer.write("hello world! 1\r\n");
            writer.write("hello world! 2\r\n");
            writer.append("hello world! 3\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file, true))) {
            writer.write("hello world! 4\r\n");
            writer.write("hello world! 5\r\n");
            writer.append("hello world! 6\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Reader reader = new FileReader(file)) {
            char[] cache = new char[64];
            for (int len = reader.read(cache); len != -1; len = reader.read(cache)) {
                System.out.println(new String(cache, 0, len));
                System.out.println(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
