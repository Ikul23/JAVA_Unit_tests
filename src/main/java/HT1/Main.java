package HT1;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Testing calculateDiscount method
        try {
            double purchaseAmount = 100;
            double discountPercentage = 10;
            double discountedAmount = calculator.calculateDiscount(purchaseAmount, discountPercentage);
            System.out.println("Discounted amount for $" + purchaseAmount + " with " + discountPercentage + "% discount: $" + discountedAmount);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Running tests
        CalculatorTest calculatorTest = new CalculatorTest();
        calculatorTest.testCalculateDiscount();
        calculatorTest.testCalculateDiscountWithZeroDiscount();
        calculatorTest.testCalculateDiscountWithHundredPercentDiscount();
    }
}

