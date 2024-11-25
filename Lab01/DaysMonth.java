import java.util.Scanner;

public class DaysMonth {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String month;
        int year;
        int days;
        while(true){
            System.out.print("Enter year: ");
            year = keyboard.nextInt();
            if(year < 0){
                System.out.println("Year cant be a negative number. Try again^^");
            } else {
                break;
            }
        }
        keyboard.nextLine();
        while(true){
            System.out.print("Enter month: ");
            month = keyboard.nextLine().trim();
            days = DaysOfMonth(month ,year);
            if(days == 0){
                System.out.println("Invalid month. Try again^^");
            } else {
                break;
            }
        }
        System.out.println("There are " + days + " days in year " + year + " month " + month);
        keyboard.close();
    }

    public static boolean isLeapYear(int year){
        if(year % 4 == 0){
            if(year % 100 == 0 && year % 400 != 0){
                return false;
            } else {
                return true;
            }
        } 
        return false;
    }

    public static int DaysOfMonth(String month, int year){
        switch (month) {
            case "January": case "Jan.": case "Jan": case "1":
                return 31;
            case "February": case "Feb.": case "Feb": case "2":
                return isLeapYear(year) ? 29 : 28;
            case "March": case "Mar.": case "Mar": case "3":
                return 31;
            case "April": case "Apr.": case "Apr": case "4":
                return 30;
            case "May": case "5":
                return 31;
            case "June": case "Jun.": case "Jun": case "6":
                return 30;
            case "July": case "Jul.": case "Jul": case "7":
                return 31;
            case "August": case "Aug.": case "Aug": case "8":
                return 31;
            case "September": case "Sept.": case "Sept": case "9":
                return 30;
            case "October": case "Oct.": case "Oct": case "10":
                return 31;
            case "November": case "Nov.": case "Nov": case "11":
                return 30;
            case "December": case "Dec.": case "Dec": case "12":
                return 31;
            default:
                return 0; // Invalid month
        }
    }
}
