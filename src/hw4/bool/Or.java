package hw4.bool;

public class Or implements Formula {
    private final Formula leftOperand, rightOperand;

    public Or(Formula leftOperand, Formula rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public boolean eval() {
        return rightOperand.eval() || leftOperand.eval();
    }

    @Override
    public String toInfixString() {
        return "(" + rightOperand.toInfixString() + " \\/ " + leftOperand.toInfixString() + ")";
    }
}