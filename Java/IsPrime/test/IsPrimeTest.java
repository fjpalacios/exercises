import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;

public class IsPrimeTest {

    private static int input;
    private static boolean expectedBoolean;
    private static String expected;

    @DataProvider(name = "isPrime")
    public static Object[][] isPrime() {
        return new Object[][] {
                {7, true}, {69, false}, {73, true}, {156, false}
        };
    }

    @DataProvider(name = "primeFactors")
    public static Object[][] primeFactors() {
        return new Object[][] {
                {14, "[2, 7]"},
                {69, "[3, 23]"},
                {87, "[3, 29]"},
                {156, "[2, 2, 3, 13]"}
        };
    }

    @Test(dataProvider = "isPrime", timeOut = 1000)
    public void testIsPrime(int input, boolean expectedBoolean) {
        boolean result = IsPrime.isPrime(input);
        assertEquals(result, expectedBoolean);
    }

    @Test(dataProvider = "primeFactors", timeOut = 1000)
    public void testPrimeFactors(int input, String expected) {
        List<Integer> result = IsPrime.primeFactors(input);
        String resultString = result.toString();
        assertEquals(resultString, expected);
    }

}
