import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.TreeSet;

public class AdminBoard_UI {
    private View view;
    private JFrame frame;
    private JPanel panel;
    private JButton returnButton;
    private JScrollPane scrollpanel;
    private JPanel showAllCompaniesPanel;

    public AdminBoard_UI(View view) {
        this.view = view;
        frame = new JFrame("Admin Board");
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
        JButton addCompaniesButton = new JButton("Add a Company");
        JButton logOutButton = new JButton("Log Out");

        // Add action listeners to each button
        showAllCompaniesButton.addActionListener(e -> showCompanies(view.getCompanies()));
        filterCompaniesByNameButton.addActionListener(e -> searchName());
        filterCompaniesByIndustryButton.addActionListener(e -> searchIndustry());
        filterCompaniesByLocationButton.addActionListener(e -> searchLocation());
        addCompaniesButton.addActionListener(e -> addCompany());
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
        panel.add(addCompaniesButton,constraints);
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
            JButton companyButton = new JButton(company.getName());
            companyButton.addActionListener(e -> showCompanyDetails(company, companies));
            showAllCompaniesPanel.add(companyButton, constraints);
            constraints.gridy++;
        }

        // Create a return button to go back to the showOptions panel
        returnButton = new JButton("Return");
        returnButton.addActionListener(e -> returnToShowOptions());
        showAllCompaniesPanel.add(returnButton,constraints);

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
        returnButton = new JButton("Return");
        returnButton.addActionListener(e -> showCompanies(companies));
        printCompanyDetailsAdmin(company);

        // Repaint the panel
        panel.revalidate();
        panel.repaint();
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

    private void addCompany(){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener nameEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name = e.getActionCommand();
                if (Name == null) {
                    showOptions();
                } else {
                    ActionListener locEnteredListener = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String Location = e.getActionCommand();
                            if (Location == null) {
                                showOptions();
                            } else {
                                ActionListener dateEnteredListener = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String Date = e.getActionCommand();
                                        if (Date == null) {
                                            showOptions();
                                        } else {
                                            ActionListener indEnteredListener = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    String Industry = e.getActionCommand();
                                                    if (Industry == null) {
                                                        showOptions();
                                                    } else {
                                                        view.addCompany(new Company(Name,Industry,Integer.parseInt(Date),Location));
                                                        showOptions();
                                                    }
                                                }
                                            };
                                            TextEntryWindow ind = new TextEntryWindow("Industry of Company", indEnteredListener);
                                        }
                                    }
                                };
                                IntEntryWindow date = new IntEntryWindow("Year of Foundation", dateEnteredListener);
                            }
                        }
                    };
                    TextEntryWindow loc = new TextEntryWindow("Location of the company", locEnteredListener);
                }
            }
        };

        TextEntryWindow name = new TextEntryWindow("Name of the company", nameEnteredListener);
    }

    private void logOut(){
        view.initiate();
        frame.dispose();
    }

    public void printCompanyDetailsAdmin(Company company) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);

        // Company Name
        JLabel nameLabel = new JLabel("Company Name: " + company.getName());
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        // Edit Button for Company Name
        JButton editNameButton = new JButton("Edit");
        editNameButton.addActionListener(e -> editCompanyName(company));
        constraints.gridx = 1; // Place the button in the next column
        panel.add(editNameButton, constraints);

        // Industry
        JLabel industryLabel = new JLabel("Industry: " + company.getIndustry());
        constraints.gridy = 1;
        constraints.gridx = 0; // Reset column to 0
        panel.add(industryLabel, constraints);

        // Edit Button for Industry
        JButton editIndustryButton = new JButton("Edit");
        editIndustryButton.addActionListener(e -> editIndustry(company));
        constraints.gridx = 1;
        panel.add(editIndustryButton, constraints);

        // Location
        JLabel locationLabel = new JLabel("Location: " + company.getLocation());
        constraints.gridy = 2;
        constraints.gridx = 0; // Reset column to 0
        panel.add(locationLabel, constraints);

        // Edit Button for Location
        JButton editLocationButton = new JButton("Edit");
        editLocationButton.addActionListener(e -> editLocation(company));
        constraints.gridx = 1;
        panel.add(editLocationButton, constraints);
        constraints.gridx = 0; // Reset column to 0

        // Year of Founding
        JLabel foundingYearLabel = new JLabel("Year of Founding: " + company.getFoundingYear());
        constraints.gridy = 3;
        panel.add(foundingYearLabel, constraints);

        // Edit Button for Year
        JButton editYearButton = new JButton("Edit");
        editYearButton.addActionListener(e -> editYear(company));
        constraints.gridx = 1;
        panel.add(editYearButton, constraints);
        constraints.gridx = 0; // Reset column to 0

        // Products Button
        JButton productsButton = new JButton("Products");
        productsButton.addActionListener(e -> printProductsAdmin(company));
        constraints.gridy = 4;
        panel.add(productsButton, constraints);

        // Services Button
        JButton servicesButton = new JButton("Services");
        servicesButton.addActionListener(e -> printServicesAdmin(company));
        constraints.gridy = 5;
        panel.add(servicesButton, constraints);

        // Jobs Button
        JButton jobsButton = new JButton("Jobs");
        jobsButton.addActionListener(e -> printJobsAdmin(company));
        constraints.gridy = 6;
        panel.add(jobsButton, constraints);

        // Number of Employees
        JLabel employeesLabel = new JLabel("Number of Employees: " + company.getEmployees().size());
        constraints.gridy = 7;
        panel.add(employeesLabel, constraints);

        // Current Projects Button
        JButton currentProjectsButton = new JButton("Current Projects");
        currentProjectsButton.addActionListener(e -> printCurrentProjectsAdmin(company));
        constraints.gridy = 8;
        panel.add(currentProjectsButton, constraints);

        // Past Projects Button
        JButton pastProjectsButton = new JButton("Past Projects");
        pastProjectsButton.addActionListener(e -> printPastProjectsAdmin(company));
        constraints.gridy = 9;
        panel.add(pastProjectsButton, constraints);

        // Courses Button
        JButton coursesButton = new JButton("Courses");
        coursesButton.addActionListener(e -> printCoursesAdmin(company));
        constraints.gridy = 10;
        panel.add(coursesButton, constraints);

        // Tutorials Button
        JButton tutorialsButton = new JButton("Tutorials");
        tutorialsButton.addActionListener(e -> printTutorialsAdmin(company));
        constraints.gridy = 11;
        panel.add(tutorialsButton, constraints);

        // Documentations Button
        JButton documentationsButton = new JButton("Documentations");
        documentationsButton.addActionListener(e -> printDocumentationsAdmin(company));
        constraints.gridy = 12;
        panel.add(documentationsButton, constraints);

        // Revenue
        JLabel revenueLabel = new JLabel("Revenue: " + company.getRevenue());
        constraints.gridy = 13;
        panel.add(revenueLabel, constraints);

        // Edit Button for Revenue
        JButton editRevenueButton = new JButton("Edit");
        editRevenueButton.addActionListener(e -> editRevenue(company));
        constraints.gridx = 1;
        panel.add(editRevenueButton, constraints);
        constraints.gridx = 0; // Reset column to 0

        constraints.gridy = 14;
        panel.add(returnButton, constraints);

        panel.revalidate();
        panel.repaint();
    }

    private void editCompanyName(Company company){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = e.getActionCommand();
                if (name == null) {
                    printCompanyDetailsAdmin(company);
                } else {
                    company.setName(name);
                    view.updateDB();
                    JOptionPane.showMessageDialog(null, "Name Changed");
                    printCompanyDetailsAdmin(company);
                }
            }
        };

        TextEntryWindow nameWindow = new TextEntryWindow("New Name of the Company", textEnteredListener);
    }

    private void editLocation(Company company){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(company);
                } else {
                    company.setLocation(input);
                    view.updateDB();
                    JOptionPane.showMessageDialog(null, "Location Changed");
                    printCompanyDetailsAdmin(company);
                }
            }
        };

        TextEntryWindow window = new TextEntryWindow("New Location of the Company", textEnteredListener);
    }

    private void editIndustry(Company company){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(company);
                } else {
                    company.setIndustry(input);
                    view.updateDB();
                    JOptionPane.showMessageDialog(null, "Industry Changed");
                    printCompanyDetailsAdmin(company);
                }
            }
        };

        TextEntryWindow window = new TextEntryWindow("New Industry of the Company", textEnteredListener);
    }
    private void editYear(Company company){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(company);
                } else {
                    company.setFoundingYear(Integer.parseInt(input));
                    view.updateDB();
                    JOptionPane.showMessageDialog(null, "Year of Foundation Changed");
                    printCompanyDetailsAdmin(company);
                }
            }
        };

        IntEntryWindow window = new IntEntryWindow("New Year of Foundation", textEnteredListener);
    }


    private void editRevenue(Company company){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        ActionListener textEnteredListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                if (input == null) {
                    printCompanyDetailsAdmin(company);
                } else {
                    company.setRevenue(new BigDecimal(Integer.parseInt(input)));
                    view.updateDB();
                    JOptionPane.showMessageDialog(null, "Revenue Changed");
                    printCompanyDetailsAdmin(company);
                }
            }
        };

        IntEntryWindow window = new IntEntryWindow("New Revenue", textEnteredListener);
    }

    public void printServicesAdmin(Company company) {
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

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
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.removeService(S);
                        JOptionPane.showMessageDialog(null, "Service Removed");
                        printServicesAdmin(company);
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
                            printServicesAdmin(company);
                        } else {
                            company.addService(input);
                            JOptionPane.showMessageDialog(null, "Service Added");
                            printServicesAdmin(company);
                        }
                    }
                };

                TextEntryWindow window = new TextEntryWindow("New Service", textEnteredListener);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printProductsAdmin(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        TreeSet<String> products = company.getProducts();
        if (products.isEmpty()) {
            JLabel label = new JLabel("Products: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Products:");
            panel.add(label, constraints);
            int i = 0;
            for (String product: products) {
                JLabel productLabel = new JLabel((i + 1) + ") " + product);
                constraints.gridy++;
                panel.add(productLabel, constraints);
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.removeProduct(product);
                        JOptionPane.showMessageDialog(null, "Product Removed");
                        printProductsAdmin(company);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
                i++;
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
                            printProductsAdmin(company);
                        } else {
                            company.addProduct(input);
                            JOptionPane.showMessageDialog(null, "Product Added");
                            printProductsAdmin(company);
                        }
                    }
                };

                TextEntryWindow window = new TextEntryWindow("New Product", textEnteredListener);
            }
        });
        constraints.gridy++;
        panel.add(addButton, constraints);

        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printJobsAdmin(Company company){
        ArrayList<JobListing> temp = company.getJobs();
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
                panel.add(jobLabel,constraints);

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.removeJob(temp.indexOf(J));
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "Job Listing Removed");
                        printJobsAdmin(company);
                    }
                });
                constraints.gridx++;
                panel.add(removeButton, constraints);

                JButton manageButton = new JButton("Manage");
                manageButton.addActionListener(e -> manageJob(company,J));
                constraints.gridx++;
                panel.add(manageButton,constraints);
                constraints.gridx--;
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
                            printJobsAdmin(company);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printJobsAdmin(company);
                                    } else {
                                        company.addJob(new JobListing(input1, input2));
                                        view.updateDB();
                                        JOptionPane.showMessageDialog(null, "Job Listing Added");
                                        printJobsAdmin(company);
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
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printCurrentProjectsAdmin(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Project> projects = company.getCurrentProjects();
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
                        company.removeCurrentProject(projects.indexOf(project));
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "Project Removed");
                        printCurrentProjectsAdmin(company);
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
                                    printCurrentProjectsAdmin(company);
                                } else {
                                    int prog = Integer.parseInt(input);
                                    if(prog >= 100){
                                        project.setProgress(100);
                                        company.completeCurrentProject(projects.indexOf(project));
                                        view.updateDB();
                                        JOptionPane.showMessageDialog(null, "Project Completed");
                                        printCurrentProjectsAdmin(company);
                                    }
                                    else if(prog <= 0){
                                        project.setProgress(0);
                                        view.updateDB();
                                        JOptionPane.showMessageDialog(null, "Project Reset");
                                        printCurrentProjectsAdmin(company);
                                    }
                                    else{
                                        project.setProgress(prog);
                                        view.updateDB();
                                        JOptionPane.showMessageDialog(null, "Project Updated");
                                        printCurrentProjectsAdmin(company);
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
                            printCurrentProjectsAdmin(company);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printCurrentProjectsAdmin(company);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printCurrentProjectsAdmin(company);
                                                } else {
                                                    ActionListener textEnteredListener4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            String input4 = e.getActionCommand();
                                                            if (input4 == null) {
                                                                printCurrentProjectsAdmin(company);
                                                            } else {
                                                                company.addCurrentProject(new Project(Integer.parseInt(input3),input1,input2,new BigDecimal(Integer.parseInt(input4))));
                                                                view.updateDB();
                                                                JOptionPane.showMessageDialog(null, "Project Added");
                                                                printCurrentProjectsAdmin(company);
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
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printPastProjectsAdmin(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Project> projects = company.getPastProjects();
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
                        company.removePastProject(projects.indexOf(project));
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "Project Removed");
                        printPastProjectsAdmin(company);
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
                            printPastProjectsAdmin(company);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printPastProjectsAdmin(company);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printPastProjectsAdmin(company);
                                                } else {
                                                    ActionListener textEnteredListener4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            String input4 = e.getActionCommand();
                                                            if (input4 == null) {
                                                                printPastProjectsAdmin(company);
                                                            } else {
                                                                company.addPastProject(new Project(Integer.parseInt(input3),input1,input2,new BigDecimal(Integer.parseInt(input4))));
                                                                view.updateDB();
                                                                JOptionPane.showMessageDialog(null, "Project Added");
                                                                printPastProjectsAdmin(company);
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
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }

    public void printCoursesAdmin(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

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
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.removeCourse(courses.indexOf(course));
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "Resource Removed");
                        printCoursesAdmin(company);
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
                            printCoursesAdmin(company);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printCoursesAdmin(company);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printCoursesAdmin(company);
                                                } else {
                                                    ActionListener textEnteredListener3 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            String lects = e.getActionCommand();
                                                            if (lects == null) {
                                                                printCoursesAdmin(company);
                                                            } else {
                                                                company.addCourse(new Course(input1, input2, input3,Integer.parseInt(lects)));
                                                                view.updateDB();
                                                                JOptionPane.showMessageDialog(null, "Resource Added");
                                                                printCoursesAdmin(company);
                                                            }
                                                        }
                                                    };
                                                    IntEntryWindow ind = new IntEntryWindow("Number of Lectures", textEnteredListener3);
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
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printTutorialsAdmin(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

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

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.removeTutorial(tutorials.indexOf(tutorial));
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "Resource Removed");
                        printTutorialsAdmin(company);
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
                            printTutorialsAdmin(company);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printTutorialsAdmin(company);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printTutorialsAdmin(company);
                                                } else {
                                                    ActionListener textEnteredListener4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            String input4 = e.getActionCommand();
                                                            if (input4 == null) {
                                                                printTutorialsAdmin(company);
                                                            } else {
                                                                company.addTutorial(new Tutorial(input1, input2, input3, Integer.parseInt(input4)));
                                                                view.updateDB();
                                                                JOptionPane.showMessageDialog(null, "Resource Added");
                                                                printTutorialsAdmin(company);
                                                            }
                                                        }
                                                    };

                                                    IntEntryWindow window4 = new IntEntryWindow("Length of Tutorial in minutes", textEnteredListener4);
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
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void printDocumentationsAdmin(Company company){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;

        ArrayList<Documentation> docs = company.getDocumentations();
        if (docs.isEmpty()) {
            JLabel label = new JLabel("Documentations: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Documentations:");
            panel.add(label, constraints);

            for (int i = 0; i < docs.size(); i++) {
                Documentation doc = docs.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + doc.getName() + " : " + doc.getDescription() + "Find it at: " + doc.getLink());
                constraints.gridy++;
                panel.add(productLabel,constraints);

                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.removeDocumentation(docs.indexOf(doc));
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "Resource Removed");
                        printDocumentationsAdmin(company);
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
                            printDocumentationsAdmin(company);
                        } else {
                            ActionListener textEnteredListener2 = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String input2 = e.getActionCommand();
                                    if (input2 == null) {
                                        printDocumentationsAdmin(company);
                                    } else {
                                        ActionListener textEnteredListener3 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                String input3 = e.getActionCommand();
                                                if (input3 == null) {
                                                    printDocumentationsAdmin(company);
                                                } else {
                                                    company.addDocumentation(new Documentation(input1, input2, input3));
                                                    view.updateDB();
                                                    JOptionPane.showMessageDialog(null, "Resource Added");
                                                    printDocumentationsAdmin(company);
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
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
    public void manageJob(Company company, JobListing j){
        panel.removeAll();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(5,5,5,5);
        constraints.gridy = 0;
        constraints.gridx = 0;
        ArrayList<User> applications = j.getApplicants();
        if (applications.isEmpty()) {
            JLabel label = new JLabel("Applications: None");
            panel.add(label, constraints);
        } else {
            JLabel label = new JLabel("Applications:");
            panel.add(label, constraints);

            for (int i = 0; i < applications.size(); i++) {
                User user = applications.get(i);
                JLabel productLabel = new JLabel((i + 1) + ") " + user.getID() + " | " + user.getUsername());
                constraints.gridy++;
                panel.add(productLabel, constraints);

                JButton acceptButton = new JButton("Accept");
                acceptButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        company.addEmployee(user.getID());
                        j.removeApplicant(user);
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "User Accepted");
                        manageJob(company,j);
                    }
                });

                JButton removeButton = new JButton("Reject");
                removeButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        j.removeApplicant(user);
                        view.updateDB();
                        JOptionPane.showMessageDialog(null, "User Rejected");
                        manageJob(company,j);
                    }
                });

                constraints.gridx++;
                panel.add(acceptButton, constraints);
                constraints.gridx++;
                panel.add(removeButton, constraints);
                constraints.gridx--;
                constraints.gridx--;
            }
        }
        JButton returnButton2 = new JButton("Return");
        returnButton2.addActionListener(e -> printCompanyDetailsAdmin(company));
        constraints.gridy++;
        panel.add(returnButton2, constraints);

        panel.revalidate();
        panel.repaint();
    }
}
