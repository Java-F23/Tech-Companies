import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextEntryWindow extends EntryWindow {
    private String enteredtext;

    public TextEntryWindow(String title, ActionListener listener) {
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

        this.pack();
        this.setVisible(true);

        textButton.addActionListener(e -> {
            enteredtext = textField.getText();
            listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, getEnteredText()));
            dispose(); // Close the window
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Execute the listener with a null action command
                listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
            }
        });
    }

    public String getEnteredText() {
        return enteredtext;
    }
}
