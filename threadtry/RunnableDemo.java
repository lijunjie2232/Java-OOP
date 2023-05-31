class MyRunnableThread implements Runnable {
    private String title;

    private int i = 10;

    public MyRunnableThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (; i > 0; i--) {
            System.out.println(title + " : " + i);
            // try {
            //     Thread.sleep(100);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnableThread("Demo"));
        t.start();
        for( int x = 0; x < 3; x ++){
            String title = "thread " + x;
            Runnable run = () -> {
                for (int y = 0; y < 10; y++) {
                    System.out.println(title + " run " + y);
                }
            };
            new Thread(run).start();
        }
        MyRunnableThread mt = new MyRunnableThread("Demo");
        for( int x = 0; x < 3; x ++){
            new Thread(mt).start();
        }

    }
}