package baselib;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

class MyTask extends TimerTask{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " running ...");
        System.out.println(new Date());
    }
}

public class TimerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), 0, 1000);
    }
}
