package baselib;

import java.lang.ref.Cleaner;

class MyCleanableClass implements Runnable {
    public MyCleanableClass() {
        System.out.println("MyCleanableClass constructe");
    }

    public void run() {
        System.out.println("MyCleanableClass destroy");
    }

    public void show() {
        System.out.println("MyCleanableClass show");
    }
}

class MyCleanableClassCleaning implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();
    private MyCleanableClass mcc;
    private Cleaner.Cleanable cleanable;

    public MyCleanableClassCleaning() {
        this.mcc = new MyCleanableClass();
        this.cleanable = MyCleanableClassCleaning.cleaner.register(this, this.mcc);
    }

    public void close() throws Exception {
        System.out.println("MyCleanableClassCleaning close");
        this.cleanable.clean();
    }

    public void show() {
        this.mcc.show();
    }
}

public class CleanerDemo {
    public static void main(String[] args) {
        try (MyCleanableClassCleaning mccc = new MyCleanableClassCleaning()) {
            mccc.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
