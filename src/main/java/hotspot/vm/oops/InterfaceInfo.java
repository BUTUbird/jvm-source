package hotspot.vm.oops;

import lombok.Data;

/**
 * @author BUTUbird
 * @ClassName InterfaceInfo
 * @Description TODO
 * @Date 2022/9/17 2:11
 * @Version 1.0
 */
@Data
public class InterfaceInfo {

    private int constantPoolIndex;

    private String interfaceName;

    public InterfaceInfo(int index, String name) {
        this.constantPoolIndex = index;
        this.interfaceName = name;
    }
}
