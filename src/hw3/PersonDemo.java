package hw3;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person.Builder("John", "Doe")
                .middleName("Marco")
                .emailAddress("john@example.com")
                .phoneNumber("123-456-7890")
                .build();
    }
}