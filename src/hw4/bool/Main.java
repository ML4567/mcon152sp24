package hw4.bool;

public class Main {
    public static void main(String[] args) {
        Formula formula = new And(
                new Or(
                        new Variable("P", false),
                        new Variable("Q", true)
                ),
                new Or(
                        new Not(new Variable("P", false)),
                        new Variable("R", true)
                )
        );
        System.out.println(formula.toInfixString());
    }
}
