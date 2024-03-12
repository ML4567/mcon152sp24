package D_effective_java.ch2.item6;

/**
 * From the book.
 */
public class Sum {
    private static long sumOfAllPositiveIntsBad() {
        Long sum = 0L;

        for (long i = 1; i <= Integer.MAX_VALUE; i++)
            sum += i; // on each iteration, a new object gets created here

        return sum;
    }

    private static long sumOfAllPositiveIntsGood() {
        long sum = 0;

        for (long i = 1; i <= Integer.MAX_VALUE; i++)
            sum += i;

        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long sum = sumOfAllPositiveIntsBad();
        long end = System.currentTimeMillis();
        long elapsedMillis = end - start;
        System.out.println("Using Long: " + elapsedMillis + " ms.");

        start = System.currentTimeMillis();
        sum = sumOfAllPositiveIntsGood();
        end = System.currentTimeMillis();
        elapsedMillis = end - start;
        System.out.println("Using long: " + elapsedMillis + " ms.");
    }
}
