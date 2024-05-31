package hw4.varargs;

public class Main {
    public static double average(double first, double... rest) {
        double sum = first;

        for (double value : rest) {
            sum += value;
        }

        return sum / (rest.length + 1);
    }

    public static boolean and(boolean first, boolean... rest) {
        if (!first) {
            return false;
        }

        for (boolean value : rest) {
            if (!value) {
                return false;
            }
        }

        return true;
    }

    public static boolean or(boolean first, boolean... rest) {
        if (first) {
            return true;
        }

        for (boolean value : rest) {
            if (value) {
                return true;
            }
        }

        return false;
    }
}
