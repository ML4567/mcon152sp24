package hw2;

/*
A FIFO queue class named Queue<E> with the following methods:
public boolean isEmpty()
public void enqueue(E element) // adds element to end of queue; queue should automatically grow to accommodate any number of elements
public E peek() // returns element at head of queue; throws IllegalStateException if empty
public E dequeue() // returns and removes element at head of queue; throws IllegalStateException if empty

 */

public class Queue<E> {
    private E[] elements;
    private int indexOfFirst, indexOfLast;
    private static final int INITIAL_CAPACITY = 0;

    @SuppressWarnings("unchecked")
    public Queue() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        indexOfFirst = indexOfLast = -1;
    }

    public boolean isEmpty() {
        return indexOfFirst == -1 && indexOfLast == -1;
    }

    public void enqueue(E element) {
        if (isFull()) {
            ensureCapacity(2 * capacity() + 1);
        }

        indexOfLast = (indexOfLast + 1) % capacity();
        elements[indexOfLast] = element;

        if (indexOfFirst == -1) { // list was previously empty
            indexOfFirst = indexOfLast;
        }
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity(int newCapacity) {
        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < capacity(); i++) {
            newElements[i] = elements[(indexOfFirst + 1) % capacity()];
        }

        indexOfFirst = 0;
        indexOfLast = capacity() - 1;
        elements = newElements;
    }

    private boolean isFull() {
        return elements.length == 0 || (indexOfLast + 1) % capacity() == indexOfFirst;
    }

    private int capacity() {
        return elements.length;
    }


}
