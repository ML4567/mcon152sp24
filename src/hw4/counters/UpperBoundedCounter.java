package hw4.counters;

public class UpperBoundedCounter extends BaseCounterDecorator {
    private final int upperBound;

    public UpperBoundedCounter(Counter counter, int upperBound) {
        super(counter);
        this.upperBound = upperBound;
    }

    @Override
    public void increment() {
        if (getValue() < upperBound) {
            super.increment();
        }
    }
}
