package hw4.sequence;

import java.util.Random;

public class RandomIntSequence implements IntSequence {
    private final Random randomGenerator;

    public RandomIntSequence(Random randomGenerator) { this.randomGenerator = randomGenerator; }

    @Override public int next() { return randomGenerator.nextInt(); }
}