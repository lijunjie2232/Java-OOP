package advance;

import java.net.*;
import java.util.*;
import java.io.*;

public class UDPClientDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket(10648);
        // String msg = "{\"msg\": \"Hello Wolrd!\"}";
        byte [] cache = new byte[1024];
        DatagramPacket packet = new DatagramPacket(cache, cache.length);
        System.out.println("wait for message fallback");
        client.receive(packet);
        System.out.println(new String(cache, 0, packet.getLength()));
        client.close();
    }
}
