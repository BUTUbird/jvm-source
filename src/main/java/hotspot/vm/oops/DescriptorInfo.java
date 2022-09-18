package hotspot.vm.oops;

import lombok.Data;

/**
 * @author BUTUbird
 * @ClassName DescriptorInfo
 * @Description TODO
 * @Date 2022/9/18 19:35
 * @Version 1.0
 */
@Data
public class DescriptorInfo {

    /**
     * 是否完成解析并赋值
     * 默认false
     */
    private boolean isResolved = false;

    // 类型
    private int type;

    // 数组维度
    private int arrayDimension;

    // 类型
    private String typeDesc;

    public void incArrayDimension() {
        arrayDimension++;
    }

    public DescriptorInfo() {
    }

    public DescriptorInfo(boolean isResolved, int type) {
        this.isResolved = isResolved;
        this.type = type;
    }

    public DescriptorInfo(boolean isResolved, int type, String typeDesc) {
        this.isResolved = isResolved;
        this.type = type;
        this.typeDesc = typeDesc;
    }
}

