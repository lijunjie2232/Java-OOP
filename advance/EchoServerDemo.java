package advance;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class EchoServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(10649);
        System.out.println("wait for client ...");
        Socket client = null;
        while ((client = server.accept()) != null) {
            new Thread(new EchoServerSocketHandler(client)).start();
        }
        server.close();
    }
}

class EchoServerSocketHandler implements Runnable {
    private Socket client;

    public EchoServerSocketHandler() {
        client = null;
    }

    public EchoServerSocketHandler(Socket client) {
        this.bind(client);
    }

    public void bind(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " handling client message");
            if (this.client == null)
                throw new Exception("bind client first");
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
                                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ").format(new Date()) + "[LOG@"
                                        + Thread.currentThread().getName() + "] " + nextMsg);
                        out.println("[ECHO]" + nextMsg);
                        out.flush();
                    }
                }
            }
            out.write("[ECHO]" + "*** echo end ***");
            out.close();
            scan.close();
            this.client.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
}
