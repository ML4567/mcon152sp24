package F_refactoring;

import java.util.Objects;

public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = Objects.requireNonNull(number, "null phone number");

        if (!number.matches("\\d{3}-\\d{3}-\\d{4}")) {
            throw new IllegalArgumentException("invalid phone number");
        }
    }
}
