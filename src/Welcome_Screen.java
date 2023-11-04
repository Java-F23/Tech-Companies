import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Welcome_Screen {
    private Database db;
    private JFrame frame;
    public Welcome_Screen(Database database){
        db = database;
    }
    public void initiate(){
        frame = new JFrame("Welcome Screen");

        // Set the layout of the JFrame to GridBagLayout
        frame.setLayout(new GridBagLayout());

        // Create a GridBagConstraints object
        GridBagConstraints gbc = new GridBagConstraints();

        // Add a JLabel to the JFrame to display the welcome message
        JLabel label = new JLabel("Welcome to the Application!", JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(label, gbc);

        // Create a new JButton
        JButton button = new JButton("Start Application");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(button, gbc);

        // Attach an ActionListener to the JButton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginScreen loginScreen = new LoginScreen(db);
                loginScreen.setVisible(true);
                // Hide welcome screen
                frame.setVisible(false);
                frame.dispose();
            }
        });

        // Set the size of the JFrame
        frame.setSize(400, 200);

        // Center the JFrame on the screen
        frame.setLocationRelativeTo(null);

        // Make the JFrame visible
        frame.setVisible(true);

        // Close the application when the JFrame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
