package exam1.solutions;

import java.time.*;
import java.util.*;

class Person {
    private String firstName, lastName;
    private LocalDate dob;

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public LocalDate getDob() { return dob; }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + dob;
    }
}