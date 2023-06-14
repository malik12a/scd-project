package scd_project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class MenuItem extends JFrame {
    private String name;
    private String description;
    private double price;
    private List<String> customizations;

    public MenuItem(String name, String description, double price, List<String> customizations) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.customizations = customizations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getCustomizations() {
        return customizations;
    }

    public void setCustomizations(List<String> customizations) {
        this.customizations = customizations;
    }
    private JTextField nameField;
    private JTextField descriptionField;
    private JTextField priceField;
    private JTextArea customizationsArea;

    private MenuItem menuItem;

    public  MenuItem() {
        setTitle("Menu Item GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        priceField = new JTextField();

        JLabel customizationsLabel = new JLabel("Customizations:");
        customizationsArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(customizationsArea);

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionField);
        formPanel.add(priceLabel);
        formPanel.add(priceField);
        formPanel.add(customizationsLabel);
        formPanel.add(scrollPane);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveMenuItem();
            }
        });

        add(formPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        nameField.setText(menuItem.getName());
        descriptionField.setText(menuItem.getDescription());
        priceField.setText(String.valueOf(menuItem.getPrice()));
        customizationsArea.setText(String.join("\n", menuItem.getCustomizations()));
    }

    public void saveMenuItem() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        double price = Double.parseDouble(priceField.getText());
        List<String> customizations = Arrays.asList(customizationsArea.getText().split("\n"));

        menuItem.setName(name);
        menuItem.setDescription(description);
        menuItem.setPrice(price);
        menuItem.setCustomizations(customizations);

        JOptionPane.showMessageDialog(this, "Menu item saved!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuItem menuItemGUI = new MenuItem();
                menuItemGUI.setVisible(true);

                // Create a sample menu item
                MenuItem menuItem = new MenuItem("Cheeseburger", "Delicious cheeseburger", 9.99,
                        Arrays.asList("Add bacon", "Extra cheese", "Choose a side"));
                menuItemGUI.setMenuItem(menuItem);
            }
        });
    }
}

