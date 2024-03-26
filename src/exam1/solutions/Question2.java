package exam1.solutions;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("John", "Doe", LocalDate.of(1999, Month.AUGUST, 16)),
                new Person("Jane", "Smith", LocalDate.of(1997, Month.JULY, 19))
        ));

        people.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

        people.removeIf(p -> p.getLastName().equals("Doe"));
    }
}
