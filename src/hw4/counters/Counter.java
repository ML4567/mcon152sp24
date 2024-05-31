package hw4.counters;

// an integer counter
public interface Counter {
    // returns the counter's current value
    int getValue();
    // increments the counter's current value by 1
    void increment();
    // decrements the counter's current value by 1
    void decrement();
}