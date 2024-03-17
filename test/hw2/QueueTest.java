package hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void newQueueIsEmpty() {
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());
    }

    // start with new queue, enqueue A then B, should dequeue A then B

    // start with empty queue, enqueue two elements, dequeue two elements, isEmpty should be true

    //
}