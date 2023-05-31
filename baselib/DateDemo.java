package baselib;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateDemo {
    public static void main(String[] args) {
        Date data = new Date();
        System.out.println(data);
        System.out.println(data.getTime());
        System.out.println(data.hashCode());
        System.out.println(new Date(System.currentTimeMillis() + 100000000));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(new Date()));
    }
}
