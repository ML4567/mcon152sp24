package hw4.counters;

public class BaseCounterDecorator implements Counter {
    private final Counter counter;

    public BaseCounterDecorator(Counter counter) {
        this.counter = counter;
    }

    @Override
    public int getValue() {
        return counter.getValue();
    }

    @Override
    public void increment() {
        counter.increment();
    }

    @Override
    public void decrement() {
        counter.decrement();
    }
}
