package iotry;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

class PipedMSGSender implements Runnable {
    private PipedOutputStream output;

    public PipedOutputStream getOutput() {
        return output;
    }

    public PipedMSGSender() {
        this.output = new PipedOutputStream();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                this.output
                        .write(("channel: " + Thread.currentThread().getName() + " has sent message: " + i)
                                .getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PipedMSGReceiver implements Runnable {
    private PipedInputStream input;

    public PipedMSGReceiver() {
        this.input = new PipedInputStream();
    }

    public PipedMSGReceiver(PipedMSGSender sneder) {
        this();
        this.setSender(sneder);
    }

    public PipedMSGReceiver setSender(PipedMSGSender sender) {
        try {
            this.input.connect(sender.getOutput());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public void run() {
        byte[] cache = new byte[37];
        try {
            for (int len = this.input.read(cache); len != -1; len = this.input.read(cache)) {
                System.out.println(new String(cache) + " -- from recever: " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.input != null)
                this.input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class PipedIODemo {
    public static void main(String[] args) {
        int THREAD_NUM = 10;
        List<Thread> senderList = new LinkedList<Thread>();
        List<Thread> receiverList = new LinkedList<Thread>();
        for (int i = 0; i < THREAD_NUM; i++) {
            PipedMSGSender sender = new PipedMSGSender();
            PipedMSGReceiver receiver = new PipedMSGReceiver(sender);
            senderList.add(new Thread(sender, "Sender_" + i));
            receiverList.add(new Thread(receiver, "Receiver_" + i));
        }
        for (Thread t : senderList) {
            t.start();
        }
        for (Thread t : receiverList) {
            t.start();
        }
    }
}
