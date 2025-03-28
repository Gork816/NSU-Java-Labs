package kg.lab2.main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import kg.lab2.main.CalculatorException.*;

public class Context {
    Deque<Double> stack = new ArrayDeque<>();
    Map<String, Double> variables = new HashMap<>();

    Deque<Double> getStack() {
        return stack;
    }

    Map<String, Double> getVars() {
        return variables;
    }
}
