package D_effective_java.ch6.item34;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Arrays;

enum Operation {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);
}

enum Season {
    WINTER, SPRING, SUMMER, FALL
}


public class Main {
    public static void main(String[] args) {

        Operation op = Operation.DIVIDE;
        System.out.println(op.getClass().getName());

        Season season = Season.SPRING;
        System.out.println(season.ordinal()); // 1
        System.out.println(season.getClass().getName());


        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day);
        }

        for (Month month : Month.values()) {
            System.out.println(month);
        }

        Arrays.stream(Month.values())
                .mapToInt(Month::minLength)
                .average()
                .ifPresent(System.out::println);
    }
}
