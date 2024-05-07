package E_design_patterns;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class StrategyDemo {
    public static void main(String[] args) {
        // set orders its elements using the provided Comparator
        SortedSet<String> set = new TreeSet<>(Comparator.comparingInt(String::length).thenComparing(String::compareTo));
    }
}
