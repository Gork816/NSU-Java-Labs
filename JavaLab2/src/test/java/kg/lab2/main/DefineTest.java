package kg.lab2.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import kg.lab2.main.CalculatorException.*;

class DefineTest {
    @Test
    void testDefineVariable() throws Exception {
        Context context = new Context();
        Map<String, Double> variables = context.getVars();
        List<String> args = List.of("x", "10.5");

        new DefineCommand().execute(context, args);

        assertEquals(10.5, variables.get("x"));
    }

    @Test
    void testDefineWithoutEnoughArgs() {
        Context context = new Context();
        Map<String, Double> variables = context.getVars();
        List<String> args = List.of("x");

        assertThrows(MissingArgumentException.class, () ->
                new DefineCommand().execute(context, args)
        );
    }

    @Test
    void testDefineInvalidValue() {
        Context context = new Context();
        Map<String, Double> variables = context.getVars();
        List<String> args = List.of("x", "invalid");

        assertThrows(WrongArgumentException.class, () ->
                new DefineCommand().execute(context, args)
        );
    }
}