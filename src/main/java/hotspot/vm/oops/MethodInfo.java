package hotspot.vm.oops;

import hotspot.vm.utilitiles.AccessFlags;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BUTUbird
 * @ClassName MethodInfo
 * @Description TODO
 * @Date 2022/9/17 2:12
 * @Version 1.0
 */
@Data
public class MethodInfo {

    private InstanceKlass belongKlass;

    private AccessFlags accessFlags;

    private int nameIndex;
    private int descriptorIndex;
    private int attributesCount;

    private CodeAttributeInfo[] attributes;

    private String methodName;

    public void initAttributeContainer() {
        attributes = new CodeAttributeInfo[attributesCount];
    }

    @Override
    public String toString() {
        return "MethodInfo{ "
                + belongKlass.getConstantPool().getMethodName(nameIndex) + "#"
                + belongKlass.getConstantPool().getDescriptorName(descriptorIndex)
                + " }";
    }
}

