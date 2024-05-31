package hw4.sequence;

import java.util.ArrayList;
import java.util.List;

public interface IntSequence { // a sequence of integers
    int next(); // returns the next item in the sequence

    default List<Integer> nextN(int n) {
        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(next());
        }

        return list;
    }
}