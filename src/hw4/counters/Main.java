package hw4.counters;

public class Main {
    public static void main(String[] args) {
        Counter counter = new SimpleCounter();
        Counter upperBoundedCounter = new UpperBoundedCounter(counter, 3);
        Counter lowerBoundedAndUpperBoundedCounter = new LowerBoundedCounter(upperBoundedCounter, -2);

        // or, more concisely:
        // Counter lowerBoundedAndUpperBoundedCounter = new LowerBoundedCounter(new UpperBoundedCounter(new SimpleCounter(), 3), -2);

        for (int i = 0; i < 10; i++) lowerBoundedAndUpperBoundedCounter.increment();
        System.out.println(lowerBoundedAndUpperBoundedCounter.getValue()); // 3

        for (int i = 0; i < 10; i++) lowerBoundedAndUpperBoundedCounter.decrement();
        System.out.println(lowerBoundedAndUpperBoundedCounter.getValue()); // -2
    }
}
