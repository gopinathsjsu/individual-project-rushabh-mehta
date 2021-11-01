package order;

import inventory.ItemInventory;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private static Order instance=null;

    private Order() {
        items = new ArrayList<>();
    }

    public static Order getInstance(){
        if(instance==null){
            instance = new Order();
        }
        return instance;
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
