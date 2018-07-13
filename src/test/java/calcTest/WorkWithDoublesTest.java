package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//Проверяет работу с дробными числами
public class WorkWithDoublesTest {
    @Test(groups = {"WorkWithDoubles"})
    public void testWorkWithDoubles(){
        Calc calculation = new Calc();

        String sResult1 = "0,643";
        String sResultTest1 = calculation.count("5.25/8.17");
        Assert.assertEquals(sResultTest1,sResult1);
    }
    @Test(groups = {"WorkWithDoubles"})
    public void testWorkWithDoublesError1() {
        Calc calculation = new Calc();

        String sResult1 = "Invalid input format: The first number must be a decimal number.";
        String sResultTest1 = calculation.count("5/8.00");
        Assert.assertEquals(sResultTest1, sResult1);
    }
    @Test(groups = {"WorkWithDoubles"})
    public void testWorkWithDoublesError2(){
        Calc calculation = new Calc();

        String sResult2 = "Invalid input format: The second number must be a decimal number.";
        String sResultTest2 = calculation.count("5.00/8");
        Assert.assertEquals(sResultTest2,sResult2);
    }
}