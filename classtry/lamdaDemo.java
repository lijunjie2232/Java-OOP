import java.util.function.*;

@FunctionalInterface
interface IMessage {
    public String send(String str, int time);
}

@FunctionalInterface
interface IFunction<P, R> {
    public R transform(P p);
}

public class lamdaDemo {
    public static void main(String[] args) {
        IMessage msg = (message, t) -> {
            for (; t > 0; t--)
                System.out.println("MESSAGE FROM " + new lamdaDemo().getClass() + ": " + message);
            return "Success";
        };
        System.out.println(msg.send("demo of lamda", 3));

        IFunction<Integer, String> ifunc = String::valueOf;
        System.out.println(ifunc.transform(123456).getClass());

        Function<Integer, String> fun = String::valueOf;
        System.out.println(fun.apply(123456));
    }
}
