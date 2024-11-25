package hust.soict.dsai.Lab01;

import javax.swing.JOptionPane;

public class Calculator{
    public static void main(String[] args){
        String strnum1, strnum2;
        strnum1 = JOptionPane.showInputDialog(null, "Enter first number: ");
        double num1 = Double.parseDouble(strnum1);
        strnum2 = JOptionPane.showInputDialog(null, "Enter second number: ");
        double num2 = Double.parseDouble(strnum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient;
        String Noti;
        if(num2 == 0){
            Noti = "Can't divide by zero!!!";
        } else {
            quotient = num1/num2;
            Noti = "Quotient: " + quotient; 
        }

        String result = "Sum: " + sum + "\n" + 
                        "Diffrence: " + difference + "\n" + 
                        "Produt: " + product + "\n" + Noti;

        JOptionPane.showMessageDialog(null, result, "Results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
