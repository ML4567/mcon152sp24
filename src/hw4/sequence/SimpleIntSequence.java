package hw4.sequence;

public class SimpleIntSequence implements IntSequence {
    private int current;

    public SimpleIntSequence(int start) { current = start; }

    @Override public int next() { return current++; }
}
