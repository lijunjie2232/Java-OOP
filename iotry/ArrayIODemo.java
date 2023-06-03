package iotry;

import java.io.*;

public class ArrayIODemo {
    public static void main(String[] args) {
        String str = "hello world!";
        try (InputStream input = new ByteArrayInputStream(str.getBytes());
                OutputStream output = new ByteArrayOutputStream();) {
            int data = 0;
            while ((data = input.read()) != -1) {
                output.write(Character.toUpperCase(data));
            }
            System.out.println(new String(((ByteArrayOutputStream)output).toByteArray()));
            System.out.println(((ByteArrayOutputStream)output).toByteArray());
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
