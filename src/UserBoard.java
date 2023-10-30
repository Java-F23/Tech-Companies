import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserBoard {
    private Scanner scanner;
    private User user;

    public UserBoard(User user) {
        scanner = Main.scanner;
        this.user = user;
        showOptions();
    }

    public void showOptions() {
        System.out.println("Welcome, " + user.getUsername() + " !");
        System.out.println("Please select an option:");
        System.out.println("1) Show all Companies");
        System.out.println("2) Filter Companies by name");
        System.out.println("3) Filter Companies by industry");
        System.out.println("4) Filter Companies by location");
        System.out.println("5) Show Favourite Companies");
        System.out.println("6) Log Out");

        int option = Main.Take_input(6);
        boolean Repeat = true;

        switch (option) {
            case 1: {
                ShowList(Main.db.getCompanies());
                break;
            }
            case 2: {
                searchName();
                break;
            }
            case 3: {
                searchIndustry();
                break;
            }
            case 4: {
                searchLocation();
                break;
            }
            case 5:{
                showFavourites();
                break;
            }
            case 6: {
                Repeat = false;
                break;
            }
            default: {
                System.out.println("Invalid option. Please try again.");
                showOptions();
                break;
            }
        }
        if (Repeat) {
            showOptions();
        } else {
            System.out.println("Logging Out");
        }
    }

    public void showCompany(Company c){
        boolean repeat = true;
        do {
            c.printCompanyDetails(new JPanel());
            System.out.println("Select the operation you want:");
            System.out.println("1) Mark as your favourite");
            System.out.println("2) Remove from favourites");
            System.out.println("3) Apply for a job listing");
            System.out.println("4) Access a Course");
            System.out.println("5) Access a Tutorial");
            System.out.println("6) Access a Documentation");
            System.out.println("7) Return to list of companies");
            int op = Main.Take_input(7);
            switch (op){
                case 1:{
                    if(user.getFavoriteCompanies().contains(c)){
                        System.out.println("Already in your favourites");
                    }
                    else{
                        user.addFavoriteCompany(c);
                        System.out.println("Added Successfully");
                    }
                    break;
                }
                case 2:{
                    if(user.getFavoriteCompanies().contains(c)){
                        user.removeFavoriteCompany(c);
                        System.out.println("Removed Successfully");
                    }
                    else{
                        System.out.println("Already not in your favourites");
                    }
                    break;
                }
                case 3:{
                    c.printJobs();
                    if(c.getJobs().isEmpty()){
                        System.out.println("No Job Listings yet, stay tuned for future listings");
                    }
                    else{
                        System.out.println("Select the job number you want to apply to: ");
                        int job_index = Main.Take_input(c.getJobs().size()) -1;
                        c.getJobs().get(job_index).addApplicant(user);
                        System.out.println("Successfully Applied");
                    }
                    break;
                }
                case 4:{
                    c.printCourses();
                    if(c.getCourses().isEmpty()){
                        System.out.println("No Courses yet, stay tuned for future listings");
                    }
                    else{
                        System.out.println("Select the course number you want to apply to: ");
                        int r_index = Main.Take_input(c.getCourses().size()) -1;
                        c.getCourses().get(r_index).printResource();
                    }
                    break;
                }
                case 5:{
                    c.printTutorials();
                    if(c.getTutorials().isEmpty()){
                        System.out.println("No Tutorials yet, stay tuned for future listings");
                    }
                    else{
                        System.out.println("Select the tutorial number you want to apply to: ");
                        int r_index = Main.Take_input(c.getTutorials().size()) -1;
                        c.getTutorials().get(r_index).printResource();
                    }
                    break;
                }
                case 6:{
                    c.printDocumentations();
                    if(c.getDocumentations().isEmpty()){
                        System.out.println("No Documentation yet, stay tuned for future listings");
                    }
                    else{
                        System.out.println("Select the documentation number you want to apply to: ");
                        int r_index = Main.Take_input(c.getDocumentations().size()) -1;
                        c.getDocumentations().get(r_index).printResource();
                    }
                    break;
                }
                case 7: repeat = false;
            }
        }while (repeat);

    }
    public void ShowList(ArrayList<Company> cs){
        if (cs.isEmpty()){
            System.out.println("No Companies that satisfy your requirements in Database yet, wait for an admin to add some then try again");
            return;
        }
        boolean repeat = true;
        do {
            int i = 1;
            for (Company C : cs) {
                System.out.println(i + ") " + C);
                i++;
            }
            System.out.println(i + ") Return to Main Menu");
            System.out.println("Select the company you want to update: ");
            int c_index = Main.Take_input(i);
            if(c_index == i){
                repeat = false;
            }
            else{
                showCompany(cs.get(c_index-1));
            }
        }while (repeat);
    }
    public void searchName(){
        System.out.println("Enter the name of the company to search for: ");
        String search = scanner.next();
        ShowList(Main.db.getCompaniesByName(search));
    }
    public void searchIndustry(){
        System.out.println("Enter the industry of the companies to search for: ");
        String search = scanner.next();
        ShowList(Main.db.getCompaniesByIndustry(search));
    }
    public void searchLocation(){
        System.out.println("Enter the location of the companies to search for: ");
        String search = scanner.next();
        ShowList(Main.db.getCompaniesByLocation(search));
    }
    public void showFavourites(){
        ShowList(user.getFavoriteCompanies());
    }
}