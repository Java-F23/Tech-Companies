import java.util.Scanner;
public class Main {
    static Scanner scanner;
    static Database db;
    public static void main(String[] args) {
        int number;
        scanner = new Scanner(System.in);
        db = new Database();
        do {
            System.out.println("Select your authority type:");
            System.out.println("1) Admin");
            System.out.println("2) User");
            System.out.println("3) Exit");
            number = Take_input(3);

            if (number == 1) {
                AdminBoard a = new AdminBoard();
            } else if (number == 2){
                System.out.println("You are assigned as a user.");
            }
        }while (number !=3);
        scanner.close();
    }

    public static int Take_input(int x) {
        int number=0;
        boolean isValid = false;

        do {
            System.out.print("Enter your selection (a number between 1 and " + x + "): ");

            if (scanner.hasNextInt()) {
                number = scanner.nextInt();

                if (number >= 1 && number <= x) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input! Please enter a number between 1 and " + x + ".");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); // Discard the invalid input
            }
        } while (!isValid);
        return (number);
    }
}