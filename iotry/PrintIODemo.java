package iotry;

import java.io.*;

public class PrintIODemo {
    public static void main(String[] args) {
        try (PrintStream printer = new PrintStream(new FileOutputStream(new File("iotry/test_printer.txt"), false))) {
            printer.printf("test: %s", "PrintStream\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter printer = new PrintWriter(new FileWriter(new File("iotry/test_printer.txt"), true))) {
            printer.printf("test: %s", "PrintWriter");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}