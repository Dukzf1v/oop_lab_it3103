package hust.soict.dsai.Lab01;

import java.util.Scanner;

public class AddMatrices {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of rows and columns:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        
        double[][] arr1 = new double[row][col];
        double[][] arr2 = new double[row][col];
        double[][] result = new double[row][col];
        
        System.out.println("Enter elements of matrix 1:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr1[i][j] = scanner.nextDouble();
            }
        }
        
        System.out.println("Enter elements of matrix 2:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr2[i][j] = scanner.nextDouble();
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        System.out.println("Result:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
