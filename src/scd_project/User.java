package scd_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class User extends JFrame {
    private String username;
    private String password;
    private String email;
    private String deliveryAddress;
    private String paymentInfo;

    public User(String username, String password, String email, String deliveryAddress, String paymentInfo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
        this.paymentInfo = paymentInfo;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField emailField;
    private JTextField deliveryAddressField;
    private JTextField paymentInfoField;

    private User user;

    public User() {
        setTitle("User GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel deliveryAddressLabel = new JLabel("Delivery Address:");
        deliveryAddressField = new JTextField();

        JLabel paymentInfoLabel = new JLabel("Payment Info:");
        paymentInfoField = new JTextField();

        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(deliveryAddressLabel);
        formPanel.add(deliveryAddressField);
        formPanel.add(paymentInfoLabel);
        formPanel.add(paymentInfoField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveUser();
            }
        });

        add(formPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    public void setUser(User user) {
        this.user = user;
        usernameField.setText(user.getUsername());
        passwordField.setText(user.getPassword());
        emailField.setText(user.getEmail());
        deliveryAddressField.setText(user.getDeliveryAddress());
        paymentInfoField.setText(user.getPaymentInfo());
    }

    public void saveUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String email = emailField.getText();
        String deliveryAddress = deliveryAddressField.getText();
        String paymentInfo = paymentInfoField.getText();

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setDeliveryAddress(deliveryAddress);
        user.setPaymentInfo(paymentInfo);

        JOptionPane.showMessageDialog(this, "User saved!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                User userGUI = new User();
                userGUI.setVisible(true);
                User user = new User("JohnDoe", "password", "johndoe@example.com",
                        "123 Main St", "1234 5678 9012 3456");
                userGUI.setUser(user);
            }
        });
    }
}