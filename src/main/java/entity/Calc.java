package entity;

import java.io.IOException;
import java.util.Objects;

public class Calc {

    private double minValue, maxValue, zero;
    private int accuracy;
    private String sPoint;

    /* � ����������� �������� ��������� ����������� ��� ���������� �������:
    1. ����� � ��������� - ������ �� -10 �� 10 (�� ������� 10 � -10)
    2. ���������� �����, ������ ������ - ��� ����� ����� ����� (�� ���� �������� - �� �����)
    3. ������������ ������ ������ � ������ 0
    */

    public Calc () {
        minValue = -10.00;
        maxValue = 10.00;
        zero = 0.00;
        accuracy = 2;
        sPoint = ".";
    }

    public String count(String expression){
        double d1; //������ �����
        String sOperation; //��������
        double d2; //������ �����
        double result;
        String s1;
        String s2;

        //����� � ������������� ��������� �������� (/ * + -)
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
        //�������� ������ ��: �����1, �������� ��������, �����2. (������ � ��������� � ���������� ����������
        int positionOperation = expression.indexOf(sOperation,1);
        s1 = expression.substring(0,positionOperation);
        d1 = Double.parseDouble(expression.substring(0,positionOperation));
        sOperation = expression.substring(positionOperation,positionOperation+1);
        s2 = expression.substring(positionOperation+1,expression.length());
        d2 = Double.parseDouble(expression.substring(positionOperation+1,expression.length()));
        //���������� ���������� ����� "�����" � ��� ����� ����� �������
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
        //���������� ����� ������ ������� � ���������� [-10.00:10.00]
        if ((d1  < minValue) || (d1 >= maxValue)) {
            return "The first number is not included in the specified range[-10:+10]. Please check it!";
        }  if ((d2 < minValue) || (d2 >= maxValue)) {
            return "The second number is not included in the specified range[-10:+10]. Please check it!";
        }
        //������ ������ �� ����
        if ((d2 == zero) && (Objects.equals(sOperation, "/"))){
            return "Can't divide by zero!";
        }
        //��������� ����������� �������� � ������1 � ������2
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
        /*/��������� ���������� - ��������� �� ��������
        result = result * 1000;
        int i = (int) Math.round(result);
        result = (double)i / 1000;*/

        return String.format("%.3f", result);  //��������� ��������������� �������� �� 1000-��
    }
}

