package hw4.counters;

public class LowerBoundedCounter extends BaseCounterDecorator {
    private final int lowerBound;

    public LowerBoundedCounter(Counter counter, int lowerBound) {
        super(counter);
        this.lowerBound = lowerBound;
    }

    @Override
    public void decrement() {
        if (getValue() > lowerBound) {
            super.decrement();
        }
    }
}
