package E_design_patterns;

import java.time.Month;

public class FlyweightDemo {
    public static void main(String[] args) {
        // every enum is an example of the flyweight pattern
        Month m1 = Month.APRIL;
        Month m2 = Month.APRIL;
        System.out.println(m1 == m2); // true

        Integer smallInteger1 = Integer.valueOf(33);
        Integer smallInteger2 = Integer.valueOf(33);
        System.out.println(smallInteger1 == smallInteger2); // true
    }
}
