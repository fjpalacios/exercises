
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class FibonacciTest {

    @Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{
            {0, 1}, {1, 1}, {4, 5}, {5, 8}
        });
    }

    private long input, expected;

    public FibonacciTest(long input, long expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testFibonacci() {
        long result = Fibonacci.fibonacci(input);
        assertEquals(expected, result);
    }

}
