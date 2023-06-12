package reflecttry;

import java.lang.reflect.*;

interface DynamicProxyIMessage {
    public void send();

    public void close();
}

class DynamicProxyMessageImpl implements DynamicProxyIMessage {
    public DynamicProxyMessageImpl() {
        System.out.println("DynamicProxyMessageImpl construction");
    }

    public void send() {
        System.out.println("DynamicProxyMessageImpl sent");
    }

    public void close() {
        System.out.println("DynamicProxyMessageImpl closed");
    }
}

class DynamicProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object pro, Method method, Object[] args) throws Exception {
        System.out.println("method: " + method.getName() + " invoked");
        return method.invoke(this.target, args);
    }
}

public class DynamicProxyDemo {
    public static void main(String[] args) {
        DynamicProxyIMessage msg = (DynamicProxyIMessage) new DynamicProxy().bind(new DynamicProxyMessageImpl());
        msg.send();
        msg.close();
    }
}
