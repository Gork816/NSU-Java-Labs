package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PushTest {
    @Test
    void testPushNumber() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        Map<String, Double> variables = new HashMap<>();
        List<String> args = List.of("5.0");

        new PushCommand().execute(stack, variables, args);

        assertEquals(5.0, stack.peek());
    }

    @Test
    void testPushVariable() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        Map<String, Double> variables = new HashMap<>();
        variables.put("a", 10.0);
        List<String> args = List.of("a");

        new PushCommand().execute(stack, variables, args);

        assertEquals(10.0, stack.peek());
    }

    @Test
    void testPushInvalidValue() {
        Deque<Double> stack = new ArrayDeque<>();
        Map<String, Double> variables = new HashMap<>();
        List<String> args = List.of("invalid");

        Exception exception = assertThrows(NumberFormatException.class, () ->
                new PushCommand().execute(stack, variables, args)
        );

        assertTrue(exception.getMessage().contains("For input string"));
    }
}