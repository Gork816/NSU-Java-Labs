package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ExitCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ExitCommand.class);

    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) {
        System.out.println("Exiting...");
        logger.info("Exit");
        System.exit(0);
    }
}

