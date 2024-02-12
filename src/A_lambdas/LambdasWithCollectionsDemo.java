package A_lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class LambdasWithCollectionsDemo {
    public static void main(String[] args) {
        // forEachDemo();
        // forEachWithMapDemo();
        removeIfDemo();
        replaceAllDemo();
    }

    // demonstrates Iterable's forEach(Consumer action) method
    public static void forEachDemo() {
        List<String> list = List.of("a", "b", "c");
        list.forEach(System.out::println);
    }

    // demonstrates Map's forEach(BiConsumer action) method
    public static void forEachWithMapDemo() {
        Map<Integer, String> map = Map.of(4, "four", 6, "six", 2, "two");
        map.forEach((key, val) -> System.out.println(key + " ---- " + val));
    }

    // demonstrates Collection's removeIf(Predicate filter) method
    public static void removeIfDemo() {
        List<Integer> list = new ArrayList<>(List.of(-3, -2, -1, 0, 1, 2, 3));

        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isEven = x -> x % 2 == 0;
        // Predicate<Integer> isPositiveOrEven = x -> x > 0 || x % 2 == 0;
        Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);

        list.removeIf(isPositiveOrEven);

        list.forEach(System.out::println);
    }

    // demonstrates List's replaceAll(UnaryOperator operator)
    public static void replaceAllDemo() {
        List<String> list = new ArrayList<>(List.of("one", "two", "three"));
        list.replaceAll(s -> s.toUpperCase());
        list.forEach(System.out::println);
    }
}
