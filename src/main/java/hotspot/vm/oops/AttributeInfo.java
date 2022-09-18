package hotspot.vm.oops;

import lombok.Data;

/**
 * @author BUTUbird
 * @ClassName AttributeInfo
 * @Description TODO
 * @Date 2022/9/17 2:14
 * @Version 1.0
 */
@Data
public class AttributeInfo {
    private int attrNameIndex;
    private int attrLength;

    // 用于存储klass的attribute
    private byte[] container;

    public void initContainer() {
        container = new byte[attrLength];
    }

}
