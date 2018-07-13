package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//Проверяет работу с целыми числами и арифм. операциями
public class SimpleOperationsTest {

    @Test(groups = {"SimpleOperations"})
    public void testCountAdd(){
        Calc calculation = new Calc();

        String sResult1 = "2,000";
        String sResultTest1 = calculation.count("1.00+1.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "3,000";
        String sResultTest2 = calculation.count("2.00+1.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"SimpleOperations"})
    public void testCountSub(){
        Calc calculation = new Calc();

        String sResult1 = "0,000";
        String sResultTest1 = calculation.count("1.00-1.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "1,000";
        String sResultTest2 = calculation.count("2.00-1.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"SimpleOperations"})
    public void testCountDiv(){
        Calc calculation = new Calc();

        String sResult1 = "1,000";
        String sResultTest1 = calculation.count("3.00/3.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "3,000";
        String sResultTest2 = calculation.count("9.00/3.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"SimpleOperations"})
    public void testCountMult(){
        Calc calculation = new Calc();

        String sResult1 = "1,000";
        String sResultTest1 = calculation.count("1.00*1.00");
        Assert.assertEquals(sResultTest1,sResult1);

        String sResult2 = "3,000";
        String sResultTest2 = calculation.count("3.00*1.00");
        Assert.assertEquals(sResultTest2,sResult2);
    }
    @Test(groups = {"SimpleOperations"})
    public void testCountError(){
        Calc calculation = new Calc();

        String sResult1 = "Error: Needed operation is not found. Please check the expression!";
        String sResultTest1 = calculation.count("1.001.00");
        Assert.assertEquals(sResultTest1,sResult1);
    }
}