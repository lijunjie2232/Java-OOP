package advance;

import java.net.*;
import java.util.*;
import java.io.*;

public class EchoClientDemo {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("127.0.0.1", 10649);
        String msg = "{\"msg\"=\"Hello Wolrd!\"}";
        PrintWriter out = new PrintWriter(client.getOutputStream());
        out.println(msg);
        out.println("--end");
        out.flush();
        Scanner scan = new Scanner(client.getInputStream());
        while(scan.hasNext()){
            System.out.println(scan.nextLine());
        }
        out.close();
        scan.close();
        client.close();
    }
}
