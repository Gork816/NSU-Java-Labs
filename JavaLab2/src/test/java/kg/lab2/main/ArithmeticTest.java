package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class ArithmeticTest {
    @Test
    void testAddition() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(3.0);
        stack.push(2.0);

        new AddCommand().execute(stack, new HashMap<>(), List.of());

        assertEquals(5.0, stack.peek());
    }

    @Test
    void testSubtraction() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(10.0);
        stack.push(4.0);

        new SubCommand().execute(stack, new HashMap<>(), List.of());

        assertEquals(6.0, stack.peek());
    }

    @Test
    void testMultiplication() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(6.0);
        stack.push(2.0);

        new MulCommand().execute(stack, new HashMap<>(), List.of());

        assertEquals(12.0, stack.peek());
    }

    @Test
    void testDivision() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(8.0);
        stack.push(2.0);

        new DivCommand().execute(stack, new HashMap<>(), List.of());

        assertEquals(4.0, stack.peek());
    }

    @Test
    void testDivisionByZero() {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(5.0);
        stack.push(0.0);

        assertThrows(ArithmeticException.class, () ->
                new DivCommand().execute(stack, new HashMap<>(), List.of())
        );
    }

    @Test
    void testSqrt() throws Exception {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(9.0);

        new SqrtCommand().execute(stack, new HashMap<>(), List.of());

        assertEquals(3.0, stack.peek());
    }

    @Test
    void testSqrtNegativeNumber() {
        Deque<Double> stack = new ArrayDeque<>();
        stack.push(-9.0);

        assertThrows(ArithmeticException.class, () ->
                new SqrtCommand().execute(stack, new HashMap<>(), List.of())
        );
    }
}