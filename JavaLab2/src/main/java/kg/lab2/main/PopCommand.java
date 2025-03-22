package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.EmptyStackException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopCommand implements Command {
    private static final Logger logger = LogManager.getLogger(PopCommand.class);

    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) throws Exception {
        if (stack.isEmpty()) {
            logger.error("Pop: Empty stack");
            throw new EmptyStackException();
        }
        logger.info("Pop: {}", stack.peek());
        stack.pop();
    }
}

