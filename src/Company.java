import java.util.ArrayList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
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

    public void printCompanyDetails(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Company Name
        JLabel nameLabel = new JLabel("Company Name: " + getName());
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        // Industry
        JLabel industryLabel = new JLabel("Industry: " + getIndustry());
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(industryLabel, constraints);

        // Location
        JLabel locationLabel = new JLabel("Location: " + getLocation());
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(locationLabel, constraints);

        // Year of Founding
        JLabel foundingYearLabel = new JLabel("Year of Founding: " + getFoundingYear());
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(foundingYearLabel, constraints);

        // Products Button
        JButton productsButton = new JButton("Products");
        productsButton.addActionListener(e -> printProducts(panel));
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(productsButton, constraints);

        // Services Button
        JButton servicesButton = new JButton("Services");
        servicesButton.addActionListener(e -> printServices(panel));
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(servicesButton, constraints);

        // Jobs Button
        JButton jobsButton = new JButton("Jobs");
        jobsButton.addActionListener(e -> printJobs(panel));
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(jobsButton, constraints);

        // Number of Employees
        JLabel employeesLabel = new JLabel("Number of Employees: " + getEmployees().size());
        constraints.gridx = 0;
        constraints.gridy = 7;
        panel.add(employeesLabel, constraints);

        // Current Projects Button
        JButton currentProjectsButton = new JButton("Current Projects");
        currentProjectsButton.addActionListener(e -> printCurrentProjects());
        constraints.gridx = 0;
        constraints.gridy = 8;
        panel.add(currentProjectsButton, constraints);

        // Past Projects Button
        JButton pastProjectsButton = new JButton("Past Projects");
        pastProjectsButton.addActionListener(e -> printPastProjects());
        constraints.gridx = 0;
        constraints.gridy = 9;
        panel.add(pastProjectsButton, constraints);

        // Courses Button
        JButton coursesButton = new JButton("Courses");
        coursesButton.addActionListener(e -> printCourses());
        constraints.gridx = 0;
        constraints.gridy = 10;
        panel.add(coursesButton, constraints);

        // Tutorials Button
        JButton tutorialsButton = new JButton("Tutorials");
        tutorialsButton.addActionListener(e -> printTutorials());
        constraints.gridx = 0;
        constraints.gridy = 11;
        panel.add(tutorialsButton, constraints);

        // Documentations Button
        JButton documentationsButton = new JButton("Documentations");
        documentationsButton.addActionListener(e -> printDocumentations());
        constraints.gridx = 0;
        constraints.gridy = 12;
        panel.add(documentationsButton, constraints);

        // Revenue
        JLabel revenueLabel = new JLabel("Revenue: " + getRevenue());
        constraints.gridx = 0;
        constraints.gridy = 13;
        panel.add(revenueLabel, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printServices(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ArrayList<String> temp = this.getServices();
        if (temp.isEmpty()) {
            JLabel label = new JLabel("Services: None");
            panel.add(label);
        } else {
            JLabel label = new JLabel("Services:");
            panel.add(label);

            for (String S : temp) {
                JLabel serviceLabel = new JLabel(S);
                panel.add(serviceLabel);
            }
        }

        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetails(panel));
        panel.add(returnButton);

        panel.revalidate();
        panel.repaint();
    }

    public void printProducts(JPanel panel){
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        ArrayList<String> products = this.getProducts();
        if (products.isEmpty()) {
            JLabel label = new JLabel("Products: None");
            panel.add(label);
        } else {
            JLabel label = new JLabel("Products:");
            panel.add(label);

            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + product);
                panel.add(productLabel);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetails(panel));
        panel.add(returnButton);

        panel.revalidate();
        panel.repaint();
    }
    public void printJobs(JPanel panel){
        ArrayList<JobListing> temp = this.getJobs();
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        if (temp.isEmpty()) {
            JLabel label = new JLabel("Jobs: None");
            panel.add(label);
        } else {
            JLabel titleLabel = new JLabel("Jobs:");
            panel.add(titleLabel);

            for (JobListing J : temp) {
                JLabel jobLabel = new JLabel("\t" + J.getName());
                panel.add(jobLabel);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetails(panel));
        panel.add(returnButton);

        panel.revalidate();
        panel.repaint();
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