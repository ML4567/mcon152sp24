package C_testing;

import java.util.List;

import static java.util.List.of;
import static java.lang.Math.sqrt;

public class StaticImportDemo {
    public static void main(String[] args) {
        List<Integer> list = of(1, 2, 3);

        System.out.println(sqrt(25));
    }

    // don't overuse static import.
    // it is commonly used in test classes
}
