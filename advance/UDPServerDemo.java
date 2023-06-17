package advance;

import java.net.*;
import java.util.*;
import java.io.*;

public class UDPServerDemo {
    public static void main(String[] args) throws Exception {
        try (DatagramSocket server = new DatagramSocket()) {
            String msg = "{\"msg\": \"Hello Wolrd!\"}";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
                    InetAddress.getByName("127.0.0.1"), 10648);
            System.out.println("sending message fallback");
            while (true) {
                server.send(packet);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
