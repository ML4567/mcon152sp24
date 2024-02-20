package C_testing;

public class Calculator {
    /**
     * Returns the sum of two integers.
     * @param a the first integer
     * @param b the second integer
     * @return the sum
     */
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Returns the integer result of
     * the first number divided by
     * the second number, i.e., a / b.
     * @param a the first integer
     * @param b the second integer,
     *          cannot be 0
     * @return a / b, without remainder
     * @throws IllegalArgumentException if b == 0
     */
    public int quotient(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b is 0");
        }

        return a / b;
    }
}
