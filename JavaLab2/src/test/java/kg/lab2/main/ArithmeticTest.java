package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ArithmeticTest {
    @Test
    void testAddition() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(3.0);
        stack.push(2.0);

        new AddCommand().execute(context, List.of());

        assertEquals(5.0, stack.peek());
    }

    @Test
    void testSubtraction() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(10.0);
        stack.push(4.0);

        new SubCommand().execute(context, List.of());

        assertEquals(6.0, stack.peek());
    }

    @Test
    void testMultiplication() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(6.0);
        stack.push(2.0);

        new MulCommand().execute(context, List.of());

        assertEquals(12.0, stack.peek());
    }

    @Test
    void testDivision() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(8.0);
        stack.push(2.0);

        new DivCommand().execute(context, List.of());

        assertEquals(4.0, stack.peek());
    }

    @Test
    void testDivisionByZero() {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(5.0);
        stack.push(0.0);

        assertThrows(ArithmeticException.class, () ->
                new DivCommand().execute(context, List.of())
        );
    }

    @Test
    void testSqrt() throws Exception {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(9.0);

        new SqrtCommand().execute(context, List.of());

        assertEquals(3.0, stack.peek());
    }

    @Test
    void testSqrtNegativeNumber() {
        Context context = new Context();
        Deque<Double> stack = context.getStack();
        stack.push(-9.0);

        assertThrows(ArithmeticException.class, () ->
                new SqrtCommand().execute(context, List.of())
        );
    }
}