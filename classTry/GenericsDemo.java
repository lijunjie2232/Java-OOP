public class GenericsDemo {
    public static void main(String[] args) {
        GeneTest<String> geneTest = new GeneTest<>("0");
        show(geneTest);
        geneTest.setValue("123");
        show(geneTest);

        GeneMessage<String> messager = new GeneMessageImpl<String>();
        messager.debug("init success");
    }

    // public static void show(GeneTest<?> temp) {
    // System.out.println(temp);
    // }

    public static <T extends GeneTest<?>> void show(T temp) {
        System.out.println(temp);
    }
}

class GeneTest<T> {
    private T value;

    public GeneTest(T value) {
        this.setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;

    }

    @Override
    public String toString() {
        return "GeneTest [value=" + value + "]";
    }
}

interface GeneMessage<T> {
    public void debug(T t);
}

class GeneMessageImpl<T> implements GeneMessage<T> {
    @Override
    public void debug(T t) {
        System.out.println("[debug] " + t);
    }
}