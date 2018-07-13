package calcTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import entity.Calc;

//Проверяет ограничение по формату чисел в выражении
public class NumberFormatForInputTest {
    @Test(groups = {"NumberFormatForInput"})
    public void testCount(){
        Calc calculation = new Calc();

        String sResult1 = "8,000";
        String sResultTest1 = calculation.count("9.00+-1.00");
        Assert.assertEquals(sResultTest1, sResult1);
    }
    @Test(groups = {"NumberFormatForInput"})
    public void testCountError1(){
        Calc calculation = new Calc();

        String sResult1 = "Invalid input format: The first number must be specified to two decimal places.";
        String sResultTest1 = calculation.count("9.0+-1.00");
        Assert.assertEquals(sResultTest1, sResult1);
    }
    @Test(groups = {"NumberFormatForInput"})
    public void testCountError2(){
        Calc calculation = new Calc();

        String sResult1 = "Invalid input format: The second number must be specified to two decimal places.";
        String sResultTest1 = calculation.count("9.00+-1.0");
        Assert.assertEquals(sResultTest1, sResult1);
    }
    @Test(groups = {"NumberFormatForInput"})
    public void testCountError3(){
        Calc calculation = new Calc();

        String sResult1 = "Invalid input format:"+ "\n" +
                "The first number must be specified to two decimal places.";
        String sResultTest1 = calculation.count("9.0+-1.0");
        Assert.assertEquals(sResultTest1, sResult1);
    }
}