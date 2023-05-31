import java.util.LinkedList;
import java.util.List;

class MySyncThread implements Runnable {
    private int tickets = 100;

    public MySyncThread() {
        super();
    }

    private synchronized boolean sale() {
        if (this.tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " has sold a ticket, tickets remain: " + this.tickets);
            this.tickets--;
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        while (this.sale()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SyncDemo {
    public static void main(String[] args) {
        MySyncThread solder = new MySyncThread();
        List<Thread> threads = new LinkedList<Thread>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(solder, "うけつけ-1"));
            threads.add(new Thread(solder, "うけつけ-2"));
            threads.add(new Thread(solder, "うけつけ-3"));
        }
        for (Thread mt : threads) {
            mt.start();
        }
    }
}
