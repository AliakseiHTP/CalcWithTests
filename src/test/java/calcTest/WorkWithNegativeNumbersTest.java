package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//ѕровер€ет работу с отрицательными числами
public class WorkWithNegativeNumbersTest {

    @Test(groups = {"OperationsWithNegativeNumbers"})
    public void testCountAdd(){
        Calc calculation = new Calc();

        String sResult1 = "0,000";
        String sResultTest1 = calculation.count("1.00+-1.00");
        Assert.assertEquals(sResultTest1,sResult1,"Error: bad add");

        String sResult2 = "1,000";
        String sResultTest2 = calculation.count("2.00+-1.00");
        Assert.assertEquals(sResultTest2,sResult2,"Error: bad add");

        String sResult3 = "0,000";
        String sResultTest3 = calculation.count("-1.00+1.00");
        Assert.assertEquals(sResultTest3,sResult3,"Error: bad add");

        String sResult4 = "-3,000";
        String sResultTest4 = calculation.count("-2.00+-1.00");
        Assert.assertEquals(sResultTest4,sResult4,"Error: bad add");
    }
    @Test(groups = {"OperationsWithNegativeNumbers"})
    public void testCountSub(){
        Calc calculation = new Calc();

        String sResult1 = "2,000";
        String sResultTest1 = calculation.count("1.00--1.00");
        Assert.assertEquals(sResultTest1,sResult1,"Error: bad sub");

        String sResult2 = "3,000";
        String sResultTest2 = calculation.count("2.00--1.00");
        Assert.assertEquals(sResultTest2,sResult2,"Error: bad sub");

        String sResult3 = "-2,000";
        String sResultTest3 = calculation.count("-1.00-1.00");
        Assert.assertEquals(sResultTest3,sResult3,"Error: bad sub");

        String sResult4 = "-1,000";
        String sResultTest4 = calculation.count("-2.00--1.00");
        Assert.assertEquals(sResultTest4,sResult4,"Error: bad sub");
    }
    @Test(groups = {"OperationsWithNegativeNumbers"})
    public void testCountDiv(){
        Calc calculation = new Calc();

        String sResult1 = "-1,000";
        String sResultTest1 = calculation.count("3.00/-3.00");
        Assert.assertEquals(sResultTest1,sResult1,"Error: bad div");

        String sResult2 = "-3,000";
        String sResultTest2 = calculation.count("9.00/-3.00");
        Assert.assertEquals(sResultTest2,sResult2,"Error: bad div");

        String sResult3 = "-1,000";
        String sResultTest3 = calculation.count("-1.00/1.00");
        Assert.assertEquals(sResultTest3,sResult3,"Error: bad div");

        String sResult4 = "2,000";
        String sResultTest4 = calculation.count("-2.00/-1.00");
        Assert.assertEquals(sResultTest4,sResult4,"Error: bad div");
    }
    @Test(groups = {"OperationsWithNegativeNumbers"})
    public void testCountMult(){
        Calc calculation = new Calc();

        String sResult1 = "-1,000";
        String sResultTest1 = calculation.count("1.00*-1.00");
        Assert.assertEquals(sResultTest1,sResult1,"Error: bad sub");

        String sResult2 = "-3,000";
        String sResultTest2 = calculation.count("3.00*-1.00");
        Assert.assertEquals(sResultTest2,sResult2,"Error: bad sub");

        String sResult3 = "-1,000";
        String sResultTest3 = calculation.count("-1.00*1.00");
        Assert.assertEquals(sResultTest3,sResult3,"Error: bad div");

        String sResult4 = "2,000";
        String sResultTest4 = calculation.count("-2.00*-1.00");
        Assert.assertEquals(sResultTest4,sResult4,"Error: bad div");
    }
}
