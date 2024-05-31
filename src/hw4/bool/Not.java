package hw4.bool;

public class Not implements Formula {
    private final Formula operand;

    public Not(Formula operand) {
        this.operand = operand;
    }

    @Override
    public boolean eval() {
        return ! operand.eval();
    }

    @Override
    public String toInfixString() {
        return "~(" + operand.toInfixString() + ")";
    }
}
