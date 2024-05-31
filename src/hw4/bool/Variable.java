package hw4.bool;

public class Variable implements Formula {
    private final String name;
    private final boolean value;

    public Variable(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean eval() {
        return value;
    }

    @Override
    public String toInfixString() {
        return name;
    }
}
