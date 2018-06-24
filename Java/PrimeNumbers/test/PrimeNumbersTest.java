import primenumbers.PrimeNumbers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

public class PrimeNumbersTest {

    private static int input;
    private static boolean expectedBoolean;
    private static String expected;

    @DataProvider(name = "isPrime")
    public static Object[][] isPrime() {
        return new Object[][] {
                {7, true}, {69, false}, {73, true}, {156, false}
        };
    }

    @DataProvider(name = "primeNumbersGenerator")
    public static Object[][] primeNumbersGenerator() {
        return new Object[][] {
                {10, "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]"},
        };
    }

    @Test(dataProvider = "isPrime", timeOut = 1000)
    public void testIsPrime(int input, boolean expectedBoolean) {
        boolean result = PrimeNumbers.isPrime(input);
        assertEquals(result, expectedBoolean);
    }

    @Test(dataProvider = "primeNumbersGenerator", timeOut = 1000)
    public void testPrimeNumbersGenerator(int input, String expected) {
        List<Integer> result = PrimeNumbers.primeNumbersGenerator(input);
        String resultString = result.toString();
        assertEquals(resultString, expected);
    }

}
