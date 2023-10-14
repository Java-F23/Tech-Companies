import java.util.ArrayList;

public class Company {
    private String name;
    private String industry;
    private int foundingYear;
    private String location;
    private ArrayList<String> products;
    private ArrayList<String> services;
    private ArrayList<JobListing> jobs;
    private ArrayList<Integer> employees;
    private ArrayList<Project> currentProjects;
    private ArrayList<Project> pastProjects;
    private ArrayList<Resource> courses;
    private ArrayList<Resource> tutorials;
    private ArrayList<Resource> documentations;
    private double revenue;

    public Company(String name, String industry, int foundingYear, String location) {
        this.name = name;
        this.industry = industry;
        this.foundingYear = foundingYear;
        this.location = location;
        this.products = new ArrayList<>();
        this.services = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
        this.pastProjects = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.tutorials = new ArrayList<>();
        this.documentations = new ArrayList<>();
        this.revenue = 0.0;
    }

    // Getters and Setters for the attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    public void addProduct(String product) {
        this.products.add(product);
    }
    public void removeProduct(String product) {
        this.products.remove(product);
    }

    public ArrayList<String> getServices() {
        return services;
    }

    public void addService(String service) {
        this.services.add(service);
    }
    public void removeService(String service) {
        this.services.remove(service);
    }

    public ArrayList<JobListing> getJobs() {
        return jobs;
    }

    public void addJob(JobListing job) {
        this.jobs.add(job);
    }
    public void removeJob(int job_index) {
        if(job_index >= 0 && job_index < jobs.size()) {
            this.jobs.remove(job_index);
        }
    }

    public ArrayList<Integer> getEmployees() {
        return employees;
    }

    public void addEmployee(int employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(int employee) {
        this.employees.remove(employee);
    }

    public ArrayList<Project> getCurrentProjects() {
        return currentProjects;
    }

    public void addCurrentProject(Project project) {
        this.currentProjects.add(project);
    }
    public void removeCurrentProject(int project_index) {
        if(project_index >= 0 && project_index < currentProjects.size()) {
            this.currentProjects.remove(project_index);
        }
    }

    public ArrayList<Project> getPastProjects() {
        return pastProjects;
    }

    public void addPastProject(Project project) {
        this.pastProjects.add(project);
    }
    public void removePastProject(int project_index) {
        if(project_index >= 0 && project_index < pastProjects.size()){
            this.pastProjects.remove(project_index);
        }
    }

    public ArrayList<Resource> getCourses() {
        return courses;
    }

    public void addCourse(Resource course) {
        this.courses.add(course);
    }
    public void removeCourse(int course_index) {
        if(course_index >= 0 && course_index < courses.size()) {
            this.courses.remove(course_index);
        }
    }

    public ArrayList<Resource> getTutorials() {
        return tutorials;
    }

    public void addTutorial(Resource tutorial) {
        this.tutorials.add(tutorial);
    }
    public void removeTutorial(int tutorial_index) {
        if(tutorial_index >= 0 && tutorial_index < tutorials.size()) {
            this.tutorials.remove(tutorial_index);
        }
    }

    public ArrayList<Resource> getDocumentations() {
        return documentations;
    }

    public void addDocumentation(Resource documentation) {
        this.documentations.add(documentation);
    }
    public void removeDocumentation(int documentation_index) {
        if(documentation_index >= 0 && documentation_index < documentations.size()){
            this.documentations.remove(documentation_index);
        }
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        String result = "";
        result += this.getName();
        result += " | ";
        result += this.getLocation();
        result += " | ";
        result += this.getIndustry();
        return result;
    }

    public void printCompanyDetails(){
        System.out.println(this.getName() + ": ");
        System.out.println("\t Industry: " + this.getIndustry());
        System.out.println("\t Location: " + this.getLocation());
        System.out.println("\t Year of Founding: " + this.getFoundingYear());
        System.out.println("\t Industry: " + this.getIndustry());
        printProducts();
        printServices();
        printJobs();
        System.out.println("\t Number of Employees: " + getEmployees().size());
        printCurrentProjects();
        printPastProjects();
        printCourses();
        printTutorials();
        printDocumentations();
        System.out.println("\t Revenue: " + getRevenue());
    }

    public void printServices(){
        ArrayList<String> temp = this.getServices();
        int i = 1;
        if(temp.isEmpty()){
            System.out.println("\t Services: None");
        }
        else{
            System.out.println("\t Services: ");
            for (String S : temp){
                System.out.println("\t\t" + i + ") " + S);
                i++;
            }
        }
    }

    public void printProducts(){
        ArrayList<String> temp = this.getProducts();
        int i = 1;
        if(temp.isEmpty()){
            System.out.println("\t Products: None");
        }
        else{
            System.out.println("\t Products: ");
            for (String S : temp){
                System.out.println("\t\t" + i + ") " + S);
                i++;
            }
        }
    }
    public void printJobs(){
        ArrayList<JobListing> temp = this.getJobs();
        int i = 1;
        if(temp.isEmpty()){
            System.out.println("\t Jobs: None");
        }
        else{
            System.out.println("\t Jobs: ");
            for (JobListing J : temp){
                System.out.println("\t\t" + i + ") " + J.getName());
                i++;
            }
        }
    }
     public void printEmployees(){
         ArrayList<Integer> temp = this.getEmployees();
         int i = 1;
         if(temp.isEmpty()){
             System.out.println("\t Employees: None");
         }
         else{
             System.out.println("\t Employees ID: ");
             for (int E : temp){
                 System.out.println("\t\t" + i + ") " + E);
                 i++;
             }
         }
     }
     public void printCurrentProjects(){
         ArrayList<Project> temp = this.getCurrentProjects();
         int i = 1;
         if(temp.isEmpty()){
             System.out.println("\t Projects: None");
         }
         else{
             System.out.println("\t Projects: ");
             for (Project P : temp){
                 System.out.println("\t\t" + i + ") " + P.getName());
                 i++;
             }
         }
     }
     public void printPastProjects(){
         ArrayList<Project> temp = this.getPastProjects();
         int i = 1;
         if(temp.isEmpty()){
             System.out.println("\t Past Projects: None");
         }
         else{
             System.out.println("\t Past Projects: ");
             for (Project P : temp){
                 System.out.println("\t\t" + i + ") " + P.getName());
                 i++;
             }
         }
     }

     public void printCourses(){
         ArrayList<Resource> temp = this.getCourses();
         int i = 1;
         if(temp.isEmpty()){
             System.out.println("\t Courses: None");
         }
         else{
             System.out.println("\t Courses: ");
             for (Resource R : temp){
                 System.out.println("\t\t" + i + ") " + R.getName());
                 i++;
             }
         }
     }
    public void printTutorials(){
        ArrayList<Resource> temp = this.getTutorials();
        int i = 1;
        if(temp.isEmpty()){
            System.out.println("\t Tutorials: None");
        }
        else{
            System.out.println("\t Tutorials: ");
            for (Resource R : temp){
                System.out.println("\t\t" + i + ") " + R.getName());
                i++;
            }
        }
    }
    public void printDocumentations(){
        ArrayList<Resource> temp = this.getDocumentations();
        int i = 1;
        if(temp.isEmpty()){
            System.out.println("\t Documentations: None");
        }
        else{
            System.out.println("\t Documentations: ");
            for (Resource R : temp){
                System.out.println("\t\t" + i + ") " + R.getName());
                i++;
            }
        }
    }

    public void completeCurrentProject(int p_index){
        Project temp = this.currentProjects.get(p_index);
        removeCurrentProject(p_index);
        addPastProject(temp);
        revenue += temp.getRevenue();
    }
}