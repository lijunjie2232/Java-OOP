class MyThread implements Runnable{
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    
    @Override
    public void run() {
    for (int i = 10; i > 0; i --){
        System.out.println(title + " : " + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
}
public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread("Demo"));
        t.start();
    }
}