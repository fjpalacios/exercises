
import fibonacci.Fibonacci;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FibonacciTest {

    private static long input, expected;

    @DataProvider(name = "fibonacci")
    public static Object[][] fibonacci() {
        return new Object[][]{
            {0, 1}, {1, 1}, {4, 5}, {5, 8}
        };
    }

    @Test(dataProvider = "fibonacci", timeOut = 1000)
    public void testFibonacci(long input, long expected) {
        long result = Fibonacci.fibonacci(input);
        assertEquals(expected, result);
    }

}
