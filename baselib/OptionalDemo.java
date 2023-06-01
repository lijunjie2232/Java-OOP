package baselib;

import java.util.Optional;

class MyOptionalClass{
    public static Optional<String> getMessage(String msg){
        return Optional.of(msg);
    }
    public static Optional<String> getMessageNullable(String msg){
        return Optional.ofNullable(msg);
    }
}

public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(MyOptionalClass.getMessage("test").get());
        //throw java.lang.NullPointerException
        // System.out.println(MyOptionalClass.getMessage(null));
        System.out.println(MyOptionalClass.getMessageNullable("test").get());
        System.out.println(MyOptionalClass.getMessageNullable(null));
        //throw java.util.NoSuchElementException
        // System.out.println(MyOptionalClass.getMessageNullable(null).get());
        System.out.println(MyOptionalClass.getMessageNullable(null).orElse("null"));

    }
}
