package C_testing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumOfTwoAndTwo_isFour() {
        int sum = calculator.sum(2, 2);
        // assertEquals(4, sum);
        assertThat(sum).isEqualTo(4);
    }

    @Test
    void sumOfTwoAndThree_isFive() {
        // assertEquals(5, calculator.sum(2, 3));
        assertThat(calculator.sum(2, 3)).isEqualTo(5);

        int result = 10;
        // test that result is even:
        // In JUnit:
        // assertTrue(result % 2 == 0);
        // in AssertJ:
        // assertThat(result).isEven();
    }

    @Test
    void quotientOfSevenAndTwo_isThree() {
        // assertEquals(3, calculator.quotient(7, 2));
        assertThat(calculator.quotient(7, 2)).isEqualTo(3);
    }

    @Test
    void quotientOfSevenAndZero_throwsIllegalArgumentException() {
        // assertThrows(
        //         IllegalArgumentException.class,
        //         () -> calculator.quotient(7, 0)
        // );

        assertThatThrownBy(
                () -> calculator.quotient(7, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}