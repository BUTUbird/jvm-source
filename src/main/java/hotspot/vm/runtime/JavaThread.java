package hotspot.vm.runtime;

import lombok.Data;

import java.util.Stack;




/**
 * @author BUTUbird
 */
@Data
public class JavaThread extends Thread {

    private Stack<VFrame> stack = new Stack<>();

}
