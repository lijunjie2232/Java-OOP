package advance;

import java.net.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class EchoServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(10649);
        System.out.println("wait for client ...");
        Socket client = null;
        while ((client = server.accept()) != null) {
            Scanner scan = new Scanner(client.getInputStream());
            scan.useDelimiter("\n");
            PrintWriter out = new PrintWriter(client.getOutputStream());
            out.println("[ECHO]" + "*** echo start ***");
            boolean flag = true;
            while (flag) {
                if (scan.hasNext()) {
                    String nextMsg = new String(scan.next().trim());
                    if (nextMsg.equals("--end"))
                        flag = false;
                    else {
                        System.out.println(
                                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ").format(new Date()) + "[LOG] " + nextMsg);
                        out.println("[ECHO]" + nextMsg);
                        out.flush();
                    }
                }
            }
            out.write("[ECHO]" + "*** echo end ***");
            out.close();
            scan.close();
            client.close();
            client = null;
        }
        server.close();
    }
}
