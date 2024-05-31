package hw4;

import java.util.*;

public class AdapterDemo {
    public static <E> Collection<E> toCollection(Iterable<E> iterable) {
        List<E> list = new ArrayList<>();

        for (E e : iterable) {
            list.add(e);
        }

        return new ForwardingUnmodifiableCollection<>(list);
    }
}
