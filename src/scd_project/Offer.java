package scd_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Offer extends JFrame {
    private String code;
    private String description;
    private double discount;

    public Offer(String code, String description, double discount) {
        this.code = code;
        this.description = description;
        this.discount = discount;
    }


    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }
    private List<Offer> offers;
    private JTextArea offersTextArea;
    private JComboBox<String> offerComboBox;
    private JButton getOfferButton;

    public Offer(List<Offer> offers) {
        this.offers = offers;

        setTitle("Offer GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        offersTextArea = new JTextArea();
        offersTextArea.setEditable(false);
        JScrollPane offersScrollPane = new JScrollPane(offersTextArea);

        JPanel offerPanel = new JPanel(new FlowLayout());
        JLabel offerLabel = new JLabel("Select Offer:");
        offerComboBox = new JComboBox<>();
        for (Offer offer : offers) {
            offerComboBox.addItem(offer.getCode());
        }
        getOfferButton = new JButton("Get Offer");
        getOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSelectedOffer();
            }
        });

        offerPanel.add(offerLabel);
        offerPanel.add(offerComboBox);
        offerPanel.add(getOfferButton);

        add(offersScrollPane, BorderLayout.CENTER);
        add(offerPanel, BorderLayout.SOUTH);
    }

    public void updateOffersTextArea() {
        StringBuilder offersText = new StringBuilder();
        offersText.append("Offers:\n");
        for (Offer offer : offers) {
            offersText.append(offer.getCode()).append(" - ").append(offer.getDescription()).append("\n");
        }
        offersTextArea.setText(offersText.toString());
    }

    public void getSelectedOffer() {
        String selectedCode = (String) offerComboBox.getSelectedItem();
        Offer selectedOffer = null;
        for (Offer offer : offers) {
            if (offer.getCode().equals(selectedCode)) {
                selectedOffer = offer;
                break;
            }
        }

        if (selectedOffer != null) {
            JOptionPane.showMessageDialog(this, "Selected Offer: " + selectedOffer.getCode() + " - " + selectedOffer.getDescription());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                List<Offer> offers = new ArrayList<>();
                offers.add(new Offer("OFFER1", "Offer Description 1", 0.1));
                offers.add(new Offer("OFFER2", "Offer Description 2", 0.2));

                Offer offerGUI = new Offer(offers);
                offerGUI.updateOffersTextArea();
                offerGUI.setVisible(true);
            }
        });
    }


}





