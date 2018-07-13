package run;

import entity.Calc;

public class MainApp {
    public static void main(String[] args) {
    	 Calc calculation = new Calc();
         //вводим арифметическое выражение
         String resultExpression = calculation.count("-8.00/0.00");
         //получаем результат арифметического выражения
         System.out.println(resultExpression);
    }
}