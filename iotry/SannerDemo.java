package iotry;

import java.util.Scanner;
import java.io.*;

public class SannerDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("iotry/test.txt"))) {
            scanner.useDelimiter("\r\n");
            while (scanner.hasNext(".*?\\d+")) {
                System.out.println(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(Scanner scanner = new Scanner(System.in)){
            scanner.useDelimiter("\n");
            while(scanner.hasNext("\\d{11}")){
                System.out.println(scanner.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
