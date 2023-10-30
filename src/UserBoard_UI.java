import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class UserBoard_UI {
    private User user;
    private JFrame frame;
    private JPanel panel;
    private JPanel showAllCompaniesPanel;
    private JPanel companyDetailsPanel;

    public UserBoard_UI(User user) {
        this.user = user;
        frame = new JFrame("UserBoard");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showOptions();
    }

    public void showOptions() {
        // Create main panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create buttons for each option
        JButton showAllCompaniesButton = new JButton("Show all Companies");
        JButton filterCompaniesByNameButton = new JButton("Filter Companies by name");
        JButton filterCompaniesByIndustryButton = new JButton("Filter Companies by industry");
        JButton filterCompaniesByLocationButton = new JButton("Filter Companies by location");
        JButton showFavouriteCompaniesButton = new JButton("Show Favourite Companies");
        JButton logOutButton = new JButton("Log Out");

        // Add action listeners to each button
        showAllCompaniesButton.addActionListener(e -> showAllCompanies());
/*        filterCompaniesByNameButton.addActionListener(e -> searchName());
        filterCompaniesByIndustryButton.addActionListener(e -> searchIndustry());
        filterCompaniesByLocationButton.addActionListener(e -> searchLocation());
        showFavouriteCompaniesButton.addActionListener(e -> showFavourites());
        logOutButton.addActionListener(e -> logOut());*/

        // Add buttons to panel
        panel.add(showAllCompaniesButton);
        panel.add(filterCompaniesByNameButton);
        panel.add(filterCompaniesByIndustryButton);
        panel.add(filterCompaniesByLocationButton);
        panel.add(showFavouriteCompaniesButton);
        panel.add(logOutButton);

        // Add panel to frame and display
        frame.add(panel);
        frame.setVisible(true);
    }

    public void showAllCompanies() {
        // Create a new JPanel to hold the list of companies
        showAllCompaniesPanel = new JPanel();
        showAllCompaniesPanel.setLayout(new BoxLayout(showAllCompaniesPanel, BoxLayout.Y_AXIS));
        ArrayList<Company> companies = Main.db.getCompanies();
        // Create a label for each company and add it to the panel
        // Create a button for each company and add it to the panel
        for (Company company : Main.db.getCompanies()) {
            JButton companyButton = new JButton(company.getName());
            companyButton.addActionListener(e -> showCompanyDetails(company));
            showAllCompaniesPanel.add(companyButton);
        }

        // Create a return button to go back to the showOptions panel
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> returnToShowOptions());
        showAllCompaniesPanel.add(returnButton);

        // Clear the panel and add the showAllCompaniesPanel and returnButton
        panel.removeAll();
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
    public void showCompanyDetails(Company company) {
        // Create a new JPanel to hold the company details
        companyDetailsPanel = new JPanel();
        companyDetailsPanel.setLayout(new BoxLayout(companyDetailsPanel, BoxLayout.Y_AXIS));

        company.printCompanyDetails(companyDetailsPanel);

        // Create a return button to go back to the showAllCompaniesPanel
        JButton returnButton = new JButton("Return");
        returnButton.addActionListener(e -> returnToShowAllCompanies());

        // Add the labels and return button to the companyDetailsPanel
        companyDetailsPanel.add(returnButton);

        // Clear the panel and add the companyDetailsPanel
        panel.removeAll();
        panel.add(companyDetailsPanel);

        // Repaint the panel
        panel.revalidate();
        panel.repaint();
    }
    public void returnToShowAllCompanies() {
        // Clear the panel and add the showAllCompaniesPanel
        panel.removeAll();
        panel.add(showAllCompaniesPanel);

        // Repaint the panel
        panel.revalidate();
        panel.repaint();
    }
}
