package reflecttry;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

class ClassFactoryMyClass {
    private String name;
    private int age;

    public ClassFactoryMyClass() {
        System.out.println(this.getClass() + " construction");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "name: " + this.name + "\nage: " + this.age;
    }

}

class ClassFactoryStringUtil {
    public static Map<String, String> paramProcess(String param) {
        Map<String, String> paramMap = new HashMap<String, String>();
        try {
            for (String kv : param.split("&")) {
                String content[] = kv.split("=");
                if (content.length == 0)
                    continue;
                else if (content.length == 1)
                    paramMap.put(content[0], null);
                else
                    paramMap.put(content[0], content[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paramMap;
    }

    public static String firstCharUpper(String name) {
        if (name == null)
            return name;
        else if (name.length() == 1)
            return name.toUpperCase();
        else
            return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}

class ClassFactoryBeanUtil {
    public static void setValue(Object obj, Map<String, String> paramMap) {
        Class<?> cls = obj.getClass();
        for (String k : paramMap.keySet()) {
            try {
                Field fld = cls.getDeclaredField(k);
                Class<?> fldType = fld.getType();
                Method mth = cls.getDeclaredMethod("set" + ClassFactoryStringUtil.firstCharUpper(k), fldType);
                mth.invoke(obj, attrValConvert(fldType.getName(), paramMap.get(k)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static Object attrValConvert(String type, String value) throws Exception {
        if (type.equals("long") || type.equals("java.lang.Long")) {
            return Long.parseLong(value);
        } else if (type.equals("int") || type.equals("java.lang.int")) {
            return Integer.parseInt(value);
        } else if (type.equals("float") || type.equals("java.lang.float")) {
            return Float.parseFloat(value);
        } else if (type.equals("double") || type.equals("java.lang.double")) {
            return Double.parseDouble(value);
        } else if (type.equals("String") || type.equals("java.lang.String")) {
            return value;
        } else
            return null;
    }
}

@SuppressWarnings("unchecked")
class ClassFactory {
    public static <T> T getInstance(String className, String param) {
        T obj = null;
        try {
            obj = (T) Class.forName(className).getDeclaredConstructor().newInstance();
            Map<String, String> paramMap = ClassFactoryStringUtil.paramProcess(param);
            ClassFactoryBeanUtil.setValue(obj, paramMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}

public class ClassFactoryDemo {
    public static void main(String[] args) throws Exception {
        System.out.println(
                (ClassFactoryMyClass) ClassFactory.getInstance("reflecttry.ClassFactoryMyClass", "name=li&age=23"));
    }
}
