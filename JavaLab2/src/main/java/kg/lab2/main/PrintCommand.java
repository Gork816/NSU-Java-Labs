package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.EmptyStackException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PrintCommand.class);

    public void execute(Context context, List<String> args) throws Exception {
        Deque<Double> stack = context.getStack();

        if (stack.isEmpty()) {
            logger.warn("Print: Empty stack");
            throw new EmptyStackException();
        }
        System.out.println(stack.peek());
        logger.info("Print: {}", stack.peek());
    }
}

