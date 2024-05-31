package hw4.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = ConsoleLogger.getInstance();
        logger.log("hello");
        logger.log("world");
    }
}
