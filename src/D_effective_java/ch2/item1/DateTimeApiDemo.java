package D_effective_java.ch2.item1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class DateTimeApiDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1987, Month.AUGUST, 23);

        Period interval = Period.of(5, 6, 7);
        interval = Period.ofDays(8);
        interval = Period.ofWeeks(45);
    }
}
