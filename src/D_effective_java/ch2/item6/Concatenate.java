package D_effective_java.ch2.item6;

public class Concatenate {
    // O(n^2)
    public static String repeat(char ch, int n) {
        if (n < 0) throw new IllegalArgumentException();

        String s = "";

        for (int i = 0; i < n; i++) {
            s += ch;
        }

        return s;
    }

    // O(n)
    public static String repeatUsingStringBuilder(char ch, int n) {
        if (n < 0) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new StringBuilder("a").append("b").append("c").toString(); // builder pattern
        System.out.println(s); // abc

        // String is immutable, StringBuilder is mutable

        final int N = 100_000;

        long start = System.currentTimeMillis();
        String result = repeat('a', N);
        long end = System.currentTimeMillis();
        long elapsedMillis = end - start;
        System.out.println("Using String concatenation: " + elapsedMillis + " ms.");

        start = System.currentTimeMillis();
        result = repeatUsingStringBuilder('a', N);
        end = System.currentTimeMillis();
        elapsedMillis = end - start;
        System.out.println("Using a StringBuilder: " + elapsedMillis + " ms.");
    }
}
