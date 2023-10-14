import java.util.Scanner;
public class Main {
    static Scanner scanner;
    static Database db;
    public static void main(String[] args) {
        int number;
        scanner = new Scanner(System.in);
        db = new Database();
        User admin = new User("Admin", "Admin", true);
        db.addUsers(admin);
        User user1 = new User("User1", "User1", false);
        db.addUsers(user1);
        User user2 = new User("User2", "User2", false);
        db.addUsers(user2);
        do {
            System.out.println("Select your authority type:");
            System.out.println("1) Admin");
            System.out.println("2) User 1");
            System.out.println("3) User 2");
            System.out.println("4) Exit");
            number = Take_input(4);

            if (number == 1) {
                new AdminBoard(admin);
            } else if (number == 2){
                new UserBoard(user1);
            }
            else if(number == 3){
                new UserBoard(user2);
            }
        }while (number !=4);
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