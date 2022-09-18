package hotspot.vm.classfile;

import cn.hutool.core.io.FileUtil;
import hotspot.vm.oops.InstanceKlass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BUTUbird
 * @ClassName BootClassLoader
 * @Description TODO
 * @Date 2022/9/17 2:08
 * @Version 1.0
 */
public class BootClassLoader {

    public static final String SUFFIX = ".class";

    /**
     * 类加载器路径
     */
    private final static String SEARCH_PATH = "E:\\Documents\\JavaProject\\jvm-source\\target\\classes\\";
    /**
     * 用于存储该类加载器加载的所有类
     */
    private static final Map<String, InstanceKlass> classLoaderData = new HashMap<>();

    /**
     * main函数所在类在此保存一份引用，方便快速定位。
     */
    private static InstanceKlass mainKlass = null;

    public static InstanceKlass getMainKlass(){
        return mainKlass;
    }

    public static void setMainKlass(InstanceKlass mainKlass){
        BootClassLoader.mainKlass = mainKlass;
    }


    public static InstanceKlass loadKlass(String name) {
            return loadKlass(name, true);
    }

    public static InstanceKlass loadKlass(String name, boolean resolve) {
        InstanceKlass Klass = findLoadedClass(name);
        if (Klass != null) {
            return Klass;
        }

        Klass = readAndParse(name);

        if (resolve) {
           resolveKlass();
        }
        return Klass;
    }

    private static void resolveKlass(){

    }

    private static InstanceKlass readAndParse(String name)  {
        String tmpName = name.replace('.', '/');
        String filePath = SEARCH_PATH + tmpName + SUFFIX;

        // 读取字节码文件
        byte[] content = FileUtil.readBytes(new File(filePath));

        // 解析字节码文件
        InstanceKlass klass = ClassFileParser.parseClassFile(content);

        // 存入
        classLoaderData.put(name, klass);

        return klass;
    }

    private static InstanceKlass findLoadedClass(String name) {
        return classLoaderData.get(name);
    }
    public static InstanceKlass loadMainKlass(String name){
        if (mainKlass != null){
            return mainKlass;
        }
        return loadKlass(name);
    }

}

