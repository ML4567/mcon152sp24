package E_design_patterns;

interface ArithmeticExpression {
    double eval();
    String toInfixString();
}

// leaf
class NumberExpression implements ArithmeticExpression {
    private final double number;

    NumberExpression(double number) {
        this.number = number;
    }

    @Override
    public double eval() {
        return number;
    }

    @Override
    public String toInfixString() {
        return String.valueOf(number);
    }
}

abstract class BinaryExpression implements ArithmeticExpression {
    private final String operatorSymbol;
    protected final ArithmeticExpression lhs, rhs;

    BinaryExpression(String operatorSymbol, ArithmeticExpression lhs, ArithmeticExpression rhs) {
        this.operatorSymbol = operatorSymbol;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toInfixString() {
        return "(" + lhs.toInfixString() + " " + operatorSymbol + " " + rhs.toInfixString() + ")";
    }
}

class AdditionExpression extends BinaryExpression {
    public AdditionExpression(ArithmeticExpression lhs, ArithmeticExpression rhs) {
        super("+", lhs, rhs);
    }

    @Override
    public double eval() {
        return lhs.eval() + rhs.eval();
    }
}

class MultiplicationExpression extends BinaryExpression {
    MultiplicationExpression(ArithmeticExpression lhs, ArithmeticExpression rhs) {
        super("*", lhs, rhs);
    }

    @Override
    public double eval() {
        return lhs.eval() * rhs.eval();
    }
}

/*
        +
      +   5
    2  *
      3  4

 */

public class CompositeDemo {
    public static void main(String[] args) {
        ArithmeticExpression expression = new AdditionExpression(
                new AdditionExpression(
                        new NumberExpression(2),
                        new MultiplicationExpression(new NumberExpression(3), new NumberExpression(4))),
                new NumberExpression(5)
        );

        System.out.println(expression.eval());
        System.out.println(expression.toInfixString());
    }
}
