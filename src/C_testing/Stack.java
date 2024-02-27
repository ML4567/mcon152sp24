package C_testing;

/*
- isEmpty()
- push()
- pop()
 */

public class Stack<E> {
    private int size = 0;
    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[10];

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E item) {
        elements[size++] = item;
    }

    public E pop() {
        return elements[--size];
    }
}
