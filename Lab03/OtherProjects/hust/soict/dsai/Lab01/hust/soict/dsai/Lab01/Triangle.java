package hust.soict.dsai.Lab01;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter height");
        int height = keyboard.nextInt();
        for(int i = 0; i < height; i++){
            for(int j = height - i; j > 0; j--){
                System.out.print(" ");
            } 
            for(int k = 0; k <= 2*i; k ++){
                System.out.print("*");
            }
            System.out.println();
        }
        keyboard.close();
    }
}
