package iotry;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileIoDemo {
    public static void main(String[] args) {
        File file = new File("./baselib/custom.properties");
        System.out.println("getAbsolutePath: " + file.getAbsolutePath());
        System.out.println("exists: " + file.exists());
        System.out.println("getParent: " + file.getParent());
        System.out.println("length: " + file.length());
        System.out.println("canWrite: " + file.canWrite());
        System.out.println("lastModified: " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(file.lastModified()));
        File[] files = file.getParentFile().listFiles();
        System.out.println("****** list files of " + file.getParent() + " start ******");
        for (File f : files) {
            System.out.println(f.getName());
        }
        System.out.println("****** list files of " + file.getParent() + " end ******");

    }
}
