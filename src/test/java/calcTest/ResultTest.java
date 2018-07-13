package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//Проверка округление результата
public class ResultTest {
    @Test(groups = {"Result"})
    public void testResult(){
        Calc calculation = new Calc();

        String sResult1 = "2,300";
        String sResultTest1 = calculation.count("1.20+1.10");
        Assert.assertEquals(sResultTest1,sResult1);
    }
    @Test(groups = {"Result"})
    public void testResult1(){
        double result = 2.330233;

        String sResult1 = "2,330";
        String sResultTest1 = String.format("%.3f", result);
        Assert.assertEquals(sResultTest1,sResult1);
    }
}