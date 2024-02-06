package HT1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    public double calculateDiscount(double purchaseAmount, double discountPercentage) {
        if (purchaseAmount < 0 || discountPercentage < 0 || discountPercentage > 100) {
            throw new ArithmeticException("Invalid input: purchaseAmount and discountPercentage must be non-negative, and discountPercentage must be between 0 and 100.");
        }
        return purchaseAmount - (purchaseAmount * discountPercentage / 100);
    }

    @Test
    public void testCalculateDiscount() {
        // Test valid inputs
        Assertions.assertThat(calculateDiscount(100, 10)).isEqualTo(90);
        Assertions.assertThat(calculateDiscount(200, 20)).isEqualTo(160);

        // Test invalid discount percentage
        Assertions.assertThatThrownBy(() -> calculateDiscount(100, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");
        Assertions.assertThatThrownBy(() -> calculateDiscount(100, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");

        // Test invalid purchase amount
        Assertions.assertThatThrownBy(() -> calculateDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Invalid input");
    }

    @Test
    public void testCalculateDiscountWithZeroDiscount() {
        // Test zero discount
        Assertions.assertThat(calculateDiscount(100, 0)).isEqualTo(100);
        Assertions.assertThat(calculateDiscount(200, 0)).isEqualTo(200);
    }

    @Test
    public void testCalculateDiscountWithHundredPercentDiscount() {
        // Test 100% discount
        Assertions.assertThat(calculateDiscount(100, 100)).isEqualTo(0);
        Assertions.assertThat(calculateDiscount(200, 100)).isEqualTo(0);
    }
}
