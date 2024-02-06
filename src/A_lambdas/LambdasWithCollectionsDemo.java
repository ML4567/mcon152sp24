package A_lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdasWithCollectionsDemo {
    public static void main(String[] args) {
        forEachDemo();
    }

    public static void forEachDemo() {
        List<String> list = new ArrayList<>(List.of("a", "b", "c"));
        list.forEach(System.out::println);
    }
}
