package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

class ExitCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ExitCommand.class);

    public void execute(Context context, List<String> args) {
        System.out.println("Exiting...");
        logger.info("Exit");
        System.exit(0);
    }
}

