package F_refactoring;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person(new Name("John", "Doe"), new PhoneNumber("123-456-7890"));
        // System.out.println(person.getName().getFirst());
        System.out.println(person.getFirstName());
    }
}
