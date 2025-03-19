package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PopTest {
    @Test
    void testPopFromStack() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(5.0);

        new PopCommand().execute(stack, new HashMap<>(), List.of());

        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopFromEmptyStack() {
        Deque<Double> stack = new ArrayDeque<>();

        assertThrows(EmptyStackException.class, () ->
                new PopCommand().execute(stack, new HashMap<>(), List.of())
        );
    }
}