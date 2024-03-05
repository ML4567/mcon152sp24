package D_effective_java.ch2.item4;

public class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    public static void printMessage() {
        System.out.println("message");
        new UtilityClass(); // throws exception
    }
}

// won't compile, since the
// class Subclass extends UtilityClass {}

class Demo {
    public static void main(String[] args) {

    }
}
