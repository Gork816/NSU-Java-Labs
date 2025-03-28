package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.EmptyStackException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddCommand implements Command {
    private static final Logger logger = LogManager.getLogger(AddCommand.class);

    public void execute(Context context, List<String> args) throws Exception {
        Deque<Double> stack = context.getStack();

        if (stack.size() < 2) {
            logger.warn("Add: Not enough elements in stack");
            throw new EmptyStackException();
        }

        double b = stack.pop();
        double a = stack.pop();
        double result = a + b;
        stack.push(result);
        logger.info("Add: {} + {} = {} (Stack now: {})", a, b, result, stack);
    }
}

