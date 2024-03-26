package exam1.solutions;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question3 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(List.of(
                new Person("John", "Doe", LocalDate.of(1999, Month.AUGUST, 16)),
                new Person("Jane", "Smith", LocalDate.of(1997, Month.JULY, 19))
        ));

        people.stream()
                .mapToInt(Person::getAge)
                .filter(age -> age > 30)
                .average()
                .ifPresent(System.out::println);

        long count = people.stream()
                .map(Person::getFirstName)
                .distinct()
                .count();
        System.out.println(count);

        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);

        Map<Integer, List<Person>> ageMap = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
    }
}
