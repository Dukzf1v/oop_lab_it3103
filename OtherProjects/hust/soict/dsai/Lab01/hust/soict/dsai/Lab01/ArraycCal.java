package hust.soict.dsai.Lab01;

import java.util.Scanner;
import java.util.Arrays;

public class ArraycCal {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter length: ");
        int n = keyboard.nextInt();
        int array[] = new int[n];
        for(int i = 0; i  < n; i++){
            array[i] = keyboard.nextInt();
        }
        Arrays.sort(array);
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += array[i];
        }
        double average = sum / n;
        System.out.println("Sorted array: " + Arrays.toString(array));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);

        keyboard.close();
    }

}
