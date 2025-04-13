package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class PrintCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PrintCommand.class);

    public void execute(Context context, List<String> args) throws EmptyStackException {
        Deque<Double> stack = context.getStack();

        if (stack.isEmpty()) {
            logger.warn("Print: Empty stack");
            throw new EmptyStackException();
        }
        System.out.println(stack.peek());
        logger.info("Print: {}", stack.peek());
    }
}

