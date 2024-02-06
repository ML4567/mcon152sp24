package A_lambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdasWithCollectionsDemo {
    public static void main(String[] args) {
        forEachDemo();
        forEachWithMapDemo();
    }

    public static void forEachDemo() {
        List<String> list = List.of("a", "b", "c");
        list.forEach(System.out::println);
    }

    public static void forEachWithMapDemo() {
        Map<Integer, String> map = Map.of(4, "four", 6, "six", 2, "two");
        map.forEach((key, val) -> System.out.println(key + " ---- " + val));
    }
}
