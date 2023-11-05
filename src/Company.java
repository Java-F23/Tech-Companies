import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
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
    private BigDecimal revenue;

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
        this.revenue = new BigDecimal(0);
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

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
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

    public void printCompanyDetailsUser(JPanel panel, User user, JButton returnbutton) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);

        // Company Name
        JLabel nameLabel = new JLabel("Company Name: " + getName());
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        // Industry
        JLabel industryLabel = new JLabel("Industry: " + getIndustry());
        constraints.gridy = 1;
        panel.add(industryLabel, constraints);

        // Location
        JLabel locationLabel = new JLabel("Location: " + getLocation());
        constraints.gridy = 2;
        panel.add(locationLabel, constraints);

        // Year of Founding
        JLabel foundingYearLabel = new JLabel("Year of Founding: " + getFoundingYear());
        constraints.gridy = 3;
        panel.add(foundingYearLabel, constraints);

        // Products Button
        JButton productsButton = new JButton("Products");
        productsButton.addActionListener(e -> printProductsUser(panel, user, returnbutton));
        constraints.gridy = 4;
        panel.add(productsButton, constraints);

        // Services Button
        JButton servicesButton = new JButton("Services");
        servicesButton.addActionListener(e -> printServicesUser(panel, user, returnbutton));
        constraints.gridy = 5;
        panel.add(servicesButton, constraints);

        // Jobs Button
        JButton jobsButton = new JButton("Jobs");
        jobsButton.addActionListener(e -> printJobsUser(panel,user, returnbutton));
        constraints.gridy = 6;
        panel.add(jobsButton, constraints);

        // Number of Employees
        JLabel employeesLabel = new JLabel("Number of Employees: " + getEmployees().size());
        constraints.gridy = 7;
        panel.add(employeesLabel, constraints);

        // Current Projects Button
        JButton currentProjectsButton = new JButton("Current Projects");
        currentProjectsButton.addActionListener(e -> printCurrentProjectsUser(panel,user, returnbutton));
        constraints.gridy = 8;
        panel.add(currentProjectsButton, constraints);

        // Past Projects Button
        JButton pastProjectsButton = new JButton("Past Projects");
        pastProjectsButton.addActionListener(e -> printPastProjectsUser(panel,user, returnbutton));
        constraints.gridy = 9;
        panel.add(pastProjectsButton, constraints);

        // Courses Button
        JButton coursesButton = new JButton("Courses");
        coursesButton.addActionListener(e -> printCoursesUser(panel,user, returnbutton));
        constraints.gridy = 10;
        panel.add(coursesButton, constraints);

        // Tutorials Button
        JButton tutorialsButton = new JButton("Tutorials");
        tutorialsButton.addActionListener(e -> printTutorialsUser(panel,user, returnbutton));
        constraints.gridy = 11;
        panel.add(tutorialsButton, constraints);

        // Documentations Button
        JButton documentationsButton = new JButton("Documentations");
        documentationsButton.addActionListener(e -> printDocumentationsUser(panel,user, returnbutton));
        constraints.gridy = 12;
        panel.add(documentationsButton, constraints);

        // Revenue
        JLabel revenueLabel = new JLabel("Revenue: " + getRevenue());
        constraints.gridy = 13;
        panel.add(revenueLabel, constraints);
        constraints.gridy = 14;
        panel.add(returnbutton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printServicesUser(JPanel panel, User user, JButton returnbutton) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<String> temp = this.getServices();
        if (temp.isEmpty()) {
            JLabel label = new JLabel("Services: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Services:");
            panel.add(label,constraints);

            for (String S : temp) {
                constraints.gridy++;
                JLabel serviceLabel = new JLabel(S);
                panel.add(serviceLabel,constraints);
            }
        }

        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printProductsUser(JPanel panel, User user, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<String> products = this.getProducts();
        if (products.isEmpty()) {
            JLabel label = new JLabel("Products: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Products:");
            panel.add(label, constraints);

            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + product);
                constraints.gridy++;
                panel.add(productLabel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printJobsUser(JPanel panel, User user, JButton returnbutton){
        ArrayList<JobListing> temp = this.getJobs();
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        if (temp.isEmpty()) {
            JLabel label = new JLabel("Jobs: None");
            panel.add(label, constraints);
        } else {
            JLabel titleLabel = new JLabel("Jobs:");
            panel.add(titleLabel, constraints);

            for (JobListing J : temp) {
                JPanel jobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel jobLabel = new JLabel("\t" + J.getName());
                jobPanel.add(jobLabel);

                // Create a new Apply button for each job listing
                JButton applyButton = new JButton("Apply");
                applyButton.addActionListener(e -> {
                    // Call the function for applying here
                    J.addApplicant(user);
                });
                jobPanel.add(applyButton);
                constraints.gridy++;
                panel.add(jobPanel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton, constraints);

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
     public void printCurrentProjectsUser(JPanel panel, User user, JButton returnbutton){
         panel.removeAll();
         panel.setLayout(new GridBagLayout());
         GridBagConstraints constraints = new GridBagConstraints();
         constraints.anchor = GridBagConstraints.CENTER;
         constraints.insets = new Insets(5,5,5,5);
         constraints.gridy = 0;

         ArrayList<Project> projects = this.getCurrentProjects();
         if (projects.isEmpty()) {
             JLabel label = new JLabel("Current Projects: None");
             panel.add(label, constraints);
         } else {
             JLabel label = new JLabel("Current Projects:");
             panel.add(label, constraints);

             for (int i = 0; i < projects.size(); i++) {
                 Project project = projects.get(i);
                 JLabel productLabel = new JLabel((i + 1) + ") " + project.getID() + " | " + project.getName());
                 constraints.gridy++;
                 panel.add(productLabel, constraints);
             }
         }
         JButton returnButton = new JButton("Return");
         returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
         constraints.gridy++;
         panel.add(returnButton, constraints);

         panel.revalidate();
         panel.repaint();
     }
    public void printPastProjectsUser(JPanel panel, User user, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Project> projects = this.getPastProjects();
        if (projects.isEmpty()) {
            JLabel label = new JLabel("Past Projects: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Past Projects:");
            panel.add(label, constraints);

            for (int i = 0; i < projects.size(); i++) {
                Project project = projects.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + project.getID() + " | " + project.getName());
                constraints.gridy++;
                panel.add(productLabel,constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printCoursesUser(JPanel panel, User user, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Resource> courses = this.getCourses();
        if (courses.isEmpty()) {
            JLabel label = new JLabel("Courses: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Courses:");
            panel.add(label, constraints);

            for (int i = 0; i < courses.size(); i++) {
                Resource course = courses.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + course.getName() + " : " + course.getDescription() + "| Find it at: " + course.getLink());
                constraints.gridy++;
                panel.add(productLabel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printTutorialsUser(JPanel panel, User user, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Resource> tutorials = this.getTutorials();
        if (tutorials.isEmpty()) {
            JLabel label = new JLabel("Tutorials: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Tutorials:");
            panel.add(label, constraints);

            for (int i = 0; i < tutorials.size(); i++) {
                Resource tutorial = tutorials.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + tutorial.getName() + " : " + tutorial.getDescription() + "| Find it at: " + tutorial.getLink());
                constraints.gridy++;
                panel.add(productLabel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printDocumentationsUser(JPanel panel, User user, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Resource> docs = this.getDocumentations();
        if (docs.isEmpty()) {
            JLabel label = new JLabel("Documentations: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Documentations:");
            panel.add(label, constraints);

            for (int i = 0; i < docs.size(); i++) {
                Resource doc = docs.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + doc.getName() + " : " + doc.getDescription() + "| Find it at: " + doc.getLink());
                constraints.gridy++;
                panel.add(productLabel,constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(panel, user, returnbutton));
        constraints.gridy++;
        panel.add(returnButton,constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void completeCurrentProject(int p_index){
        Project temp = this.currentProjects.get(p_index);
        removeCurrentProject(p_index);
        addPastProject(temp);
        revenue = revenue.add(temp.getRevenue());
    }

    public void printCompanyDetailsAdmin(JPanel panel, JButton returnbutton) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);

        // Company Name
        JLabel nameLabel = new JLabel("Company Name: " + getName());
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        // Edit Button for Company Name
        JButton editNameButton = new JButton("Edit");
        editNameButton.addActionListener(e -> editCompanyName(panel, returnbutton));
        constraints.gridx = 1; // Place the button in the next column
        panel.add(editNameButton, constraints);

        // Industry
        JLabel industryLabel = new JLabel("Industry: " + getIndustry());
        constraints.gridy = 1;
        constraints.gridx = 0; // Reset column to 0
        panel.add(industryLabel, constraints);

        // Edit Button for Industry
        JButton editIndustryButton = new JButton("Edit");
        editIndustryButton.addActionListener(e -> editIndustry(panel, returnbutton));
        constraints.gridx = 1;
        panel.add(editIndustryButton, constraints);

        // Location
        JLabel locationLabel = new JLabel("Location: " + getLocation());
        constraints.gridy = 2;
        constraints.gridx = 0; // Reset column to 0
        panel.add(locationLabel, constraints);

        // Edit Button for Location
        JButton editLocationButton = new JButton("Edit");
        editLocationButton.addActionListener(e -> editLocation(panel, returnbutton));
        constraints.gridx = 1;
        panel.add(editLocationButton, constraints);
        constraints.gridx = 0; // Reset column to 0

        // Year of Founding
        JLabel foundingYearLabel = new JLabel("Year of Founding: " + getFoundingYear());
        constraints.gridy = 3;
        panel.add(foundingYearLabel, constraints);

        // Edit Button for Year
        JButton editYearButton = new JButton("Edit");
        editYearButton.addActionListener(e -> editYear(panel, returnbutton));
        constraints.gridx = 1;
        panel.add(editYearButton, constraints);
        constraints.gridx = 0; // Reset column to 0

        // Products Button
        JButton productsButton = new JButton("Products");
        productsButton.addActionListener(e -> printProductsAdmin(panel, returnbutton));
        constraints.gridy = 4;
        panel.add(productsButton, constraints);

        // Services Button
        JButton servicesButton = new JButton("Services");
        servicesButton.addActionListener(e -> printServicesAdmin(panel, returnbutton));
        constraints.gridy = 5;
        panel.add(servicesButton, constraints);

        // Jobs Button
        JButton jobsButton = new JButton("Jobs");
        jobsButton.addActionListener(e -> printJobsAdmin(panel, returnbutton));
        constraints.gridy = 6;
        panel.add(jobsButton, constraints);

        // Number of Employees
        JLabel employeesLabel = new JLabel("Number of Employees: " + getEmployees().size());
        constraints.gridy = 7;
        panel.add(employeesLabel, constraints);

        // Edit Button for Employees
        JButton editEmployeesButton = new JButton("Edit");
        //editEmployeesButton.addActionListener(e -> manageEmployees(panel, returnbutton));
        constraints.gridx = 1;
        panel.add(editEmployeesButton, constraints);
        constraints.gridx = 0; // Reset column to 0

        // Current Projects Button
        JButton currentProjectsButton = new JButton("Current Projects");
        currentProjectsButton.addActionListener(e -> printCurrentProjectsAdmin(panel, returnbutton));
        constraints.gridy = 8;
        panel.add(currentProjectsButton, constraints);

        // Past Projects Button
        JButton pastProjectsButton = new JButton("Past Projects");
        pastProjectsButton.addActionListener(e -> printPastProjectsAdmin(panel, returnbutton));
        constraints.gridy = 9;
        panel.add(pastProjectsButton, constraints);

        // Courses Button
        JButton coursesButton = new JButton("Courses");
        coursesButton.addActionListener(e -> printCoursesAdmin(panel, returnbutton));
        constraints.gridy = 10;
        panel.add(coursesButton, constraints);

        // Tutorials Button
        JButton tutorialsButton = new JButton("Tutorials");
        tutorialsButton.addActionListener(e -> printTutorialsAdmin(panel, returnbutton));
        constraints.gridy = 11;
        panel.add(tutorialsButton, constraints);

        // Documentations Button
        JButton documentationsButton = new JButton("Documentations");
        documentationsButton.addActionListener(e -> printDocumentationsAdmin(panel, returnbutton));
        constraints.gridy = 12;
        panel.add(documentationsButton, constraints);

        // Revenue
        JLabel revenueLabel = new JLabel("Revenue: " + getRevenue());
        constraints.gridy = 13;
        panel.add(revenueLabel, constraints);
        constraints.gridy = 14;
        panel.add(returnbutton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    private void editCompanyName(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = e.getActionCommand();
                if (name == null) {
                    printCompanyDetailsAdmin(panel, returnbutton);
                } else {
                    setName(name);
                    JOptionPane.showMessageDialog(null, "Name Changed");
                    printCompanyDetailsAdmin(panel, returnbutton);
                }
            }
        };

        TextEntryWindow nameWindow = new TextEntryWindow("New Name of the Company", textEnteredListener);
    }

    private void editLocation(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(panel, returnbutton);
                } else {
                    setLocation(input);
                    JOptionPane.showMessageDialog(null, "Location Changed");
                    printCompanyDetailsAdmin(panel, returnbutton);
                }
            }
        };

        TextEntryWindow window = new TextEntryWindow("New Location of the Company", textEnteredListener);
    }

    private void editIndustry(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(panel, returnbutton);
                } else {
                    setIndustry(input);
                    JOptionPane.showMessageDialog(null, "Industry Changed");
                    printCompanyDetailsAdmin(panel, returnbutton);
                }
            }
        };

        TextEntryWindow window = new TextEntryWindow("New Industry of the Company", textEnteredListener);
    }
    private void editYear(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(panel, returnbutton);
                } else {
                    setFoundingYear(Integer.parseInt(input));
                    JOptionPane.showMessageDialog(null, "Year of Foundation Changed");
                    printCompanyDetailsAdmin(panel, returnbutton);
                }
            }
        };

        IntEntryWindow window = new IntEntryWindow("New Year of Foundation", textEnteredListener);
    }


    public void printServicesAdmin(JPanel panel, JButton returnbutton) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<String> temp = this.getServices();
        if (temp.isEmpty()) {
            JLabel label = new JLabel("Services: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Services:");
            panel.add(label,constraints);

            for (String S : temp) {
                constraints.gridy++;
                JLabel serviceLabel = new JLabel(S);
                panel.add(serviceLabel,constraints);
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       removeService(S);
                       JOptionPane.showMessageDialog(null, "Service Removed");
                       printServicesAdmin(panel,returnbutton);
                   }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
            }
        }

        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input = e.getActionCommand();
                        if (input == null) {
                            printServicesAdmin(panel, returnbutton);
                        } else {
                            addService(input);
                            JOptionPane.showMessageDialog(null, "Service Added");
                            printServicesAdmin(panel, returnbutton);
                        }
                    }
                };

                TextEntryWindow window = new TextEntryWindow("New Service", textEnteredListener);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printProductsAdmin(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<String> products = this.getProducts();
        if (products.isEmpty()) {
            JLabel label = new JLabel("Products: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Products:");
            panel.add(label, constraints);

            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + product);
                constraints.gridy++;
                panel.add(productLabel, constraints);
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeProduct(product);
                        JOptionPane.showMessageDialog(null, "Product Removed");
                        printProductsAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
            }
        }

        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input = e.getActionCommand();
                        if (input == null) {
                            printProductsAdmin(panel, returnbutton);
                        } else {
                            addProduct(input);
                            JOptionPane.showMessageDialog(null, "Product Added");
                            printProductsAdmin(panel, returnbutton);
                        }
                    }
                };

                TextEntryWindow window = new TextEntryWindow("New Product", textEnteredListener);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printJobsAdmin(JPanel panel, JButton returnbutton){
        ArrayList<JobListing> temp = this.getJobs();
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        if (temp.isEmpty()) {
            JLabel label = new JLabel("Jobs: None");
            panel.add(label, constraints);
        } else {
            JLabel titleLabel = new JLabel("Jobs:");
            panel.add(titleLabel, constraints);

            for (int i = 0; i < temp.size(); i++) {
                JobListing J = temp.get(i);
                JLabel jobLabel = new JLabel(J.getName());
                constraints.gridy++;
                panel.add(jobLabel);

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeJob(temp.indexOf(J));
                        JOptionPane.showMessageDialog(null, "Job Listing Removed");
                        printJobsAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);

                JButton manageButton = new JButton("Manage");
                //manageButton.addActionListener(e -> manageJob(panel,returnbutton,J));
                constraints.gridx++;
                panel.add(manageButton,constraints);
                constraints.gridx--;
            }
        }

        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input1 = e.getActionCommand();
                        if (input1 == null) {
                            printJobsAdmin(panel, returnbutton);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printJobsAdmin(panel, returnbutton);
                                    } else {
                                        addJob(new JobListing(input1, input2));
                                        JOptionPane.showMessageDialog(null, "Job Listing Added");
                                        printJobsAdmin(panel, returnbutton);
                                    }
                                }
                            };

                            TextEntryWindow window2 = new TextEntryWindow("Job Description", textEnteredListener2);
                        }
                    }
                };

                TextEntryWindow window1 = new TextEntryWindow("Job Name", textEnteredListener1);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void manageEmployees(){
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
    public void printCurrentProjectsAdmin(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Project> projects = this.getCurrentProjects();
        if (projects.isEmpty()) {
            JLabel label = new JLabel("Current Projects: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Current Projects:");
            panel.add(label, constraints);

            for (int i = 0; i < projects.size(); i++) {
                Project project = projects.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + project.getID() + " | " + project.getName() + " | Progress: " + project.getProgress() + " | Revenue: " + project.getRevenue());
                constraints.gridy++;
                panel.add(productLabel, constraints);
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeCurrentProject(projects.indexOf(project));
                        JOptionPane.showMessageDialog(null, "Project Removed");
                        printCurrentProjectsAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);

                JButton manageButton = new JButton("Update Progress");
                manageButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.removeAll();
                        panel.revalidate();
                        panel.repaint();
                        ActionListener textEnteredListener1 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String input = e.getActionCommand();
                                if (input == null) {
                                    printCurrentProjectsAdmin(panel, returnbutton);
                                } else {
                                    int prog = Integer.parseInt(input);
                                    if(prog >= 100){
                                        project.setProgress(100);
                                        completeCurrentProject(projects.indexOf(project));
                                        JOptionPane.showMessageDialog(null, "Project Completed");
                                        printCurrentProjectsAdmin(panel,returnbutton);
                                    }
                                    else if(prog <= 0){
                                        project.setProgress(0);
                                        JOptionPane.showMessageDialog(null, "Project Reset");
                                        printCurrentProjectsAdmin(panel,returnbutton);
                                    }
                                    else{
                                        project.setProgress(prog);
                                        JOptionPane.showMessageDialog(null, "Project Updated");
                                        printCurrentProjectsAdmin(panel,returnbutton);
                                    }
                                }
                            }
                        };
                        IntEntryWindow window1 = new IntEntryWindow("Current Progress (>= 100 means it's completed)", textEnteredListener1);
                    }
                });
                constraints.gridx++;
                panel.add(manageButton,constraints);
                constraints.gridx--;
            }
        }

        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input1 = e.getActionCommand();
                        if (input1 == null) {
                            printCurrentProjectsAdmin(panel, returnbutton);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printCurrentProjectsAdmin(panel, returnbutton);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printCurrentProjectsAdmin(panel, returnbutton);
                                                } else {
                                                    ActionListener textEnteredListener4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            String input4 = e.getActionCommand();
                                                            if (input4 == null) {
                                                                printCurrentProjectsAdmin(panel, returnbutton);
                                                            } else {
                                                                addCurrentProject(new Project(Integer.parseInt(input3),input1,input2,new BigDecimal(Integer.parseInt(input4))));
                                                                JOptionPane.showMessageDialog(null, "Project Added");
                                                                printCurrentProjectsAdmin(panel,returnbutton);
                                                            }
                                                        }
                                                    };

                                                    IntEntryWindow window4 = new IntEntryWindow("Project Revenue", textEnteredListener4);
                                                }
                                            }
                                        };

                                        IntEntryWindow window3 = new IntEntryWindow("Project ID", textEnteredListener3);
                                    }
                                }
                            };

                            TextEntryWindow window2 = new TextEntryWindow("Project Description", textEnteredListener2);
                        }
                    }
                };

                TextEntryWindow window1 = new TextEntryWindow("Project Name", textEnteredListener1);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printPastProjectsAdmin(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Project> projects = this.getPastProjects();
        if (projects.isEmpty()) {
            JLabel label = new JLabel("Past Projects: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Past Projects:");
            panel.add(label, constraints);

            for (int i = 0; i < projects.size(); i++) {
                Project project = projects.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + project.getID() + " | " + project.getName() + " | Revenue: " + project.getRevenue());
                constraints.gridy++;
                panel.add(productLabel, constraints);
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removePastProject(projects.indexOf(project));
                        JOptionPane.showMessageDialog(null, "Project Removed");
                        printPastProjectsAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
            }
        }

        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input1 = e.getActionCommand();
                        if (input1 == null) {
                            printPastProjectsAdmin(panel, returnbutton);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printPastProjectsAdmin(panel, returnbutton);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printPastProjectsAdmin(panel, returnbutton);
                                                } else {
                                                    ActionListener textEnteredListener4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            String input4 = e.getActionCommand();
                                                            if (input4 == null) {
                                                                printPastProjectsAdmin(panel, returnbutton);
                                                            } else {
                                                                addPastProject(new Project(Integer.parseInt(input3),input1,input2,new BigDecimal(Integer.parseInt(input4))));
                                                                JOptionPane.showMessageDialog(null, "Project Added");
                                                                printPastProjectsAdmin(panel,returnbutton);
                                                            }
                                                        }
                                                    };

                                                    IntEntryWindow window4 = new IntEntryWindow("Project Revenue", textEnteredListener4);
                                                }
                                            }
                                        };

                                        IntEntryWindow window3 = new IntEntryWindow("Project ID", textEnteredListener3);
                                    }
                                }
                            };

                            TextEntryWindow window2 = new TextEntryWindow("Project Description", textEnteredListener2);
                        }
                    }
                };

                TextEntryWindow window1 = new TextEntryWindow("Project Name", textEnteredListener1);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printCoursesAdmin(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Resource> courses = this.getCourses();
        if (courses.isEmpty()) {
            JLabel label = new JLabel("Courses: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Courses:");
            panel.add(label, constraints);

            for (int i = 0; i < courses.size(); i++) {
                Resource course = courses.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + course.getName() + " : " + course.getDescription() + "| Find it at: " + course.getLink());
                constraints.gridy++;
                panel.add(productLabel, constraints);
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeCourse(courses.indexOf(course));
                        JOptionPane.showMessageDialog(null, "Resource Removed");
                        printCoursesAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
            }
        }
        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input1 = e.getActionCommand();
                        if (input1 == null) {
                            printCoursesAdmin(panel, returnbutton);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printCoursesAdmin(panel, returnbutton);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printCoursesAdmin(panel, returnbutton);
                                                } else {
                                                    addCourse(new Resource(input1, input2, input3));
                                                    JOptionPane.showMessageDialog(null, "Resource Added");
                                                    printCoursesAdmin(panel, returnbutton);
                                                }
                                            }
                                        };

                                        TextEntryWindow window3 = new TextEntryWindow("Resource Link", textEnteredListener3);
                                    }
                                }
                            };

                            TextEntryWindow window2 = new TextEntryWindow("Resource Description", textEnteredListener2);
                        }
                    }
                };

                TextEntryWindow window1 = new TextEntryWindow("Resource Name", textEnteredListener1);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printTutorialsAdmin(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Resource> tutorials = this.getTutorials();
        if (tutorials.isEmpty()) {
            JLabel label = new JLabel("Tutorials: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Tutorials:");
            panel.add(label, constraints);

            for (int i = 0; i < tutorials.size(); i++) {
                Resource tutorial = tutorials.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + tutorial.getName() + " : " + tutorial.getDescription() + "\n\\t Find it at: " + tutorial.getLink());
                constraints.gridy++;
                panel.add(productLabel, constraints);

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeCourse(tutorials.indexOf(tutorial));
                        JOptionPane.showMessageDialog(null, "Resource Removed");
                        printTutorialsAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
            }
        }
        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input1 = e.getActionCommand();
                        if (input1 == null) {
                            printTutorialsAdmin(panel, returnbutton);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printTutorialsAdmin(panel, returnbutton);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printTutorialsAdmin(panel, returnbutton);
                                                } else {
                                                    addTutorial(new Resource(input1, input2, input3));
                                                    JOptionPane.showMessageDialog(null, "Resource Added");
                                                    printTutorialsAdmin(panel, returnbutton);
                                                }
                                            }
                                        };

                                        TextEntryWindow window3 = new TextEntryWindow("Resource Link", textEnteredListener3);
                                    }
                                }
                            };

                            TextEntryWindow window2 = new TextEntryWindow("Resource Description", textEnteredListener2);
                        }
                    }
                };

                TextEntryWindow window1 = new TextEntryWindow("Resource Name", textEnteredListener1);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printDocumentationsAdmin(JPanel panel, JButton returnbutton){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Resource> docs = this.getDocumentations();
        if (docs.isEmpty()) {
            JLabel label = new JLabel("Documentations: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Documentations:");
            panel.add(label, constraints);

            for (int i = 0; i < docs.size(); i++) {
                Resource doc = docs.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + doc.getName() + " : " + doc.getDescription() + "\n\\t Find it at: " + doc.getLink());
                constraints.gridy++;
                panel.add(productLabel,constraints);

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeCourse(docs.indexOf(doc));
                        JOptionPane.showMessageDialog(null, "Resource Removed");
                        printDocumentationsAdmin(panel,returnbutton);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
            }
        }
        JButton addButton = new JButton("Add new");
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                panel.revalidate();
                panel.repaint();
                ActionListener textEnteredListener1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input1 = e.getActionCommand();
                        if (input1 == null) {
                            printDocumentationsAdmin(panel, returnbutton);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printDocumentationsAdmin(panel, returnbutton);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printDocumentationsAdmin(panel, returnbutton);
                                                } else {
                                                    addDocumentation(new Resource(input1, input2, input3));
                                                    JOptionPane.showMessageDialog(null, "Resource Added");
                                                    printDocumentationsAdmin(panel, returnbutton);
                                                }
                                            }
                                        };

                                        TextEntryWindow window3 = new TextEntryWindow("Resource Link", textEnteredListener3);
                                    }
                                }
                            };

                            TextEntryWindow window2 = new TextEntryWindow("Resource Description", textEnteredListener2);
                        }
                    }
                };

                TextEntryWindow window1 = new TextEntryWindow("Resource Name", textEnteredListener1);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(panel, returnbutton));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
}