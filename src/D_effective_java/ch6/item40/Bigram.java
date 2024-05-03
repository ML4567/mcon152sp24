package D_effective_java.ch6.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram {
    private final char first;
    private final char second;
    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /*
    In class Object, there's the following method:

    public boolean equals(Object obj) {
        return this == obj;
    }
     */

    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    /*
    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));

        System.out.println(s.size());
    }
     */

    public static void main(String[] args) {
        Set<Bigram> set = new HashSet<>();
        set.add(new Bigram('a', 'b'));
        System.out.println(set.size());
        set.add(new Bigram('a', 'b'));
        System.out.println(set.size()); // 2
    }
}