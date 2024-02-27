package C_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new Stack<>();
    }

    @Test
    void newStack_isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterPushingOnce_isNotEmpty() {
        stack.push("a");
        assertFalse(stack.isEmpty());
    }

    @Test
    void afterPushingOnceAndPoppingOnce_stackIsEmpty() {
        stack.push("a");
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void afterPushingTwiceAndPoppingOnce_notIsEmpty() {
        stack.push("a");
        stack.push("b");
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    void afterPushingA_shouldPopA() {
        stack.push("a");
        assertEquals("a", stack.pop());
    }

    @Test
    void afterPushingAB_shouldPopBA() {
        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
    }
}
