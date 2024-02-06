package A_lambdas;

@FunctionalInterface
public interface IntBinaryOperator {
    int apply(int a, int b);

    String toString();

    static void staticPrint(String s) {
        System.out.println(s);
    }

    default void instancePrint(String s) {
        System.out.println(s);
    }
}

//class Addition implements IntBinaryOperator {
//    @Override
//    public int apply(int a, int b) {
//        return a + b;
//    }
//}

//class Main {
//    public static void main(String[] args) {
//        IntBinaryOperator op = new Addition();
//        IntBinaryOperator.staticPrint("hello");
//        op.instancePrint("hello");
//        int result = op.apply(4, 7);
//        System.out.println(result); // 11
//    }
//}
