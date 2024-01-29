import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            System.out.print("Enter year: ");
            int year = scanner.nextInt();

            System.out.print("Enter month: ");
            int month = scanner.nextInt();

            CalendarApp.printCalendar(year,month);
        }

    }


}