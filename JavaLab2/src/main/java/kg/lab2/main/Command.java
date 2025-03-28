package kg.lab2.main;

import java.util.*;

public interface Command {
    void execute(Context context, List<String> args) throws Exception;
}
