package kg.lab2.main;

import java.util.*;

public interface Command {
    void execute(Deque<Double> stack, Map<String, Double> variables, List<String> args) throws Exception;
}
