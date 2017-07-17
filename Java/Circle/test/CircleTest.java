
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CircleTest {

    private static int input;
    private static double expected;

    @DataProvider(name = "area")
    public static Object[][] area() {
        return new Object[][]{
            {4, 50.2654816}, {10, 314.15926}
        };
    }

    @DataProvider(name = "perimeter")
    public static Object[][] perimeter() {
        return new Object[][]{
            {4, 25.1327408}, {10, 62.831852}
        };
    }

    @Test(dataProvider = "area", timeOut = 1000)
    public void testArea(int input, double expected) {
        double result = Circle.area(input);
        assertEquals(result, expected);
    }

    @Test(dataProvider = "perimeter", timeOut = 1000)
    public void testPerimeter(int input, double expected) {
        double result = Circle.perimeter(input);
        assertEquals(result, expected);
    }

}
