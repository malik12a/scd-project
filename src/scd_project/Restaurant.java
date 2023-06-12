package scd_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends JFrame  {
    private Restaurant restaurant;

    private JTextArea menuTextArea;
    private JTextArea offersTextArea;
    private JTextField offerCodeField;
    private JTextField totalPriceField;

    public Restaurant(Restaurant restaurant) {
        this.restaurant = restaurant;

        setTitle("Restaurant GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        menuTextArea = new JTextArea();
        menuTextArea.setEditable(false);
        JScrollPane menuScrollPane = new JScrollPane(menuTextArea);

        offersTextArea = new JTextArea();
        offersTextArea.setEditable(false);
        JScrollPane offersScrollPane = new JScrollPane(offersTextArea);

        JPanel offerPanel = new JPanel(new FlowLayout());
        JLabel offerCodeLabel = new JLabel("Offer Code:");
        offerCodeField = new JTextField(10);
        JButton applyOfferButton = new JButton("Apply Offer");
        applyOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyOffer();
            }
        });
        offerPanel.add(offerCodeLabel);
        offerPanel.add(offerCodeField);
        offerPanel.add(applyOfferButton);

        JPanel totalPricePanel = new JPanel(new FlowLayout());
        JLabel totalPriceLabel = new JLabel("Total Price:");
        totalPriceField = new JTextField(10);
        totalPriceField.setEditable(false);
        totalPricePanel.add(totalPriceLabel);
        totalPricePanel.add(totalPriceField);

        add(menuScrollPane, BorderLayout.WEST);
        add(offersScrollPane, BorderLayout.CENTER);
        add(offerPanel, BorderLayout.SOUTH);
        add(totalPricePanel, BorderLayout.EAST);
    }

    public Restaurant(String restaurantName, List<MenuItem> menu) {

    }

    public void updateMenuTextArea() {
        List<MenuItem> menu = restaurant.getMenu();
        StringBuilder menuText = new StringBuilder();
        menuText.append("Menu of ").append(restaurant.getName()).append(":\n\n");
        for (MenuItem item : menu) {
            menuText.append(item.getName()).append(" - ").append(item.getDescription()).append(" - $").append(item.getPrice()).append("\n");
            menuText.append("Customizations: ").append(item.getCustomizations()).append("\n\n");
        }
        menuTextArea.setText(menuText.toString());
    }

    private List<MenuItem> getMenu() {
        return null;
    }

    public void updateOffersTextArea() {
        List<Offer> offers = restaurant.getOffers();
        StringBuilder offersText = new StringBuilder();
        offersText.append("Offers available at ").append(restaurant.getName()).append(":\n");
        for (Offer offer : offers) {
            offersText.append(offer.getCode()).append(" - ").append(offer.getDescription()).append("\n");
        }
        offersTextArea.setText(offersText.toString());
    }

    private List<Offer> getOffers() {
        return null;
    }

    public void applyOffer() {
        String offerCode = offerCodeField.getText();
        double totalPrice = Double.parseDouble(totalPriceField.getText());

        double newTotalPrice = restaurant.applyOffer(offerCode, totalPrice);
        totalPriceField.setText(String.format("%.2f", newTotalPrice));
    }

    private double applyOffer(String offerCode, double totalPrice) {
        return 0;
    }
    private void addOffer(Offer offer1) {
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                List<MenuItem> menu = new ArrayList<>();
                menu.add(new MenuItem("Item 1", "Description 1", 10.0, new ArrayList<>()));
                menu.add(new MenuItem("Item 2", "Description 2", 15.0, new ArrayList<>()));
                menu.add(new MenuItem("Item 3", "Description 3", 20.0, new ArrayList<>()));

                Restaurant restaurant = new Restaurant("Restaurant Name", menu);
                restaurant.addOffer(new Offer("OFFER1", "Offer Description 1", 0.1));
                restaurant.addOffer(new Offer("OFFER2", "Offer Description 2", 0.2));

                Restaurant restaurantGUI = new Restaurant(restaurant);
                restaurantGUI.updateMenuTextArea();
                restaurantGUI.updateOffersTextArea();
                restaurantGUI.setVisible(true);
            }
        });
    }


}
