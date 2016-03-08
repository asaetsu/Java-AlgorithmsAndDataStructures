import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class CalculatorTest {

    @DataPoints
    public static Fixture[] PARAMs = { new Fixture("1 2 +", 3),
            new Fixture("5 7 + 2 *", 24), new Fixture("5 7 2 + *", 45) };

    static class Fixture {
        String formula;
        int expected;

        Fixture(String exp, int expected) {
            this.formula = exp;
            this.expected = expected;
        }
    }

    @Theory
    public void testCompute(Fixture p) throws IOException {
        Calculator calculator = new Calculator();
        assertThat((int) calculator.compute(p.formula), is(p.expected));
    }
}
