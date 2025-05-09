package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class SubCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SubCommand.class);

    public void execute(Context context, List<String> args) throws StackUnderflowException {
        Deque<Double> stack = context.getStack();

        if (stack.size() < 2) {
            logger.warn("Sub: Not enough elements in stack");
            throw new StackUnderflowException("Sub");
        }

        double b = stack.pop();
        double a = stack.pop();
        double result = a - b;
        stack.push(result);
        logger.info("Sub: {} - {} = {} (Stack now: {})", a, b, result, stack);
    }
}

