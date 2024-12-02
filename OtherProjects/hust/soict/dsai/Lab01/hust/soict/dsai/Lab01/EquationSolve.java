package hust.soict.dsai.Lab01;

import javax.swing.JOptionPane;

public class EquationSolve {
    public static void main(String[] args){
        String choice = JOptionPane.showInputDialog(
            "1.First-degree equation with one variable\n" +
            "2.System of first-degree equations with two variables\n" +
            "3.Second-degree equation with one variable\n"
        );
    switch(choice){
        case "1": 
            first_degree();
            break;
        case "2":
            system_first_degree();
            break;
        case "3":
            second_degree();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Error!!!");
        }    
    }

    public static void first_degree(){
        String strA = JOptionPane.showInputDialog(null, "Enter a: ");
        double a = Double.parseDouble(strA);
        String strB = JOptionPane.showInputDialog(null, "Enter b: ");
        double b = Double.parseDouble(strB);
        double result;
        if( a == 0){
            if ( b == 0){
                JOptionPane.showMessageDialog(null, "infinitely many solutions");
            } else {
                JOptionPane.showMessageDialog(null, "no solution");
            }
        } else {
            result = -b / a;
            JOptionPane.showMessageDialog(null, "result: " + result);
        }
    }

    public static void system_first_degree(){
        String strA11 = JOptionPane.showInputDialog("Enter a11:");
        double a11 = Double.parseDouble(strA11);
        String strA12 = JOptionPane.showInputDialog("Enter a12:");
        double a12 = Double.parseDouble(strA12);
        String strB1 = JOptionPane.showInputDialog("Enter b1:");
        double b1 = Double.parseDouble(strB1);
        
        String strA21 = JOptionPane.showInputDialog("Enter a21:");
        double a21 = Double.parseDouble(strA21);
        String strA22 = JOptionPane.showInputDialog("Enter a22:");
        double a22 = Double.parseDouble(strA22);
        String strB2 = JOptionPane.showInputDialog("Enter b2:");
        double b2 = Double.parseDouble(strB2);

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if(D == 0) {
            if(D1 == 0 && D2 == 0){
                JOptionPane.showMessageDialog(null, "infinitely many solutions");
            } else {
                JOptionPane.showMessageDialog(null, "no solution");
            }
        } else {
            double result1 = D1 / D;
            double result2 = D2 / D;
            JOptionPane.showMessageDialog(null, "x1 = " + result1 + "\nx2 = " + result2);
        }
    }

    public  static void second_degree(){
        String strA = JOptionPane.showInputDialog("Enter a:");
        double a = Double.parseDouble(strA);
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "a can't be zero!!!");
            return;
        }
        String strB = JOptionPane.showInputDialog("Enter b:");
        double b = Double.parseDouble(strB);
        String strC = JOptionPane.showInputDialog("Enter c:");
        double c = Double.parseDouble(strC);

        double  discriminant = b*b - 4*a*c;

        if( discriminant > 0){
            double result1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double result2 = (-b - Math.sqrt(discriminant)) / (2*a);
            JOptionPane.showMessageDialog(null, "Root 1 =  " + result1 + "Root 2 = " + result2);
        } else if (discriminant == 0){
            double root = -b/(2*a);
            JOptionPane.showMessageDialog(null, "Root = " + root);
        } else {
            JOptionPane.showMessageDialog(null, "no solution");
        }
    }
}
