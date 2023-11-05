import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserBoard_UI {
    private User user;
    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollpanel;
    private JPanel showAllCompaniesPanel;
    private JPanel companyDetailsPanel;

    public UserBoard_UI(User user) {
        this.user = user;
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
        showAllCompaniesButton.addActionListener(e -> showCompanies(Main.db.getCompanies()));
        filterCompaniesByNameButton.addActionListener(e -> searchName());
        filterCompaniesByIndustryButton.addActionListener(e -> searchIndustry());
        filterCompaniesByLocationButton.addActionListener(e -> searchLocation());
        showFavouriteCompaniesButton.addActionListener(e -> showCompanies(user.getFavoriteCompanies()));
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
            updateFavoriteButtonText(company, favButton, user);
            // Add an ActionListener to toggle the favorite status and show details
            favButton.addActionListener(e -> {
                toggleFavorite(company, favButton, user);
            });
            companyPanel.add(favButton);
            showAllCompaniesPanel.add(companyPanel, constraints);
            constraints.gridy++;
        }

        // Create a return button to go back to the showOptions panel
        JButton returnButton = new JButton("Return");
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
        // Create a new JPanel to hold the company details
        companyDetailsPanel = new JPanel();
        companyDetailsPanel.setLayout(new GridLayout(0,1));


        // Create a return button to go back to the showAllCompaniesPanel
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> showCompanies(companies));
        company.printCompanyDetailsUser(companyDetailsPanel, user, returnButton);

        // Clear the panel and add the companyDetailsPanel
        panel.removeAll();
        panel.add(companyDetailsPanel);

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
                    showCompanies(Main.db.getCompaniesByName(Name));
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
                    showCompanies(Main.db.getCompaniesByIndustry(Ind));
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
                    showCompanies(Main.db.getCompaniesByLocation(loc));
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
        Main.welcomeScreen.initiate();
        frame.dispose();
    }
}
