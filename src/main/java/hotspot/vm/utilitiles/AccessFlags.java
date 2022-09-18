package hotspot.vm.utilitiles;


import lombok.Data;

/**
 * @author BUTUbird
 * @ClassName AccessFlags
 * @Description TODO
 * @Date 2022/9/17 2:18
 * @Version 1.0
 */
@Data
public class AccessFlags {

    private int flag;

    public AccessFlags(int flag) {
        this.flag = flag;
    }

    public boolean isStatic() {
        return (flag & BasicType.JVM_ACC_STATIC) != 0;
    }
}
