package kg.lab2.main;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.EmptyStackException;

public class MulCommand implements Command {
    public void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) throws Exception {
        if (stack.size() < 2) throw new EmptyStackException();
        stack.push(stack.pop() * stack.pop());
    }
}
