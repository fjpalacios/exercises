import factorial.Factorial;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    private static long input, expected;

    @DataProvider(name = "factorial")
    public static Object[][] factorial() {
        return new Object[][]{
                {6, 720}, {7, 5040}, {8, 40320}, {9, 362880}, {10, 3628800}
        };
    }

    @Test(dataProvider = "factorial", timeOut = 1000)
    public void testFactorial(long input, long expected) {
        long result = (long) Factorial.factorial(input);
        assertEquals(result, expected);
    }

}
