import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntEntryWindow extends EntryWindow {
    private int enteredInteger = -1;
    private boolean isIntegerEntered;

    public IntEntryWindow(String title, ActionListener listener) {
        this.listener = listener;
        this.title = title;
        setTitle("Enter " + this.title);
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        textButton = new JButton("Submit Text");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter " + this.title + ": "));
        panel.add(textField);
        panel.add(textButton);

        add(panel);

        textButton.addActionListener(e -> {
            String text = textField.getText();
            // Check if the input is an integer
            try {
                enteredInteger = Integer.parseInt(text);
                isIntegerEntered = true;
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, String.valueOf(enteredInteger)));
                dispose(); // Close the window if it's an integer
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(IntEntryWindow.this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                isIntegerEntered = false;
            }

        });
    }

    public int getEnteredInteger() {
        return enteredInteger;
    }

    public boolean isIntegerEntered() {
        return isIntegerEntered;
    }
}
