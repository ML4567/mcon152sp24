import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDemo {
    @BeforeAll // run one at beginning
    static void beforeAllTests() {
        System.out.println("before all tests");
    }

    @BeforeEach // run before each test method
    void beforeEachTest() {
        System.out.println("before each test");
    }

    @Test
    void test1() {
        System.out.println("test 1");
    }

    @Test
    void test2() {
        System.out.println("test 2");
    }
}
