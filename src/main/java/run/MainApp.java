package run;

import entity.Calc;

public class MainApp {
    public static void main(String[] args) {
    	 Calc calculation = new Calc();
         //������ �������������� ���������
         String resultExpression = calculation.count("-8.00/0.00");
         //�������� ��������� ��������������� ���������
         System.out.println(resultExpression);
    }
}