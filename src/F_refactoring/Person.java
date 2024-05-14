package F_refactoring;

import java.util.Objects;

public class Person {
    private Name name;
    private PhoneNumber phoneNumber; // ddd-ddd-dddd

    public Person(Name name, PhoneNumber phoneNumber) {
        this.name = Objects.requireNonNull(name, "null name");
        this.phoneNumber = Objects.requireNonNull(phoneNumber, "null phone number");
    }

    // feature envy
    // public String getInitials() {
    //     return "" + name.getFirst().charAt(0) + (name.getMiddle().isPresent() ? name.getMiddle().get().charAt(0) : "") + name.getLast().charAt(0);
    // }


    public Name getName() {
        return name;
    }

    public String getFirstName() {
        return name.getFirst();
    }
}
