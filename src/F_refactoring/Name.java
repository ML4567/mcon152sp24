package F_refactoring;

import java.util.Objects;
import java.util.Optional;

public class Name {
    private String first, middle, last;

    public Name(String first, String last) {
        this.first = Objects.requireNonNull(first);
        this.last = Objects.requireNonNull(last);

        if (first.isEmpty()) {
            throw new IllegalArgumentException("empty first");
        } else if (last.isEmpty()) {
            throw new IllegalArgumentException("empty last");
        }
    }

    public Name(String first, String middle, String last) {
        this(first, last);

        this.middle = Objects.requireNonNull(middle);

        if (middle.isEmpty()) {
            throw new IllegalArgumentException("empty middle");
        }
    }

    public String getFirst() {
        return first;
    }

    public Optional<String> getMiddle() {
        /*
        // works:
        if (middle == null) {
            return Optional.empty();
        } else {
            return Optional.of(middle);
        }
         */

        // much more concise:
        return Optional.ofNullable(middle);
    }

    public String getLast() {
        return last;
    }

    public String getInitials() {
        // return "" + first.charAt(0) + (getMiddle().isPresent() ? getMiddle().get().charAt(0) : "") + last.charAt(0);
        return first.charAt(0) + getMiddle().map(s -> s.substring(0, 1)).orElse("") + last.charAt(0);
    }
}
