package hotspot.vm.oops;

import lombok.Data;

/**
 * @author BUTUbird
 * @ClassName LineNumberTable
 * @Description TODO
 * @Date 2022/9/17 2:22
 * @Version 1.0
 */
@Data
public class LineNumberTable extends AttributeInfo {

    private int tableLength;
    private Item[] table;

    public void initTable() {
        table = new Item[tableLength];
    }

    @Data
    public class Item {
        private int startPc;
        private int lineNumber;
    }
}
