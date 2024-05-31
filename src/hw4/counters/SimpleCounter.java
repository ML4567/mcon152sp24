package hw4.counters;

public class SimpleCounter implements Counter {
    private int value = 0;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void increment() {
        value++;
    }

    @Override
    public void decrement() {
        value--;
    }
}
