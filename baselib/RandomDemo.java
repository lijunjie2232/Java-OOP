package baselib;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random r = new Random(777);
        for (int i = 0; i < 10; i++)
            System.out.println(r.nextInt(2));
    }
}
