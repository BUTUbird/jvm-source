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
 * @ClassName BaseBytecodeStream
 * @Description TODO
 * @Date 2022/9/17 2:16
 * @Version 1.0
 */
@Data
public class BaseBytecodeStream extends StackObj {

    protected MethodInfo belongMethod;
    protected CodeAttributeInfo belongCode;

    protected int length;
    protected int index;
    protected byte[] codes;

    /**
     * 一次取一字节数据，自动累加
     * @return
     */
    public int getU1Code() {
        if (index < 0 || index >= length) {
            throw new Error("字节码指令的索引超过了最大值");
        }

        return Byte.toUnsignedInt(codes[index++]);
    }

    public int getU2Code() {
        if (index < 0 || index >= length) {
            throw new Error("字节码指令的索引超过了最大值");
        }

        byte[] u2Arr = new byte[2];

        Stream.readU2Simple(codes, index, u2Arr);

        index += 2;

        return DataTranslate.byteArrayToInt(u2Arr);
    }

    public short getUnsignedShort() {
        if (index < 0 || index >= length) {
            throw new Error("字节码指令的索引超过了最大值");
        }

        byte[] u2Arr = new byte[2];

        Stream.readU2Simple(codes, index, u2Arr);

        index += 2;

        return (short) DataTranslate.byteToUnsignedShort(u2Arr);
    }

    public int getU4Code() {
        if (index < 0 || index >= length) {
            throw new Error("字节码指令的索引超过了最大值");
        }

        byte[] arr = new byte[4];

        Stream.readU2Simple(codes, index, arr);
        index += 4;

        ByteBuffer buffer = ByteBuffer.wrap(arr);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        return buffer.getInt();
    }

    public void reset() {
        index = 0;
    }

    public boolean end() {
        return index >= length;
    }

    public void inc(int step) {
        index +=  step;
    }
}
