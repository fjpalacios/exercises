import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PythagoreanTest {

    private static float legOne, legTwo, hypotenuse;
    private static double expected;

    @DataProvider(name = "pythagorean")
    public static Object[][] factorial() {
        return new Object[][]{
                {5, 12, 0, 13},
                {9, 0, 15, 12},
                {3, 4, 0, 5},
                {12, 16, 0, 20}
        };
    }

    @Test(dataProvider = "pythagorean", timeOut = 1000)
    public void testPythagorean(float legOne, float legTwo, float hypotenuse, double expected) {
        double result = Pythagorean.pythagorean(legOne, legTwo, hypotenuse);
        assertEquals(result, expected);
    }

}
