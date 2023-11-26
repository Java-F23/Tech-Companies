import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class RegistrationScreen extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JRadioButton adminRadioButton;
    private View view;

    public RegistrationScreen(View view) {
        this.view = view;
        setTitle("Registration Screen");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);

        // Admin Radio Button
        JLabel adminLabel = new JLabel("Admin:");
        adminRadioButton = new JRadioButton();
        mainPanel.add(adminLabel);
        mainPanel.add(adminRadioButton);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });

        // Add components to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(registerButton, BorderLayout.SOUTH);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        boolean isAdmin = adminRadioButton.isSelected();
        if(view.checkUsername(username)){
            ErrorMessage.show("Username Already Used");
        }
        else if(!view.checkPassword(password)){
            ErrorMessage.show("Password must be at least 8 characters with at least one uppercase, one lowercase, and one number");
        }
        else{
            if(view.addUser(new User(username,password,isAdmin))){
                view.Login();
                dispose();
            }
        }
    }
}