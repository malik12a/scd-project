package scd_project;
import java.util.*;
public class Order {
    private User user;
    private List<MenuItem> items;

    public Order(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }
    public User getUser() {
        return user;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public void updateItem(MenuItem oldItem, MenuItem newItem) {
        int index = items.indexOf(oldItem);
        if (index != -1) {
            items.set(index, newItem);
        }
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (MenuItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    public void clearOrder() {
        items.clear();
    }
}
