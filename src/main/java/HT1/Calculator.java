package HT1;

public class Calculator {

    public static double calculation(double firstOperand, double secondOperand, char operator) {
        double result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException(STR."Unexpected value operator: \{operator}");
        }
        return result;
    }

    public Calculator() {
    }
}