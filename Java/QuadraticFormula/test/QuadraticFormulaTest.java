
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.*;
import quadraticformula.QuadraticFormula;

public class QuadraticFormulaTest {

    @DataProvider(name = "formula")
    public static Object[][] formula() {
        return new Object[][]{
            {1, 5, 6, "[-2.0, -3.0]"},
            {1, -5, 0, "[0.0, 5.0]"},
            {1, 0, -25, "[5.0, -5.0]"},
            {1, -2, 1, "[1.0, 1.0]"},
            {2, 0, 8, "[2.0, -2.0]"}, // no real solution
            {1, 7, 6, "[-1.0, -6.0]"},
            {-10, 15, 0, "[0.0, 1.5]"} // fraction (3/2)
        };
    }

    @Test(dataProvider = "formula", timeOut = 1000)
    public void testFormula(float termA, float termB, float termC, String expected) {
        QuadraticFormula equation = new QuadraticFormula(termA, termB, termC);
        List<Double> result = equation.formula();
        String resultString = result.toString();
        assertEquals(resultString, expected);
    }

}
