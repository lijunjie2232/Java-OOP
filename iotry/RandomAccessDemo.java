package iotry;

import java.io.*;

public class RandomAccessDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("iotry/random_test.txt");
        RandomAccessFile rAccesser = new RandomAccessFile(file, "rw");
        String[] a = { "a", "b", "c" };
        int[] b = { 1, 2, 3 };
        for (int i = 0; i < 3; i++) {
            rAccesser.write(a[i].getBytes());
            rAccesser.writeInt(b[i]);
        }
        rAccesser.close();
        try (InputStream input = new FileInputStream(file)) {
            byte[] cache = new byte[64];
            for (int len = input.read(cache); len != -1; len = input.read(cache)) {
                System.out.print(new String(cache));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n****************");
        try (RandomAccessFile randomReader = new RandomAccessFile(file, "r");) {
            randomReader.skipBytes(10);
            byte[] data = new byte[1];
            randomReader.read(data);
            System.out.println(new String(data));
            System.out.println(randomReader.readInt());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
