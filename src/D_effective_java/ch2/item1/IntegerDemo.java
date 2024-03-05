package D_effective_java.ch2.item1;

import java.util.ArrayList;
import java.util.List;

public class IntegerDemo {
    public static void main(String[] args) {
        Integer i1 = 34;
        System.out.println(i1);

        List<Integer> list = new ArrayList<>(List.of(23, 45, 67));
        // list.indexOf(45); // autoboxing
        // list.remove(45); // no auto-boxing, since compiler assumes we're calling remove(int index), so index out of bounds exception
        list.remove(Integer.valueOf(45));
        System.out.println(list);

        System.out.println(Integer.valueOf(127) == Integer.valueOf(127)); // true
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128)); // false (in many versions of Java)

    }
}
