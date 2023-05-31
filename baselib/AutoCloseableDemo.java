package baselib;

abstract class IMessage implements AutoCloseable {
    public abstract void open();

    public abstract void send(String msg);

    public abstract void close() throws Exception;
}

class IMessageService extends IMessage {
    private boolean opened;

    public IMessageService() {
        this.opened = false;
    }

    public void open() {
        this.opened = true;
        System.out.println("opened");
    }

    public void send(String msg) {
        if (this.opened) {
            this.open();
        }
        System.out.println("send message: " + msg);
    }

    public void close() throws Exception {
        this.opened = false;
        System.out.println("closed");
    }
}

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try(IMessage ims = new IMessageService()){
            ims.send("hello world!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
