package E_design_patterns;

import java.util.*;

public class StrategyDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("summer", "spring", "fall", "winter");
        list.sort(Comparator.naturalOrder());
        System.out.println("sorted alphabetically: " + list);
        list.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
        System.out.println("sorted by length then by alphabetically: " + list);

        // A Comparator is a strategy for ordering and is passed to the sort method
        // There's only one sort method on the List interface, but its behavior depends
        // on the particular ordering strategy (Comparator) that is passed in.
    }
}
