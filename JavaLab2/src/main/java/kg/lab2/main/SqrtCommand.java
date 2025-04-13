package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class SqrtCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SqrtCommand.class);

    public void execute(Context context, List<String> args) throws StackUnderflowException, NegativeSqrtException {
        Deque<Double> stack = context.getStack();

        if (stack.isEmpty()) {
            logger.warn("Sqrt: Not enough elements in stack");
            throw new StackUnderflowException("Sqrt");
        }
        double value = stack.pop();
        if (value < 0) {
            logger.warn("Sqrt: Negative argument");
            throw new NegativeSqrtException(value);
        }
        double result = Math.sqrt(value);
        stack.push(result);
        logger.info("Sqrt: {} -> {} (Stack now: {}", value, result, stack);
    }
}

