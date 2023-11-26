import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Welcome_Screen {
    private View view;
    JFrame frame;
    public Welcome_Screen(View v){
        view = v;
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
        JButton button = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(button, gbc);

        JButton button2 = new JButton("Sign Up");
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(button2, gbc);

        // Attach an ActionListener to the JButton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.Login();
                frame.dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.Register();
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
