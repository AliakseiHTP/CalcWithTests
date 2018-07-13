package calcTest;

import org.testng.Assert;
import org.testng.annotations.*;

import entity.Calc;

public class CalcTest {

    private Calc calculation;

    @BeforeTest
    public void setUp(){
        calculation = new Calc();
    }

    @Parameters({"expression","result"})
    @Test
    public void testingCalc(String expression, String result) throws Exception {
        Assert.assertEquals(result, calculation.count(expression));

    }

    @AfterTest
    public void tearDown(){
        calculation = null;
    }


}