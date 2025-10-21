
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {

    // Form components
    private JTextField nameField, regNoField, deptField, emailField;
    private JButton submitButton, clearButton;
    private JTextArea outputArea;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Labels and text fields
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Register No:"));
        regNoField = new JTextField();
        formPanel.add(regNoField);

        formPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        formPanel.add(deptField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        // Buttons
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        formPanel.add(submitButton);
        formPanel.add(clearButton);

        add(formPanel, BorderLayout.NORTH);

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button actions
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String regNo = regNoField.getText();
            String dept = deptField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || regNo.isEmpty() || dept.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                outputArea.setText("Student Registration Successful!\n\n");
                outputArea.append("Name: " + name + "\n");
                outputArea.append("Register No: " + regNo + "\n");
                outputArea.append("Department: " + dept + "\n");
                outputArea.append("Email: " + email + "\n");
            }
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            regNoField.setText("");
            deptField.setText("");
            emailField.setText("");
            outputArea.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRegistrationForm().setVisible(true);
        });
    }
}
