package E_design_patterns;

class Timer {
    private final long millis;

    public Timer(Runnable command) {
        long start = System.currentTimeMillis();
        command.run();
        long end = System.currentTimeMillis();
        millis = end - start;
    }

    public long getMillis() {
        return millis;
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("running r");

        System.out.println("before running r");
        r.run();
        System.out.println("after running r");

        long start = System.currentTimeMillis();
        // run the code that we want to time
        long end = System.currentTimeMillis();
        long elapsedMillis = end - start;

        Runnable action = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                System.out.print("");
            }
        };
        System.out.println(new Timer(action).getMillis());
    }
}
