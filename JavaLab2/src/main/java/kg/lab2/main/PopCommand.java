package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class PopCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PopCommand.class);

    public void execute(Context context, List<String> args) throws Exception {
        Deque<Double> stack = context.getStack();

        if (stack.isEmpty()) {
            logger.error("Pop: Empty stack");
            throw new EmptyStackException();
        }
        logger.info("Pop: {}", stack.peek());
        stack.pop();
    }
}

