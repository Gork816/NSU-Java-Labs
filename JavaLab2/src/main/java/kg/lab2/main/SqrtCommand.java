package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.EmptyStackException;

public class SqrtCommand implements Command {
    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) throws Exception {
        if (stack.isEmpty()) throw new EmptyStackException();
        double value = stack.pop();
        if (value < 0) throw new ArithmeticException("Negative argument");
        stack.push(Math.sqrt(value));
    }
}

