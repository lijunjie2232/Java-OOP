package baselib;

public class RuntimeDemo {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.availableProcessors());
        System.out.println("***** memory *******");
        System.out.println(rt.maxMemory());
        System.out.println(rt.totalMemory());
        System.out.println(rt.freeMemory());
        rt.gc();
        System.out.println("****** after gc ******");
        System.out.println(rt.maxMemory());
        System.out.println(rt.totalMemory());
        System.out.println(rt.freeMemory());
        System.out.println("****** after new instance ******");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            new StringBuffer(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("new instance takes: "+(endTime-startTime) + " milli seconds");
        System.out.println(rt.maxMemory());
        System.out.println(rt.totalMemory());
        System.out.println(rt.freeMemory());
        System.out.println("****** after gc ******");
        rt.gc();
        System.out.println(rt.maxMemory());
        System.out.println(rt.totalMemory());
        System.out.println(rt.freeMemory());
    }
}
