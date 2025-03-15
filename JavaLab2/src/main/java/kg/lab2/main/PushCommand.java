package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;

public class PushCommand implements Command {
    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) throws Exception {
        if (args.isEmpty()) throw new IllegalArgumentException("Missing argument for PUSH");
        String value = args.getFirst();
        stack.push(variables.getOrDefault(value, Double.parseDouble(value)));
    }
}

