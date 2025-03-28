package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class DivCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DivCommand.class);

    public void execute(Context context, List<String> args) throws Exception {
        Deque<Double> stack = context.getStack();

        if (stack.size() < 2) {
            logger.warn("Div: Not enough elements in stack");
            throw new StackUnderflowException("Div");
        }

        double b = stack.pop();
        if (b == 0) {
            logger.warn("Div: Division by zero");
            throw new DivisionByZeroException();
        }
        double a = stack.pop();
        double result = a / b;
        stack.push(result);
        logger.info("Div: {} / {} = {} (Stack now: {})", a, b, result, stack);
    }
}

