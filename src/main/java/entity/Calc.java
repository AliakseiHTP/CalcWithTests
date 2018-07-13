package entity;

import java.io.IOException;
import java.util.Objects;

public class Calc {

    private double minValue, maxValue, zero;
    private int accuracy;
    private String sPoint;

    /* В конструктор помещаем перменные необходимые для выполнения условий:
    1. Числа в выражении - только от -10 до 10 (не включая 10 и -10)
    2. Десятичное число, формат записи - два числа после точки (то есть точность - до сотых)
    3. Корректность работы метода с числом 0
    */

    public Calc () {
        minValue = -10.00;
        maxValue = 10.00;
        zero = 0.00;
        accuracy = 2;
        sPoint = ".";
    }

    public String count(String expression){
        double d1; //первое число
        String sOperation; //действие
        double d2; //второе число
        double result;
        String s1;
        String s2;

        //Поиск и инициализация оператора действия (/ * + -)
        try {
            if (expression.indexOf("/", 1) > 0) {
                sOperation = "/";
            } else if (expression.indexOf("*", 1) > 0) {
                sOperation = "*";
            } else if (expression.indexOf("+", 1) > 0) {
                sOperation = "+";
            } else if (expression.indexOf("-", 1) > 0) {
                sOperation = "-";
            } else {
                throw new IOException("Error: Needed operation is not found. Please check the expression!");
            }
        } catch (IOException e){
            return e.getMessage();
        }
        //Разбитие строки на: число1, оператор действия, число2. (запись в строковые и дисятичные переменные
        int positionOperation = expression.indexOf(sOperation,1);
        s1 = expression.substring(0,positionOperation);
        d1 = Double.parseDouble(expression.substring(0,positionOperation));
        sOperation = expression.substring(positionOperation,positionOperation+1);
        s2 = expression.substring(positionOperation+1,expression.length());
        d2 = Double.parseDouble(expression.substring(positionOperation+1,expression.length()));
        //Десятичные переменные имеют "точку" и два знака после запятой
        if (!s1.contains(sPoint)){
            return "Invalid input format: The first number must be a decimal number.";
        }
        if ((s1.substring(s1.indexOf(sPoint), s1.length()-1)).length()!=accuracy) {
            return "Invalid input format: The first number must be specified to two decimal places.";
        }
        if (!s2.contains(sPoint)){
            return "Invalid input format: The second number must be a decimal number.";
        }
        if ((s2.substring(s2.indexOf(sPoint), s2.length()-1)).length()!=accuracy) {
            return "Invalid input format: The second number must be specified to two decimal places.";
        }
        //Десятичные числа должны входить в промежуток [-10.00:10.00]
        if ((d1  < minValue) || (d1 >= maxValue)) {
            return "The first number is not included in the specified range[-10:+10]. Please check it!";
        }  if ((d2 < minValue) || (d2 >= maxValue)) {
            return "The second number is not included in the specified range[-10:+10]. Please check it!";
        }
        //Нельзя делить на ноль
        if ((d2 == zero) && (Objects.equals(sOperation, "/"))){
            return "Can't divide by zero!";
        }
        //Выполнить необходимое действие с числом1 и числом2
        switch (sOperation.charAt(0)){
            case '+':
                result = d1+d2;
                break;
            case '-':
                result = d1-d2;
                break;
            case '/':
                result = d1/d2;
                break;
            case '*':
                result = d1*d2;
                break;
            default:
                result = 0.0;
        }
        /*/Результат выполнения - округлить до тысячных
        result = result * 1000;
        int i = (int) Math.round(result);
        result = (double)i / 1000;*/

        return String.format("%.3f", result);  //Результат арифметического действия до 1000-ых
    }
}

