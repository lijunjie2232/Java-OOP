package baselib;

import java.text.MessageFormat;

class ThreadLocalChannel { // 消息.的发送通道

    private static ThreadLocal<ThreadLocalMessage> MESSAGE = new ThreadLocal<ThreadLocalMessage>();

    public static void setMessage(ThreadLocalMessage m) {
        MESSAGE.set(m);
    }

    public static void send() { // 发送消息.
        System.out.println("【消息发送】" + MESSAGE.get().getInfo());
        MESSAGE.remove();
    }

}

class ThreadLocalMessage { // 要发送的消息体

    private String info;

    public ThreadLocalMessage(String info) {
        this.info = info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocalMessage message = new ThreadLocalMessage("hello world!");
        ThreadLocalChannel.setMessage(message);
        ThreadLocalChannel.send();
        for (int i = 0; i < 3; i ++){
            new Thread(
                ()->{
                    ThreadLocalMessage msg = new ThreadLocalMessage(MessageFormat.format("{0} hello world!", Thread.currentThread().getName()));
                    ThreadLocalChannel.setMessage(msg);
                    ThreadLocalChannel.send();
                }, "sender_" + i
            ).start();
        }
    }
}
