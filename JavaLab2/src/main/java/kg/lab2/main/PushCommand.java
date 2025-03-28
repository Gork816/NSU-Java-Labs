package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class PushCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PushCommand.class);

    public void execute(Context context, List<String> args) throws Exception {
        Deque<Double> stack = context.getStack();
        Map<String, Double> variables = context.getVars();

        if (args.isEmpty()) {
            logger.warn("Push: Missing argument");
            throw new MissingArgumentException("Push");
        }
        String value = args.getFirst();
        try {
            if (variables.containsKey(value)) {
                stack.push(variables.get(value));
            } else {
                stack.push(Double.parseDouble(value));
            }
        } catch (IllegalArgumentException e) {
            logger.warn("Push: Incorrect argument - '{}'", value);
            throw new WrongArgumentException("Push");
        }
        logger.info("Push: {} (Stack now: {})", value, stack);
    }
}

