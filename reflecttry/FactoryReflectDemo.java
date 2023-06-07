package reflecttry;

interface FactoryReflectChannel {
    public void receive();
}

interface FactoryReflectMessage {
    public void send();
}

class FactoryReflectChannelUSBImpl implements FactoryReflectChannel {
    public FactoryReflectChannelUSBImpl() {
        System.out.println("construct func of " + this.getClass().getName());
    }

    @Override
    public void receive() {
        System.out.println("USB Channel received");
    }
}

class FactoryReflectChannelKeyBoardImpl implements FactoryReflectChannel {
    public FactoryReflectChannelKeyBoardImpl() {
        System.out.println("construct func of " + this.getClass().getName());
    }

    @Override
    public void receive() {
        System.out.println("KeyBoard Channel received");
    }
}

class FactoryReflectMessageUSBImpl implements FactoryReflectMessage {
    public FactoryReflectMessageUSBImpl() {
        System.out.println("construct func of " + this.getClass().getName());
    }

    @Override
    public void send() {
        System.out.println("USB Message sent");
    }
}

class FactoryReflectMessageKeyBoardImpl implements FactoryReflectMessage {
    public FactoryReflectMessageKeyBoardImpl() {
        System.out.println("construct func of " + this.getClass().getName());
    }

    @Override
    public void send() {
        System.out.println("KeyBoard Message sent");
    }
}

@SuppressWarnings("unchecked")
class FactoryReflectFactory {
    public static <T> T getInstance(String className, Class<T> clazz) throws Exception {
        return (T) Class.forName(className).getDeclaredConstructor().newInstance();
    }
}

public class FactoryReflectDemo {
    public static void main(String[] args) throws Exception {
        FactoryReflectChannel frc1 = (FactoryReflectChannel) FactoryReflectFactory.getInstance(
                "reflecttry.FactoryReflectChannelUSBImpl",
                FactoryReflectChannel.class);
        frc1.receive();
        System.out.println(frc1.getClass());
        System.out.println("***************");

        FactoryReflectChannel frc2 = (FactoryReflectChannel) FactoryReflectFactory.getInstance(
                "reflecttry.FactoryReflectChannelKeyBoardImpl",
                FactoryReflectChannel.class);
        frc2.receive();
        System.out.println(frc2.getClass());
        System.out.println("***************");

        FactoryReflectMessage frm1 = (FactoryReflectMessage) FactoryReflectFactory.getInstance(
                "reflecttry.FactoryReflectMessageUSBImpl",
                FactoryReflectMessage.class);
        frm1.send();
        System.out.println(frc2.getClass());
        System.out.println("***************");

        FactoryReflectMessage frm2 = (FactoryReflectMessage) FactoryReflectFactory.getInstance(
                "reflecttry.FactoryReflectMessageKeyBoardImpl",
                FactoryReflectMessage.class);
        frm2.send();
        System.out.println(frc2.getClass());
    }
}
