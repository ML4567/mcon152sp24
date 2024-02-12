package A_lambdas;

public class Employee {
    private Name name;
    private String id;
    private int salary;

    public Employee(Name name, String id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Name getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %-10s $%,-10d",
                name.getFirst(),
                name.getLast(),
                id,
                salary);
    }
}
