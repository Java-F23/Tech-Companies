import java.util.ArrayList;
import java.util.Scanner;

public class AdminBoard {
    private Scanner scanner;

    public AdminBoard() {
        scanner = Main.scanner;
        showOptions();
    }

    public void showOptions() {
        System.out.println("Welcome");
        System.out.println("Please select an option:");
        System.out.println("1. Add Company");
        System.out.println("2. Update Company Details");
        System.out.println("3. Manage Job Applications");
        System.out.println("4. Manage a Project in a Company");
        System.out.println("5. Generate Company Report");
        System.out.println("6. Delete Company");
        System.out.println("7. Log Out");

        int option = Main.Take_input(7);
        boolean Repeat = true;

        switch (option) {
            case 1:{
                AddCompany();
                break;
            }
            case 2:{
                UpdateCompany();
                break;
            }
            case 3:{
                Jobs();
                break;
            }
            case 4:{
                Projects();
                break;
            }
            case 5:{
                Report();
                break;
            }
            case 6{
                DeleteCompany();
                break;
            }
            case 7:{
                Repeat = false;
                break;
            }
            default: {
                System.out.println("Invalid option. Please try again.");
                showOptions();
                break;
            }
        }
        if(Repeat){
            showOptions();
        }
        else {
            System.out.println("Logging Out");
        }
    }

    private void AddCompany() {
        System.out.println("Enter the company's name: ");
        String name = scanner.next();
        System.out.println("Enter its main industry: ");
        String industry = scanner.next();
        int year = 0;
        do {
            System.out.println("Enter its Year of Founding: ");
            if(scanner.hasNextInt()){
                year = scanner.nextInt();
                if(!(year > 0 && year <= 2023)){
                    System.out.println("Invalid Input, Enter a valid year");
                }
            }
            else{
                System.out.println("Invalid Input, Enter year in numerical form");
                scanner.next();
            }
        }while(!(year > 0 && year <= 2023));
        System.out.println("Enter its Location");
        String location = scanner.next();
        Company temp = new Company(name,industry,year,location);
        Main.db.addCompany(temp);
    }

    private void UpdateCompany() {
        Company current_c = getCertainCompany();
        if (current_c == null){
            return;
        }
        boolean repeat = true;
        do {
            current_c.printCompanyDetails();
            System.out.println("What do you want to modify: ");
            System.out.println("1) Change Name");
            System.out.println("2) Change Location");
            System.out.println("3) Change Industry");
            System.out.println("4) Change Year of Founding");
            System.out.println("5) Add Product");
            System.out.println("6) Remove Product");
            System.out.println("7) Add Service");
            System.out.println("8) Remove Service");
            System.out.println("9) Add Job Listing");
            System.out.println("10) Remove Job Listing");
            System.out.println("11) Add Employees");
            System.out.println("12) Remove Employees");
            System.out.println("13) Add Current Project");
            System.out.println("14) Delete Current Project");
            System.out.println("15) Set Current Project to Completed");
            System.out.println("16) Delete Completed Project");
            System.out.println("17) Add Course");
            System.out.println("18) Remove Course");
            System.out.println("19) Add Tutorial");
            System.out.println("20) Remove Tutorial");
            System.out.println("21) Add Documentation");
            System.out.println("22) Remove Documentation");
            System.out.println("23) Change Revenue");
            System.out.println("24) Return to Main Menu");
            System.out.println("Select Operation:");
            int op = Main.Take_input(24);
            switch (op) {
                case 1: {
                    System.out.println("Enter the company's new name: ");
                    String newName = scanner.next();
                    current_c.setName(newName);
                    System.out.println("Name Changed Successfully");
                    break;
                }
                case 2: {
                    System.out.println("Enter the company's new location: ");
                    String newLoc = scanner.next();
                    current_c.setLocation(newLoc);
                    System.out.println("Location Changed Successfully");
                    break;
                }
                case 3: {
                    System.out.println("Enter the company's new industry: ");
                    String newInd = scanner.next();
                    current_c.setIndustry(newInd);
                    System.out.println("Industry Changed Successfully");
                    break;
                }
                case 4: {
                    int year = 0;
                    do {
                        System.out.println("Enter the company's new year of founding: ");
                        if (scanner.hasNextInt()) {
                            year = scanner.nextInt();
                            if (!(year > 0 && year <= 2023)) {
                                System.out.println("Invalid Input, Enter a valid year");
                            }
                        } else {
                            System.out.println("Invalid Input, Enter year in numerical form");
                            scanner.next();
                        }
                    } while (!(year > 0 && year <= 2023));
                    current_c.setFoundingYear(year);
                    System.out.println("Year of Founding Changed Successfully");
                    break;
                }
                case 5: {
                    System.out.println("Enter Product name: ");
                    String pName = scanner.next();
                    current_c.addProduct(pName);
                    System.out.println("Product Added Successfully");
                    break;
                }
                case 6: {
                    System.out.println("Enter Product name: ");
                    String pName = scanner.next();
                    if (current_c.getProducts().contains(pName)) {
                        current_c.removeProduct(pName);
                        System.out.println("Removed Successfully");
                    } else {
                        System.out.println("Doesn't Exist. Make sure you type its name correctly");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Enter Service name: ");
                    String sName = scanner.next();
                    current_c.addService(sName);
                    System.out.println("Service Added Successfully");
                    break;
                }
                case 8: {
                    System.out.println("Enter Service name: ");
                    String sName = scanner.next();
                    if (current_c.getServices().contains(sName)) {
                        current_c.removeService(sName);
                        System.out.println("Removed Successfully");
                    } else {
                        System.out.println("Doesn't Exist. Make sure you type its name correctly");
                    }
                    break;
                }
                case 9: {
                    System.out.println("Enter the Job Name: ");
                    String jName = scanner.next();
                    System.out.println("Enter the Job Description: ");
                    String jDesc = scanner.next();
                    JobListing J = new JobListing(jName, jDesc);
                    current_c.addJob(J);
                    System.out.println("Added Successfully");
                    break;
                }
                case 10: {
                    current_c.printJobs();
                    System.out.println("Enter number of job you want to delete: ");
                    if (current_c.getJobs().isEmpty()) {
                        System.out.println("No Job Listings to remove");
                    } else {
                        int jDel = Main.Take_input(current_c.getJobs().size());
                        current_c.removeJob(jDel-1);
                        System.out.println("Job Removed Successfully");
                    }
                    break;
                }
                case 11: {
                    int emp = -1;
                    do {
                        System.out.println("Enter Employee ID: ");
                        if (scanner.hasNextInt()) {
                            emp = scanner.nextInt();
                            if (!(emp >= 0)) {
                                System.out.println("Invalid Input, Enter a valid ID");
                            }
                        } else {
                            System.out.println("Invalid Input, Enter ID in numerical form");
                            scanner.next();
                        }
                    } while (!(emp >= 0));
                    current_c.addEmployee(emp);
                    System.out.println("Employee Added Successfully");
                    break;
                }
                case 12: {
                    int emp = -1;
                    do {
                        System.out.println("Enter Employee ID: ");
                        if (scanner.hasNextInt()) {
                            emp = scanner.nextInt();
                            if (!(emp >= 0)) {
                                System.out.println("Invalid Input, Enter a valid ID");
                            }
                        } else {
                            System.out.println("Invalid Input, Enter ID in numerical form");
                        }
                    } while (!(emp >= 0));
                    if (current_c.getEmployees().contains(emp)) {
                        current_c.removeEmployee(emp);
                        System.out.println("Employee Removed Successfully");
                    } else {
                        System.out.println("Employee Doesn't Exist in this Company");
                        scanner.next();
                    }
                    break;
                }
                case 13: {
                    Project newP = newProject();
                    current_c.addCurrentProject(newP);
                    break;
                }
                case 14: {
                    current_c.printCurrentProjects();
                    if (current_c.getCurrentProjects().isEmpty()) {
                        System.out.println("No Current Project to remove");
                    } else {
                        System.out.println("Select number of project you want to delete: ");
                        int pDel = Main.Take_input(current_c.getCurrentProjects().size());
                        current_c.removeCurrentProject(pDel-1);
                        System.out.println("Removed Successfully");
                    }
                    break;
                }
                case 15: {
                    current_c.printCurrentProjects();
                    if (current_c.getCurrentProjects().isEmpty()) {
                        System.out.println("No Current Project to complete");
                    } else {
                        System.out.println("Select number of project you want to complete: ");
                        int pDel = Main.Take_input(current_c.getCurrentProjects().size());
                        current_c.completeCurrentProject(pDel-1);
                        System.out.println("Completed Successfully");
                    }
                    break;
                }
                case 16: {
                    current_c.printPastProjects();
                    if (current_c.getPastProjects().isEmpty()) {
                        System.out.println("No Past Projects to delete");
                    } else {
                        System.out.println("Select number of project you want to delete: ");
                        int pDel = Main.Take_input(current_c.getPastProjects().size());
                        current_c.removePastProject(pDel-1);
                        System.out.println("Completed Successfully");
                    }
                    break;
                }
                case 17: {
                    current_c.addCourse(newResource());
                    System.out.println("Course Added Successfully");
                    break;
                }
                case 18: {
                    current_c.printCourses();
                    if (current_c.getCourses().isEmpty()) {
                        System.out.println("No Courses to Delete");
                    } else {
                        System.out.println("Select number of Course you want to Delete: ");
                        int RDel = Main.Take_input(current_c.getCourses().size());
                        current_c.removeCourse(RDel-1);
                        System.out.println("Completed Successfully");
                    }
                    break;
                }
                case 19: {
                    current_c.addTutorial(newResource());
                    System.out.println("Tutorial Added Successfully");
                    break;
                }
                case 20: {
                    current_c.printTutorials();
                    if (current_c.getTutorials().isEmpty()) {
                        System.out.println("No Tutorials to Delete");
                    } else {
                        System.out.println("Select number of Tutorial you want to Delete: ");
                        int RDel = Main.Take_input(current_c.getTutorials().size());
                        current_c.removeTutorial(RDel-1);
                        System.out.println("Completed Successfully");
                    }
                    break;
                }
                case 21: {
                    current_c.addDocumentation(newResource());
                    System.out.println("Documentation Added Successfully");
                    break;
                }
                case 22: {
                    current_c.printDocumentations();
                    if (current_c.getDocumentations().isEmpty()) {
                        System.out.println("No Documentations to Delete");
                    } else {
                        System.out.println("Select number of Documentation you want to Delete: ");
                        int RDel = Main.Take_input(current_c.getDocumentations().size());
                        current_c.removeDocumentation(RDel-1);
                        System.out.println("Completed Successfully");
                    }
                    break;
                }
                case 23: {
                    float newRev = -1;
                    do {
                        System.out.println("Enter new Revenue (must be greater than 0): ");
                        if (scanner.hasNextFloat()) {
                            newRev = scanner.nextFloat();
                            if (!(newRev >= 0)) {
                                System.out.println("Invalid Input, Enter a valid positive revenue");
                            }
                        } else {
                            System.out.println("Invalid Input, Enter revenue in numerical form");
                            scanner.next();
                        }
                    } while (!(newRev >= 0));
                    break;
                }
                case 24: {
                    repeat = false;
                    break;
                }
            }
        }while (repeat);
    }
    private Project newProject(){
        int pID = -1;
        do {
            System.out.println("Enter Project ID: ");
            if(scanner.hasNextInt()){
                pID = scanner.nextInt();
                if(!(pID >= 0)){
                    System.out.println("Invalid Input, Enter a valid ID");
                }
            }
            else{
                System.out.println("Invalid Input, Enter ID in numerical form");
                scanner.next();
            }
        }while(!(pID >= 0));
        System.out.println("Enter Project Name: ");
        String pName = scanner.next();
        System.out.println("Enter Project Description: ");
        String pDesc = scanner.next();
        float pRev = -1;
        do {
            System.out.println("Enter Project Revenue: ");
            if(scanner.hasNextFloat()){
                pRev = scanner.nextFloat();
                if(!(pRev >= 0)){
                    System.out.println("Invalid Input, Enter a valid positive revenue");
                }
            }
            else{
                System.out.println("Invalid Input, Enter revenue in numerical form");
                scanner.next();
            }
        }while(!(pRev >= 0));
        return new Project(pID,pName,pDesc,pRev);
    }
    private Resource newResource(){
        System.out.println("Enter the resource name: ");
        String name = scanner.next();
        System.out.println("Enter the resource description: ");
        String desc = scanner.next();
        System.out.println("Enter the resources URL: ");
        String link = scanner.next();
        return new Resource(name,desc,link);
    }

    private void Jobs() {
        Company current_c = getCertainCompany();
        if (current_c == null){
            return;
        }
        current_c.printJobs();
        if(current_c.getJobs().isEmpty()){
            System.out.println("No Job Listings yet, add one to unlock this feature");
            return;
        }
        System.out.println("Select the job number you want to manage: ");
        int job_index = Main.Take_input(current_c.getJobs().size()) -1;
        JobListing current_j = current_c.getJobs().get(job_index);
        boolean repeat = true;
        do {
            current_j.printApplicants();
            if (current_j.getApplicants().isEmpty()){
                System.out.println("No applications yet to this listing");
            }
            System.out.println("Select an application to manage or Enter " + (current_j.getApplicants().size()+1) + "to exit");
            int app_index = Main.Take_input(current_j.getApplicants().size() + 1);
            if(app_index == current_j.getApplicants().size() +1 ){
                repeat = false;
            }
            else{
                User current_app = current_j.getApplicants().get(app_index-1);
                System.out.println("Enter 1 to approve to the company and 2 to disapprove application");
                int decision = Main.Take_input(2);
                if(decision == 1){
                    current_c.addEmployee(current_app.getID());
                }
                current_j.removeApplicant(current_app);
            }

        }while (repeat);
    }
    private Company getCertainCompany(){
        ArrayList<Company> temp = Main.db.getCompanies();
        if (temp.isEmpty()){
            System.out.println("No Companies in Database yet, add some to unlock this feature");
            return null;
        }
        else{
            int i = 1;
            for(Company C: temp){
                System.out.println(i + ") " + C);
                i++;
            }
            System.out.println("Select the company you want to update: ");
            int c_index = Main.Take_input(temp.size());
            return temp.get(c_index-1);
        }
    }
    private int getCertainCompanyIndex(){
        ArrayList<Company> temp = Main.db.getCompanies();
        if (temp.isEmpty()){
            System.out.println("No Companies in Database yet, add some to unlock this feature");
            return -1;
        }
        else{
            int i = 1;
            for(Company C: temp){
                System.out.println(i + ") " + C);
                i++;
            }
            System.out.println("Select the company you want to update: ");
            return Main.Take_input(temp.size()) - 1;
        }
    }

    private void Projects(){
        Company current_c = getCertainCompany();
        if (current_c == null){
            return;
        }
        current_c.printCurrentProjects();
        if(current_c.getCurrentProjects().isEmpty()){
            System.out.println("No Projects yet, add one to unlock this feature");
            return;
        }
        System.out.println("Select the project number you want to manage: ");
        int proj_index = Main.Take_input(current_c.getCurrentProjects().size()) -1;
        Project current_p = current_c.getCurrentProjects().get(proj_index);
        boolean repeat = true;
        do {
            System.out.println("Select the operation you want: ");
            System.out.println("1) Add an Employee to the project");
            System.out.println("2) Remove an Employee from the project");
            System.out.println("3) Update Progress");
            System.out.println("4) Update Revenue");
            System.out.println("5) Return to main menu");
            int op = Main.Take_input(5);
            switch (op){
                case 1:{
                    current_c.printEmployees();
                    if(current_c.getEmployees().isEmpty()){
                        System.out.println("No employees in company, can't access this feature yet");
                    }
                    else{
                        System.out.println("Select the number of the employee you want to assign");
                        int e = Main.Take_input(current_c.getEmployees().size());
                        current_p.addAssigned(current_c.getEmployees().get(e-1));
                        System.out.println("Added Successfully");
                    }
                    break;
                }
                case 2:{
                    current_p.printAssigned();
                    if(current_p.getAssigned().isEmpty()){
                        System.out.println("No employees assigned to this project, can't access this feature yet");
                    }
                    else{
                        System.out.println("Select the number of the employee you want to remove");
                        int e = Main.Take_input(current_p.getAssigned().size());
                        current_p.removeAssigned(e-1);
                        System.out.println("Removed Successfully");
                    }
                    break;
                }
                case 3:{
                    float prog = -1;
                    do {
                        System.out.println("Enter Progress in Percentage: ");
                        if(scanner.hasNextFloat()){
                            prog = scanner.nextFloat();
                            if(!(prog >= 0 && prog <= 100)){
                                System.out.println("Invalid Input, Enter a valid percentage progress");
                            }
                        }
                        else{
                            System.out.println("Invalid Input, Enter progress in numerical form");
                            scanner.next();
                        }
                    }while(!(prog >= 0 && prog <= 100));
                    current_p.setProgress(prog);
                    System.out.println("Updated Successfully");
                    break;
                }
                case 4:{
                    float rev = -1;
                    do {
                        System.out.println("Enter Revenue in numbers: ");
                        if(scanner.hasNextFloat()){
                            rev = scanner.nextFloat();
                            if(!(rev >= 0)){
                                System.out.println("Invalid Input, Enter a valid positive revenue");
                            }
                        }
                        else{
                            System.out.println("Invalid Input, Enter revenue in numerical form");
                            scanner.next();
                        }
                    }while(!(rev >= 0 && rev <= 100));
                    current_p.setRevenue(rev);
                    System.out.println("Updated Successfully");
                    break;
                }
                case 5:{
                    repeat = false;
                    break;
                }
            }
        }while (repeat);
    }
    private void Report(){
        Company current_c = getCertainCompany();
        if (current_c == null){
            return;
        }
        System.out.println("Revenue: " + current_c.getRevenue());
        System.out.println("Employee Count: " + current_c.getEmployees().size());
        int undone = current_c.getCurrentProjects().size();
        int done =  current_c.getPastProjects().size();
        if(done + undone == 0){
            System.out.println("Can't Compute Project Completion Rate yet, not projects for this company");
        }
        else{
            System.out.println("Project Completion Rate: " + ((done/(done+undone))*100) + "%");
        }
        System.out.println("Press Enter to continue..");
        scanner.next();
    }

    private void DeleteCompany(){
        int current_c_index = getCertainCompanyIndex();
        if (current_c_index == -1){
            return;
        }
        Main.db.removeCompany(current_c_index);
        System.out.println("Company Removed Successfully");
    }
}