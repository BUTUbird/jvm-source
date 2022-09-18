package hotspot.vm.classfile;

import hotspot.vm.oops.InstanceKlass;
import hotspot.vm.oops.MethodInfo;
import hotspot.vm.prims.JavaNativeInterface;
import hotspot.vm.runtime.JavaThread;
import hotspot.vm.runtime.Threads;

/**
 * @author BUTUbird
 * @ClassName Main
 * @Description TODO
 * @Date 2022/9/17 0:37
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        startJVM();
    }
    public static void startJVM() {
        // 模拟AppClassLoader加载main函数所在的类
        // 通过该类的全限定名获取存储该类的class文件
        InstanceKlass mainKlass = BootClassLoader.loadMainKlass("org.butu.jvm.example.HelloWorld");
        // 找到main方法
        MethodInfo mainMethod = JavaNativeInterface.getMethodID(mainKlass,"main", "([Ljava/lang/String;)V");

        // 创建线程
        JavaThread thread = new JavaThread();

        Threads.getThreadList().add(thread);
        Threads.setCurrentThread(thread);
        // 执行main方法
        JavaNativeInterface.callStaticMethod(mainMethod);
    }
}
