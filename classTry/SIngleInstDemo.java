// 懒汉式单例
// class SingleTon {
//     private static final SingleTon INSTANCE = new SingleTon();
//     private SingleTon(){
//         System.out.println("SingleTon constructing ...");
//     }
//     public static SingleTon getInstance(){
//         return INSTANCE;
//     }
//     public void show(){
//         System.out.println("SingleTon show");
//     }
// }

//饿汉式单例
class SingleTon {
    private static SingleTon INSTANCE;

    private SingleTon() {
        System.out.println("SingleTon constructing ...");
    }

    public static SingleTon getInstance() {
        if (INSTANCE == null)
            INSTANCE = new SingleTon();
        return INSTANCE;
    }

    public void show() {
        System.out.println("SingleTon show");
    }
}

public class SIngleInstDemo {
    public static void main(String[] args) {
        SingleTon instance = null;
        instance = SingleTon.getInstance();
        instance.show();
    }
}
