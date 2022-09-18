package hotspot.vm.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author BUTUbird
 * @ClassName FieldInfo
 * @Description TODO
 * @Date 2022/9/17 2:12
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldInfo {
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private int attributesCount;
    private CodeAttributeInfo[] attributes;

}
