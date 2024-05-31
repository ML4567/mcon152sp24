package hw4.logger;

public class ConsoleLogger implements Logger {
    private static final ConsoleLogger INSTANCE = new ConsoleLogger();

    private ConsoleLogger() {
    }

    public static ConsoleLogger getInstance() {
        return INSTANCE;
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
