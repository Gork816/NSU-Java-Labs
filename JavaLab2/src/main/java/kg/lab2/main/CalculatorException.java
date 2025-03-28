package kg.lab2.main;

public class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }

    public static class FactoryException extends CalculatorException {
        public FactoryException(String message) {
            super(message);
        }
    }

    public static class CommandException extends FactoryException {
        public CommandException(String message) {
            super(message);
        }
    }

    public static class ConfigException extends FactoryException {
        public ConfigException(String message) {
            super(message);
        }
    }

    public static class StackException extends CalculatorException {
        public StackException(String message) {
            super(message);
        }
    }

    public static class StackUnderflowException extends StackException {
        public StackUnderflowException(String operation) {
            super("Not enough elements in stack for command: " + operation);
        }
    }

    public static class EmptyStackException extends StackException {
        public EmptyStackException() {
            super("Stack is empty");
        }
    }

    public static class ArithmeticException extends CalculatorException {
        public ArithmeticException(String message) {
            super(message);
        }
    }

    public static class DivisionByZeroException extends ArithmeticException {
        public DivisionByZeroException() {
            super("Division by zero");
        }
    }

    public static class NegativeSqrtException extends ArithmeticException {
        public NegativeSqrtException(double value) {
            super("Trying to have a square root from negative number (" + value + ")");
        }
    }

    public static class ArgumentException extends CalculatorException {
        public ArgumentException(String message) {
            super(message);
        }
    }

    public static class MissingArgumentException extends ArgumentException {
        public MissingArgumentException(String command) {
            super("Not enough arguments for command: " + command);
        }
    }

    public static class WrongArgumentException extends ArgumentException {
        public WrongArgumentException(String command) {
            super("Wrong arguments for command: " + command);
        }
    }
}
