package hotspot.vm.prims;

import hotspot.vm.intepreter.BytecodeInterpreter;
import hotspot.vm.oops.CodeAttributeInfo;
import hotspot.vm.oops.InstanceKlass;
import hotspot.vm.oops.MethodInfo;
import hotspot.vm.runtime.JavaThread;
import hotspot.vm.runtime.JavaVFrame;
import hotspot.vm.runtime.Threads;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author BUTUbird
 * @ClassName JavaNativeInterface
 * @Description TODO
 * @Date 2022/9/18 20:42
 * @Version 1.0
 */
public class JavaNativeInterface {

    private final static Logger logger = LoggerFactory.getLogger(JavaNativeInterface.class);

    public static InstanceKlass findClass(String name) {

        return null;
    }

    public static MethodInfo getMethodID(InstanceKlass klass, String name, String descriptorName) {
        MethodInfo[] methods = klass.getMethods();
        System.out.println("klass = " + klass + ", name = " + name + ", methods = " + Arrays.toString(methods));
        for (MethodInfo method:methods) {
            String tmpName = (String) klass.getConstantPool().getDataMap().get(method.getNameIndex());
            String tmpDescriptor = (String) klass.getConstantPool().getDataMap().get(method.getDescriptorIndex());

            if (tmpName.equals(name) && tmpDescriptor.equals(descriptorName)) {
                logger.info("找到了方法: " + name + "#" + descriptorName);

                return method;
            }
        }

        logger.error("没有找到方法: " + name + "#" + descriptorName);

        return null;
    }

    public static void callStaticMethod(MethodInfo method) {
        JavaThread thread = Threads.currentThread();

        if (!method.getAccessFlags().isStatic()) {
            throw new Error("只能调用静态方法");
        }

        CodeAttributeInfo codeAttributeInfo = method.getAttributes()[0];

        // 创建栈帧
        JavaVFrame frame = new JavaVFrame(codeAttributeInfo.getMaxLocals(), method);

        thread.getStack().push(frame);

        logger.info("第 " + thread.getStack().size() + " 个栈帧");

        // 执行任务交给字节码解释器
        BytecodeInterpreter.run(thread, method);
    }

}

