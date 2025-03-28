package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import kg.lab2.main.CalculatorException.*;

class PushTest {
    @Test
    void testPushNumber() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        Map<String, Double> variables = context.getVars();
        List<String> args = List.of("5.0");

        new PushCommand().execute(context, args);

        assertEquals(5.0, stack.peek());
    }

    @Test
    void testPushVariable() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        Map<String, Double> variables = context.getVars();
        variables.put("a", 10.0);
        List<String> args = List.of("a");

        new PushCommand().execute(context, args);

        assertEquals(10.0, stack.peek());
    }

    @Test
    void testPushInvalidValue() {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        Map<String, Double> variables = context.getVars();
        List<String> args = List.of("invalid");

        Exception exception = assertThrows(WrongArgumentException.class, () ->
                new PushCommand().execute(context, args)
        );
    }
}