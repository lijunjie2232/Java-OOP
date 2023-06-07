package iotry;

import java.io.*;

class MySerializableClass implements Serializable {
    private String name;
    private int age;

    public MySerializableClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age;
    }

    public void save(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MySerializableClass load(File file) {
        MySerializableClass msc = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            msc = (MySerializableClass) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msc;
    }
}

@SuppressWarnings("serial")
public class SeriaalizableDemo {
    public static void main(String[] args) {
        try {
            MySerializableClass msc = new MySerializableClass("yahaha", 0);
            System.out.println(msc);
            msc.save(new File("iotry/MySerializableClass.bin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("***********");
        try {
            File msc_bin = new File("iotry/MySerializableClass.bin");
            if (msc_bin.exists()) {
                MySerializableClass msc = MySerializableClass.load(msc_bin);
                System.out.println(msc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
