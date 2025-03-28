package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import kg.lab2.main.CalculatorException.*;
import java.util.Deque;
import java.util.List;

class PopTest {
    @Test
    void testPopFromStack() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(5.0);

        new PopCommand().execute(context, List.of());

        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopFromEmptyStack() {
        Context context = new Context();
        Deque<Double> stack = context.getStack();

        assertThrows(EmptyStackException.class, () ->
                new PopCommand().execute(context, List.of())
        );
    }
}