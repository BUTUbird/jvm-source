package hotspot.vm.oops;

import hotspot.vm.intepreter.BytecodeStream;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BUTUbird
 * @ClassName CodeAttributeInfo
 * @Description TODO
 * @Date 2022/9/17 2:13
 * @Version 1.0
 */
@Data
public class CodeAttributeInfo {
    private int attrNameIndex;
    private int attrLength;

    private int maxStack;
    private int maxLocals;

    private int codeLength;
    private BytecodeStream code;

    private int exceptionTableLength;

    // 如局部变量表、操作数栈
    private int attributesCount;

    private Map<String, AttributeInfo> attributes = new HashMap<>();

}
