package baselib;

import java.util.UUID;

public class UuidDemo {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        UUID uid = UUID.randomUUID();
        System.out.println(UUID.fromString(uid.toString()));
    }
}
