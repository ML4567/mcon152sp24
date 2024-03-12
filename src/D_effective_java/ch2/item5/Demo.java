package D_effective_java.ch2.item5;

/*
Item 5: Prefer dependency injection to hardwiring resources.
 */

import java.util.*;

class Lexicon { // immutable class
    private Set<String> words = new HashSet<>();

    public Lexicon(String filename) {
        // TODO
    }

    public boolean contains(String word) {
        return false;
    }

    public boolean containsIgnoreCase(String word) {
        return false;
    }
}

class SpellChecker {
    private Lexicon lexicon;

//    public SpellChecker() { // hardwiring a resource -- usually bad
//        lexicon = new Lexicon("words.txt"); // SpellChecker creates its own resource (the Lexicon)
//    }

    public SpellChecker(Lexicon lexicon) { // an example of dependency injection
        this.lexicon = Objects.requireNonNull(lexicon);
    }

    public boolean isValid(String word) {
        return false;
    }

    public List<String> suggestions(String typo) {
        return Collections.emptyList();
    }
}

public class Demo {

}
