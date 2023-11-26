
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Company implements Serializable {
    private String name;
    private String industry;
    private int foundingYear;
    private String location;
    private TreeSet<String> products;
    private TreeSet<String> services;
    private ArrayList<JobListing> jobs;
    private ArrayList<Integer> employees;
    private ArrayList<Project> currentProjects;
    private ArrayList<Project> pastProjects;
    private ArrayList<Course> courses;
    private ArrayList<Tutorial> tutorials;
    private ArrayList<Documentation> documentations;
    private BigDecimal revenue;

    //Initializes all the above fields
    public Company(String name, String industry, int foundingYear, String location) {
        this.name = name;
        this.industry = industry;
        this.foundingYear = foundingYear;
        this.location = location;
        this.products = new TreeSet<>();
        this.services = new TreeSet<>();
        this.jobs = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
        this.pastProjects = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.tutorials = new ArrayList<>();
        this.documentations = new ArrayList<>();
        this.revenue = new BigDecimal(0);
    }
    //default constructor needed for serialization
    public Company(){}

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

    public TreeSet<String> getProducts() {
        return products;
    }

    public void addProduct(String product) {
        this.products.add(product);
    }
    public void removeProduct(String product) {
        this.products.remove(product);
    }

    public TreeSet<String> getServices() {
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
    public void removeCourse(int course_index) {
        if(course_index >= 0 && course_index < courses.size()) {
            this.courses.remove(course_index);
        }
    }

    public ArrayList<Tutorial> getTutorials() {
        return tutorials;
    }

    public void addTutorial(Tutorial tutorial) {
        this.tutorials.add(tutorial);
    }
    public void removeTutorial(int tutorial_index) {
        if(tutorial_index >= 0 && tutorial_index < tutorials.size()) {
            this.tutorials.remove(tutorial_index);
        }
    }

    public ArrayList<Documentation> getDocumentations() {
        return documentations;
    }

    public void addDocumentation(Documentation documentation) {
        this.documentations.add(documentation);
    }
    public void removeDocumentation(int documentation_index) {
        if(documentation_index >= 0 && documentation_index < documentations.size()){
            this.documentations.remove(documentation_index);
        }
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    //Returns a string summary of the company
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

    //Moves a project from current projects to past ones
    public void completeCurrentProject(int p_index){
        Project temp = this.currentProjects.get(p_index);
        removeCurrentProject(p_index);
        addPastProject(temp);
        revenue = revenue.add(temp.getRevenue());
    }
}