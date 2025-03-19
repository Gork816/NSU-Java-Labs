package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class DefineTest {
    @Test
    void testDefineVariable() throws Exception {
        Map<String, Double> variables = new HashMap<>();
        List<String> args = List.of("x", "10.5");

        new DefineCommand().execute(new ArrayDeque<>(), variables, args);

        assertEquals(10.5, variables.get("x"));
    }

    @Test
    void testDefineWithoutEnoughArgs() {
        Map<String, Double> variables = new HashMap<>();
        List<String> args = List.of("x");

        assertThrows(IllegalArgumentException.class, () ->
                new DefineCommand().execute(new ArrayDeque<>(), variables, args)
        );
    }

    @Test
    void testDefineInvalidValue() {
        Map<String, Double> variables = new HashMap<>();
        List<String> args = List.of("x", "invalid");

        assertThrows(NumberFormatException.class, () ->
                new DefineCommand().execute(new ArrayDeque<>(), variables, args)
        );
    }
}