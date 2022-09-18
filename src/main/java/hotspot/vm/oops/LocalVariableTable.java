package hotspot.vm.oops;

import lombok.Data;

/**
 * @author BUTUbird
 * @ClassName LocalVariableTable
 * @Description TODO
 * @Date 2022/9/17 2:21
 * @Version 1.0
 */
@Data
public class LocalVariableTable extends AttributeInfo {

    private int tableLength;
    private Item[] table;

    public void initTable() {
        table = new Item[tableLength];
    }

    @Data
    public class Item {
        private int startPc;
        private int length;
        private int nameIndex;
        private int descriptorIndex;
        private int index;
    }

}
