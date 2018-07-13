package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//Проверяет условие вхождения чисел в интервал [-10:10]
public class IntervalOfNumbersTest {
    @Test(groups = {"IntervalOfNumbers"})
    public void testIntervalOfNumbers(){
        Calc calculation = new Calc();

        String sResult1 = "13,420";
        String sResultTest1 = calculation.count("5.25+8.17");
        Assert.assertEquals(sResultTest1,sResult1);
    }
    @Test(groups = {"IntervalOfNumbers"})
    public void testIntervalOfNumbersError1(){
        Calc calculation = new Calc();

        String sResult1 = "The first number is not included in the specified range[-10:+10]. Please check it!";
        String sResultTest1 = calculation.count("15.25+8.17");
        Assert.assertEquals(sResultTest1,sResult1);
    }
    @Test(groups = {"IntervalOfNumbers"})
    public void testIntervalOfNumbersError2(){
        Calc calculation = new Calc();

        String sResult1 = "The second number is not included in the specified range[-10:+10]. Please check it!";
        String sResultTest1 = calculation.count("5.00+11.00");
        Assert.assertEquals(sResultTest1,sResult1);
    }

}