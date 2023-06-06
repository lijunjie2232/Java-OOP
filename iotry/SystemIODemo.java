package iotry;

import java.io.*;

public class SystemIODemo {
    public static void main(String[] args) {
        System.out.println("this is output of out");
        System.err.println("this is output of error");
        PrintStream sysout = new PrintStream(System.out);
        try (PrintStream output = new PrintStream(new FileOutputStream(new File("iotry/test_sysout.txt"), false))) {
            System.setOut(output);
            System.out.printf("this is output of %s", "System.out");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.setOut(sysout);
        }

        try (FileInputStream input = new FileInputStream(new File("iotry/test_sysout.txt"))) {
            byte[] cache = new byte[64];
            for (int len = input.read(cache); len != -1; len = input.read(cache)) {
                System.out.print(new String(cache, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println();
        }
        try (InputStream finput = new FileInputStream(new File("iotry/test_sysout.txt"))){
            // InputStream input = System.in;
            // byte[] cache = new byte[2];
            // for (int len = input.read(cache); len != -1; len = input.read(cache)) {
            //     System.out.print(new String(cache, 0, len));
            // }
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String msg = input.readLine();
        System.out.println(msg);
        input = new BufferedReader(new InputStreamReader(finput));
        System.out.println(input.readLine());
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
