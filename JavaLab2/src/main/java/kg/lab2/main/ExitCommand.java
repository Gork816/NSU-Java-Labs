package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;

class ExitCommand implements Command {
    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) {
        System.out.println("Exiting...");
        System.exit(0);
    }
}

