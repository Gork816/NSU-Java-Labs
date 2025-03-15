package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;

public class DefineCommand implements Command {
    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) throws Exception {
        if (args.size() < 2) throw new IllegalArgumentException("Not enough arguments for DEFINE");
        String name = args.get(0);
        double value = Double.parseDouble(args.get(1));
        variables.put(name, value);
    }
}

