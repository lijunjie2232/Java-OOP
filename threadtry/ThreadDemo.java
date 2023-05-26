class MyThread extends Thread {
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
public class ThreadDemo{
    public static void main(String[] args) throws Exception{
        MyThread [] thread = new MyThread[3];
        for (int i = 0; i < thread.length; i ++){
            thread[i] = new MyThread("thread" + i);
        }
        thread[0].start();
        // thread[0].start();// throw java.lang.IllegalThreadStateException
        thread[0].join();
        System.out.println("finished");
        
    }
}