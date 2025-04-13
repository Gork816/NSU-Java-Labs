package kg.lab2.main;

import java.util.*;
import kg.lab2.main.CalculatorException.*;

public interface Command {
    void execute(Context context, List<String> args) throws CommandException;
}
