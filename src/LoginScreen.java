import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {
    private Database database;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen(Database db) {
        // Create components
        userLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        userTextField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        database = db;

        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add components to frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(userTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        // Add action listener to login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get username and password from text fields
                String username = userTextField.getText();
                String password = new String(passwordField.getPassword());

                // Check if user exists in database
                User user = database.getUser(username, password);
                if (user != null) {
                    // User exists, login successful
                    System.out.println("Login successful");
                } else {
                    // User does not exist, login failed
                    ErrorMessage.show("Invalid username or password");
                }
            }
        });

        // Set frame properties
        setTitle("Login Screen");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

