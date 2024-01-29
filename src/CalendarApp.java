import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class CalendarApp {
    static Scanner scanner = new Scanner(System.in);
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String YELLOW_TEXT = "\u001B[33m";


    public static void printCalendar(int year, int month) {

        LocalDate date = LocalDate.of(year, month, 1);
        LocalDate datePrev = LocalDate.of(date.minusMonths(1).getYear(), date.minusMonths(1).getMonth(), 1);
        LocalDate currentDate  = LocalDate.now();
        LocalDate dateNext = LocalDate.of(date.plusMonths(1).getYear(), date.plusMonths(1).getMonth(), 1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

        int daysInMonth = date.lengthOfMonth();
        int offset = date.getDayOfWeek().getValue() % 7 - 1;
        int offsetNextMonth = dateNext.getDayOfWeek().getValue() % 7 - 1;


        System.out.println("\n" + date.format(formatter));
        System.out.println("Mo Tu We Th Fr Sa Su");

        for (int day = datePrev.lengthOfMonth() - offset; day <= datePrev.lengthOfMonth() - 1; day++) {
            System.out.printf("%2d ", day);
        }

        for (int day = 1; day <= daysInMonth; day++) {
            if (date.isEqual(currentDate)) {
                System.out.print(YELLOW_TEXT);
                System.out.printf("%2d", day);
                System.out.print(RESET);
            }else {
                System.out.printf("%2d", day);
            }

            if ((day + offset) % 7 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }

            date = date.plusDays(1);
        }

        for (int day = 1; day <= 7 - offsetNextMonth; day++) {
            if(offsetNextMonth == 0 ) {
                break;
            }
            System.out.printf("%2d ", day);

        }

        System.out.println();
    }

}
