package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefineCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DefineCommand.class);

    public void execute(Context context, List<String> args) throws Exception {
        Map<String, Double> variables = context.getVars();

        if (args.size() < 2) {
            logger.error("Define: Missing argument(s)");
            throw new IllegalArgumentException("Not enough arguments for Define");
        }

        String name = args.get(0);
        double value;
        try {
            value = Double.parseDouble(args.get(1));
        } catch (NumberFormatException e) {
            logger.error("Define: Incorrect argument '{}'", args.get(1));
            throw new IllegalArgumentException("Incorrect argument: " + args.get(1));
        }
        variables.put(name, value);
        logger.info("Define: {} {}", name, value);
    }
}

