import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class UserBoard_UI {
    private View view;
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollpanel;
    private JPanel showAllCompaniesPanel;
    private JPanel companyDetailsPanel;
    private JButton returnbutton;

    public UserBoard_UI(View view) {
        this.view = view;
        frame = new JFrame("UserBoard");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel
        panel = new JPanel();

        // Add panel to frame and display
        scrollpanel = new JScrollPane(panel);
        scrollpanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpanel.setBounds(50, 30, 300, 50);
        frame.add(scrollpanel);

        showOptions();
    }

    public void showOptions() {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        // Create buttons for each option
        JButton showAllCompaniesButton = new JButton("Show all Companies");
        JButton filterCompaniesByNameButton = new JButton("Filter Companies by name");
        JButton filterCompaniesByIndustryButton = new JButton("Filter Companies by industry");
        JButton filterCompaniesByLocationButton = new JButton("Filter Companies by location");
        JButton showFavouriteCompaniesButton = new JButton("Show Favourite Companies");
        JButton logOutButton = new JButton("Log Out");

        // Add action listeners to each button
        showAllCompaniesButton.addActionListener(e -> showCompanies(view.getCompanies()));
        filterCompaniesByNameButton.addActionListener(e -> searchName());
        filterCompaniesByIndustryButton.addActionListener(e -> searchIndustry());
        filterCompaniesByLocationButton.addActionListener(e -> searchLocation());
        showFavouriteCompaniesButton.addActionListener(e -> showCompanies(view.getCurrentUser().getFavoriteCompanies()));
        logOutButton.addActionListener(e -> logOut());

        // Add buttons to panel
        panel.add(showAllCompaniesButton, constraints);
        constraints.gridy++;
        panel.add(filterCompaniesByNameButton,constraints);
        constraints.gridy++;
        panel.add(filterCompaniesByIndustryButton, constraints);
        constraints.gridy++;
        panel.add(filterCompaniesByLocationButton, constraints);
        constraints.gridy++;
        panel.add(showFavouriteCompaniesButton,constraints);
        constraints.gridy++;
        panel.add(logOutButton,constraints);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void showCompanies(ArrayList<Company> companies) {
        // Create a new JPanel to hold the list of companies
        showAllCompaniesPanel = new JPanel();
        showAllCompaniesPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        // Create a label for each company and add it to the panel
        // Create a button for each company and add it to the panel
        for (Company company :companies) {
            JPanel companyPanel = new JPanel();
            companyPanel.setLayout(new GridLayout());
            JButton companyButton = new JButton(company.getName());
            companyButton.addActionListener(e -> showCompanyDetails(company, companies));
            companyPanel.add(companyButton);
            JButton favButton = new JButton(company.getName());
            // Set the button text based on whether it's a favorite
            updateFavoriteButtonText(company, favButton, view.getCurrentUser());
            // Add an ActionListener to toggle the favorite status and show details
            favButton.addActionListener(e -> {
                toggleFavorite(company, favButton, view.getCurrentUser());
            });
            companyPanel.add(favButton);
            showAllCompaniesPanel.add(companyPanel, constraints);
            constraints.gridy++;
        }

        // Create a return button to go back to the showOptions panel
        returnbutton = new JButton("Return");
        returnbutton.addActionListener(e -> returnToShowOptions());
        showAllCompaniesPanel.add(returnbutton,constraints);

        // Clear the panel and add the showAllCompaniesPanel and returnButton
        panel.removeAll();
        panel.setLayout(new GridLayout());
        panel.add(showAllCompaniesPanel);

        // Repaint the panel
        panel.revalidate();
        panel.repaint();
    }

    public void returnToShowOptions() {
        // Clear the panel and add the showOptions panel
        panel.removeAll();
        showOptions();

        // Repaint the panel
        panel.revalidate();
        panel.repaint();
    }
    public void showCompanyDetails(Company company, ArrayList<Company> companies) {

        // Create a return button to go back to the showAllCompaniesPanel
        returnbutton = new JButton("Return");
        returnbutton.addActionListener(e -> showCompanies(companies));
        printCompanyDetailsUser(company);
    }
    public void searchName() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = e.getActionCommand();
                if (Name == null) {
                    showOptions();
                } else {
                    showCompanies(view.getCompaniesByName(Name));
                }
            }
        };

        TextEntryWindow name = new TextEntryWindow("Name of the company", textEnteredListener);
    }
    public void searchIndustry() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Ind = e.getActionCommand();
                if (Ind == null) {
                    showOptions();
                } else {
                    showCompanies(view.getCompaniesByIndustry(Ind));
                }
            }
        };

        TextEntryWindow name = new TextEntryWindow("Name of the Industry", textEnteredListener);
    }
    public void searchLocation() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loc = e.getActionCommand();
                if (loc == null) {
                    showOptions();
                } else {
                    showCompanies(view.getCompaniesByLocation(loc));
                }
            }
        };

        TextEntryWindow name = new TextEntryWindow("Name of the Location", textEnteredListener);
    }

    private void updateFavoriteButtonText(Company company, JButton button, User user) {
        if (user.getFavoriteCompanies().contains(company)) {
            button.setText("Unstar"); // If it's a favorite, set text to "Unstar"
        } else {
            button.setText("Star"); // If it's not a favorite, set text to "Star"
        }
    }

    private void toggleFavorite(Company company, JButton button, User user) {
        if (user.getFavoriteCompanies().contains(company)) {
            user.removeFavoriteCompany(company);
            button.setText("Star"); // If it's a favorite, set text to "Unstar"
        } else {
            user.addFavoriteCompany(company);
            button.setText("Unstar"); // If it's not a favorite, set text to "Star"
        }
    }

    private void logOut(){
        view.initiate();
        frame.dispose();
    }

    public void printCompanyDetailsUser(Company company) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);

        // Company Name
        JLabel nameLabel = new JLabel("Company Name: " + company.getName());
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        // Industry
        JLabel industryLabel = new JLabel("Industry: " + company.getIndustry());
        constraints.gridy = 1;
        panel.add(industryLabel, constraints);

        // Location
        JLabel locationLabel = new JLabel("Location: " + company.getLocation());
        constraints.gridy = 2;
        panel.add(locationLabel, constraints);

        // Year of Founding
        JLabel foundingYearLabel = new JLabel("Year of Founding: " + company.getFoundingYear());
        constraints.gridy = 3;
        panel.add(foundingYearLabel, constraints);

        // Products Button
        JButton productsButton = new JButton("Products");
        productsButton.addActionListener(e -> printProductsUser(company));
        constraints.gridy = 4;
        panel.add(productsButton, constraints);

        // Services Button
        JButton servicesButton = new JButton("Services");
        servicesButton.addActionListener(e -> printServicesUser(company));
        constraints.gridy = 5;
        panel.add(servicesButton, constraints);

        // Jobs Button
        JButton jobsButton = new JButton("Jobs");
        jobsButton.addActionListener(e -> printJobsUser(company));
        constraints.gridy = 6;
        panel.add(jobsButton, constraints);

        // Number of Employees
        JLabel employeesLabel = new JLabel("Number of Employees: " + company.getEmployees().size());
        constraints.gridy = 7;
        panel.add(employeesLabel, constraints);

        // Current Projects Button
        JButton currentProjectsButton = new JButton("Current Projects");
        currentProjectsButton.addActionListener(e -> printCurrentProjectsUser(company));
        constraints.gridy = 8;
        panel.add(currentProjectsButton, constraints);

        // Past Projects Button
        JButton pastProjectsButton = new JButton("Past Projects");
        pastProjectsButton.addActionListener(e -> printPastProjectsUser(company));
        constraints.gridy = 9;
        panel.add(pastProjectsButton, constraints);

        // Courses Button
        JButton coursesButton = new JButton("Courses");
        coursesButton.addActionListener(e -> printCoursesUser(company));
        constraints.gridy = 10;
        panel.add(coursesButton, constraints);

        // Tutorials Button
        JButton tutorialsButton = new JButton("Tutorials");
        tutorialsButton.addActionListener(e -> printTutorialsUser(company));
        constraints.gridy = 11;
        panel.add(tutorialsButton, constraints);

        // Documentations Button
        JButton documentationsButton = new JButton("Documentations");
        documentationsButton.addActionListener(e -> printDocumentationsUser(company));
        constraints.gridy = 12;
        panel.add(documentationsButton, constraints);

        // Revenue
        JLabel revenueLabel = new JLabel("Revenue: " + company.getRevenue());
        constraints.gridy = 13;
        panel.add(revenueLabel, constraints);
        constraints.gridy = 14;
        panel.add(returnbutton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printServicesUser(Company company) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        TreeSet<String> temp = company.getServices();
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
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printProductsUser(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        TreeSet<String> products = company.getProducts();
        if (products.isEmpty()) {
            JLabel label = new JLabel("Products: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Products:");
            panel.add(label, constraints);
            int i = 0;
            for (String product : products) {
                JLabel productLabel = new JLabel((i + 1) + ") " + product);
                constraints.gridy++;
                i++;
                panel.add(productLabel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printJobsUser(Company company){
        ArrayList<JobListing> temp = company.getJobs();
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
                    J.addApplicant(view.getCurrentUser());
                    view.updateDB();
                });
                jobPanel.add(applyButton);
                constraints.gridy++;
                panel.add(jobPanel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printCurrentProjectsUser(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Project> projects = company.getCurrentProjects();
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
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printPastProjectsUser(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Project> projects = company.getPastProjects();
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
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printCoursesUser(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Course> courses = company.getCourses();
        if (courses.isEmpty()) {
            JLabel label = new JLabel("Courses: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Courses:");
            panel.add(label, constraints);

            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + course.getName() + " : " + course.getDescription() +"| Number of lectures = " + course.getNumber_of_lectures() + " lectures " + "| Find it at: " + course.getLink());
                constraints.gridy++;
                panel.add(productLabel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printTutorialsUser(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Tutorial> tutorials = company.getTutorials();
        if (tutorials.isEmpty()) {
            JLabel label = new JLabel("Tutorials: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Tutorials:");
            panel.add(label, constraints);

            for (int i = 0; i < tutorials.size(); i++) {
                Tutorial tutorial = tutorials.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + tutorial.getName() + " : " + tutorial.getDescription() + "| Length of tutorial = " + tutorial.getLength() + " minutes " + "| Find it at: " + tutorial.getLink());
                constraints.gridy++;
                panel.add(productLabel, constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printDocumentationsUser(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;

        ArrayList<Documentation> docs = company.getDocumentations();
        if (docs.isEmpty()) {
            JLabel label = new JLabel("Documentations: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Documentations:");
            panel.add(label, constraints);

            for (int i = 0; i < docs.size(); i++) {
                Documentation doc = docs.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + doc.getName() + " : " + doc.getDescription() + "| Find it at: " + doc.getLink());
                constraints.gridy++;
                panel.add(productLabel,constraints);
            }
        }
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> printCompanyDetailsUser(company));
        constraints.gridy++;
        panel.add(returnButton,constraints);

        panel.revalidate();
        panel.repaint();
    }
}
