package B_streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

/*
A stream has three sections:
- source, such as a collection (must have exactly one)
- intermediate operations (as many as you want, 0 to infinity)
- terminal operation (must have exactly one)

We use streams to construct a "pipeline" through which elements flow from the source
through the intermediate operations to the terminal operation.

A stream does not modify the contents of the source.

The intermediate operations (like filter, map, etc.) each returns a new Stream.

Intermediate operations: filter

Terminal operations: count, max

Optional:
 */

public class StreamStringExamples {
    public static void main(String[] args) {
        List<String> strings = List.of("chocolate", "coffee", "tea", "", "biscuit", "muffin", "doughnut", "tea", "cookie");

        // count strings starting with 'c'
        long numStartingWithC = strings.stream() // Stream<String>
                .filter(s -> s.startsWith("c"))  // Stream<String>
                .count(); // long
        System.out.println("numStartingWithC = " + numStartingWithC);

        // find any longest string; print if present
        Optional<String> longestString = strings.stream() // Stream<String>
                .max(Comparator.comparing(String::length)); // Optional<String>
        longestString.ifPresent(System.out::println); // will print the max if there is one, otherwise does nothing

        // print any longest string, if present
        strings.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        // find any longest string starting with 'c'
        Optional<String> longestStringStartingWithC = strings.stream()
                .filter(s -> s.startsWith("c"))
                .max(Comparator.comparing(String::length));
        System.out.println(longestStringStartingWithC.orElse("no longest string starting with 'c' available"));

        // find length of the longest string
        OptionalInt lengthOfLongestString = strings.stream()
                .mapToInt(String::length)
                .max();
        System.out.println("lengthOfLongestString = " + lengthOfLongestString.orElseThrow());

        // get sorted list of distinct strings with length <= 6; then print the list
        List<String> shortDistinctSortedStrings = strings.stream()
                .filter(s -> s.length() <= 6)
                .distinct()
                .sorted()
                .toList();
        shortDistinctSortedStrings.forEach(System.out::println);

        // get average length of strings that start with 'c'
        OptionalDouble averageLengthOfStringsStartingWithC = strings.stream()
                .filter(s -> s.startsWith("c"))
                .mapToInt(String::length)
                .average();
        averageLengthOfStringsStartingWithC.ifPresent(System.out::println);

        // count the number of characters used (including duplicates)
        long numCharactersIncludingDuplicates = strings.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("numCharactersIncludingDuplicates = " + numCharactersIncludingDuplicates);

        // print each distinct string
        strings.stream()
                .distinct()
                .forEach(System.out::println);

        // print number of distinct strings
        System.out.println("number of distinct strings: " + strings.stream().distinct().count());

        // print each string starting with 'c' in uppercase
        strings.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // print strings sorted by length, then alphabetically
        strings.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        // print a string of length 6. if there are multiple ones, print any; if there
        // are none, print nothing
        strings.stream()
                .filter(s -> s.length() == 6)
                .findAny()
                .ifPresent(System.out::println);

        // get sorted list of distinct first characters of the strings
        List<Character> firstCharacters = strings.stream()
                .filter(s -> !s.isEmpty())
                .distinct()
                .map(s -> s.charAt(0))
                .sorted()
                .toList();
        firstCharacters.forEach(System.out::println);

        // group the strings into lists by their lengths
        Map<Integer, List<String>> map1 = strings.stream().collect(Collectors.groupingBy(String::length));
        map1.forEach((len, wordList) -> System.out.println(len + ": " + wordList));

        // OPTIONAL:
        // group the strings into sets by their lengths
        Map<Integer, Set<String>> map2 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        map2.forEach((len, wordSet) -> System.out.println(len + ": " + wordSet));

        // OPTIONAL:
        // create a map from string lengths to the number of strings of those lengths (for length 6 there are 3 strings, etc.)
        Map<Integer, Long> map3 = strings.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map3.forEach((len, count) -> System.out.println(len + ": " + count));
    }
}