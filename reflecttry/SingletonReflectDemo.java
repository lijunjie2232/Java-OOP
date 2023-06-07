package reflecttry;

class SingletonReflectClass {
    private static volatile SingletonReflectClass instance = null;

    private SingletonReflectClass() {
        System.out.println("SingletonReflectClass constructing");
    }

    // without synchronized it may create instance for more than 1 time
    public static SingletonReflectClass getInstance() {
        if (instance == null) {
            synchronized (SingletonReflectClass.class) {
                if (instance == null)
                    instance = new SingletonReflectClass();
            }
        }
        return instance;
    }

    public void show() {
        System.out.println(Thread.currentThread().getName() + ": SingletonReflectClass show");
    }
}

public class SingletonReflectDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonReflectClass.getInstance().show();
            }, "class " + i).start();
        }
    }
}
