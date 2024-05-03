package E_design_patterns;

import java.util.*;

public class AdapterDemo {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};
        // adapt array to use as list
        System.out.println(Arrays.asList(strings).indexOf("b"));

        // suppose we get an Enumeration from some legacy library.
        Enumeration<String> enumeration = new Vector<>(List.of("a", "b", "c")).elements();

        // We want to work with an Iterator, not an Enumeration.
        Iterator<String> iterator = enumeration.asIterator();
    }
}
