package order;

import inventory.ItemInventory;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public boolean addItem(OrderItem item){
        items.add(item);
        return true;
    }
}
