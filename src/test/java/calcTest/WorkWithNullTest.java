package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//Проверяет корректность работы метода с числом 0
public class WorkWithNullTest {
    @Test(groups = {"WorkWithNull"})
    public void testCountAdd(){
        Calc calculation = new Calc();

        String sResult1 = "1,000";
        String sResultTest1 = calculation.count("1.00+0.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "0,000";
        String sResultTest2 = calculation.count("0.00+0.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"WorkWithNull"})
    public void testCountSub(){
        Calc calculation = new Calc();

        String sResult1 = "1,000";
        String sResultTest1 = calculation.count("1.00-0.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "0,000";
        String sResultTest2 = calculation.count("0.00-0.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"WorkWithNull"})
    public void testCountDiv(){
        Calc calculation = new Calc();

        String sResult1 = "Can't divide by zero!";
        String sResultTest1 = calculation.count("1.00/0.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "0,000";
        String sResultTest2 = calculation.count("0.00/1.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"WorkWithNull"})
    public void testCountMult(){
        Calc calculation = new Calc();

        String sResult1 = "0,000";
        String sResultTest1 = calculation.count("1.00*0.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "0,000";
        String sResultTest2 = calculation.count("0.00*1.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
}