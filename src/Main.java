import java.util.Scanner;
public class Main {
    static Scanner scanner;
    static Database db;
    static Welcome_Screen welcomeScreen;
    public static void main(String[] args) {
        int number;
        scanner = new Scanner(System.in);
        fillDb();
        User admin = new User("Admin", "Admin", true);
        db.addUsers(admin);
        User user1 = new User("User1", "User1", false);
        db.addUsers(user1);
        User user2 = new User("User2", "User2", false);
        db.addUsers(user2);
        welcomeScreen= new Welcome_Screen(db);
        welcomeScreen.initiate();
        /*do {
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
        }while (number !=4);*/
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
    private static void fillDb(){
        db = new Database();

        // Add companies to the database
        Company company1 = new Company("Google", "Technology", 1998, "California, USA");
        company1.addProduct("Google Search");
        company1.addProduct("Google Maps");
        db.addCompany(company1);
        JobListing job1 = new JobListing("Software Engineer", "California, USA, Full-time");
        company1.addJob(job1);
        Project project1 = new Project(1, "Google Search Improvement", "Technology", 10);
        company1.addCurrentProject(project1);

        Company company2 = new Company("Apple", "Technology", 1976, "California, USA");
        company2.addProduct("iPhone");
        company2.addProduct("MacBook");
        db.addCompany(company2);
        JobListing job2 = new JobListing("iOS Developer", "California, USA, Full-time");
        company2.addJob(job2);
        Project project2 = new Project(2,"New MacBook Design", "Technology", 20);
        company2.addCurrentProject(project2);

        Company company3 = new Company("Amazon", "E-commerce", 1994, "Washington, USA");
        company3.addProduct("Amazon Prime");
        company3.addProduct("Kindle");
        db.addCompany(company3);
        JobListing job3 = new JobListing("Data Analyst", "Washington, USA, Full-time");
        company3.addJob(job3);
        Project project3 = new Project(3,"Customer Recommendation System", "Technology", 30);
        company3.addCurrentProject(project3);

        Company company4 = new Company("Tesla", "Automotive", 2003, "California, USA");
        company4.addProduct("Tesla Model S");
        company4.addProduct("Tesla Cybertruck");
        db.addCompany(company4);
        JobListing job4 = new JobListing("Mechanical Engineer", "California, USA, Full-time");
        company4.addJob(job4);
        Project project4 = new Project(4, "Autonomous Driving System", "Technology", 40);
        company4.addCurrentProject(project4);

        Company company5 = new Company("Microsoft", "Technology", 1975, "Washington, USA");
        company5.addProduct("Windows");
        company5.addProduct("Microsoft Office");
        db.addCompany(company5);
        JobListing job5 = new JobListing("Software Developer", "Washington, USA, Full-time");
        company5.addJob(job5);
        Project project5 = new Project(5, "Cloud Computing Platform", "Technology", 50);
        company5.addCurrentProject(project5);

        Company company6 = new Company("Facebook", "Social Media", 2004, "California, USA");
        company6.addProduct("Facebook App");
        company6.addProduct("Instagram");
        db.addCompany(company6);
        JobListing job6 = new JobListing("Data Scientist", "California, USA, Full-time");
        company6.addJob(job6);
        Project project6 = new Project(6,"Social Network Analysis", "Technology", 60);
        company6.addCurrentProject(project6);

        Company company7 = new Company("Netflix", "Entertainment", 1997, "California, USA");
        company7.addProduct("Netflix Streaming");
        company7.addProduct("Netflix Originals");
        db.addCompany(company7);
        JobListing job7 = new JobListing("Content Writer", "California, USA, Full-time");
        company7.addJob(job7);
        Project project7 = new Project(7,"Recommendation Algorithm", "Technology",70);
        company7.addCurrentProject(project7);

        Company company8 = new Company("IBM", "Technology", 1911, "New York, USA");
        company8.addProduct("IBM Watson");
        company8.addProduct("IBM Cloud");
        db.addCompany(company8);
        JobListing job8 = new JobListing("Software Architect", "New York, USA, Full-time");
        company8.addJob(job8);
        Project project8 = new Project(8,"Blockchain Technology", "Technology",80);
        company8.addCurrentProject(project8);

        Company company9 = new Company("Coca-Cola", "Beverages", 1892, "Georgia, USA");
        company9.addProduct("Coca-Cola Classic");
        company9.addProduct("Sprite");
        db.addCompany(company9);
        JobListing job9 = new JobListing("Marketing Manager", "Georgia, USA, Full-time");
        company9.addJob(job9);
        Project project9 = new Project(9,"Brand Promotion Campaign", "Marketing",90);
        company9.addCurrentProject(project9);
    }
}