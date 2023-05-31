import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyCallabelThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return 0;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> task = new FutureTask<Integer>(new MyCallabelThread());
        new Thread(task).start();
        System.out.println(task.get());
    }
}
