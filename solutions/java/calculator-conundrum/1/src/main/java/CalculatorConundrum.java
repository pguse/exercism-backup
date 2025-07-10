class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        int value = 0;
        switch (operation) {
            case "+":
                value = operand1 + operand2;
                break;
            case "*":
                value = operand1 * operand2;
                break;
            case "/":
                try {
                    value = operand1 / operand2;
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
                break;
            case null:
                throw new IllegalArgumentException("Operation cannot be null");
            case "":
                throw new IllegalArgumentException("Operation cannot be empty");
            default:
                String message = String.format("Operation '%s' does not exist", operation);
                throw new IllegalOperationException(message);
        }
        return String.format("%d %s %d = %d", operand1, operation, operand2, value);
    }
}
