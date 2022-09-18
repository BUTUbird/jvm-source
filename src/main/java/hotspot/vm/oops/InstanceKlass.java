package hotspot.vm.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BUTUbird
 * @ClassName InstanceKlass
 * @Description TODO
 * @Date 2022/9/17 2:09
 * @Version 1.0
 */
@Data
public class InstanceKlass extends Klass {

    private byte[] magic = new byte[4];
    private byte[] minorVersion = new byte[2];
    private byte[] majorVersion = new byte[2];

    private ConstantPool constantPool;

    private int accessFlag;
    private int thisClass;
    private int superClass;

    private int interfacesLength;
    private List<InterfaceInfo> interfaceInfos = new ArrayList<>();

    private int fieldsLength;
    private List<FieldInfo> fields = new ArrayList<>();

    private int methodLength;
    private MethodInfo[] methods;

    private int attributeLength;
    private List<AttributeInfo> attributeInfos = new ArrayList<>();

    public InstanceKlass() {
        constantPool = new ConstantPool();

        constantPool.setKlass(this);
    }

    public void initMethodsContainer() {
        methods = new MethodInfo[methodLength];
    }

    @Override
    public String toString() {
        return "InstanceKlass{ }";
    }
}
