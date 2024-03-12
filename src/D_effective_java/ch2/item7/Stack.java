package D_effective_java.ch2.item7;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Josh Bloch
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public Stack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (isEmpty())
            throw new IllegalStateException();

        E result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) // array is full
            elements = Arrays.copyOf(elements, 2 * elements.length + 1);
    }

    // Little program to exercise our generic Stack
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        for (String arg : args)
            stack.push(arg);

        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}