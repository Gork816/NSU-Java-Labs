package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import kg.lab2.main.CalculatorException.*;

public class DefineCommand implements Command {
    private static final Logger logger = LogManager.getLogger(DefineCommand.class);

    public void execute(Context context, List<String> args) throws ArgumentException {
        Map<String, Double> variables = context.getVars();

        if (args.size() < 2) {
            logger.error("Define: Missing argument(s)");
            throw new MissingArgumentException("Define");
        }

        String name = args.get(0);
        double value;
        try {
            value = Double.parseDouble(args.get(1));
        } catch (NumberFormatException e) {
            logger.error("Define: Incorrect argument '{}'", args.get(1));
            throw new WrongArgumentException("Define");
        }
        variables.put(name, value);
        logger.info("Define: {} {}", name, value);
    }
}

