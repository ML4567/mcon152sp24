package C_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void sumOfTwoAndTwo_isFour() {
        int sum = calculator.sum(2, 2);
        assertEquals(4, sum);
    }

    @Test
    void sumOfTwoAndThree_isFive() {
        assertEquals(5, calculator.sum(2, 3));
    }

    @Test
    void quotientOfSevenAndTwo_isThree() {
        assertEquals(3, calculator.quotient(7, 2));
    }

    @Test
    void quotientOfSevenAndZero_throwsIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.quotient(7, 0)
        );
    }
}