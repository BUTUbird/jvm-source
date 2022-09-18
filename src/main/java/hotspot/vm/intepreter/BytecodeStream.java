package hotspot.vm.intepreter;

import hotspot.tools.DataTranslate;
import hotspot.tools.Stream;
import hotspot.vm.memory.StackObj;
import hotspot.vm.oops.CodeAttributeInfo;
import hotspot.vm.oops.MethodInfo;
import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author BUTUbird
 * @ClassName BytecodeStream
 * @Description TODO
 * @Date 2022/9/17 2:17
 * @Version 1.0
 */
public class BytecodeStream extends BaseBytecodeStream {

    public BytecodeStream(MethodInfo belongMethod, CodeAttributeInfo belongCode) {
        this.belongMethod = belongMethod;
        this.belongCode = belongCode;
        this.length = belongCode.getCodeLength();
        this.index = 0;
        this.codes = new byte[this.length];
    }

}
