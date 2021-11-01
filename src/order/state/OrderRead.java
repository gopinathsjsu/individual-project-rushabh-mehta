package order.state;

import inventory.ItemInventory;
import item.Item;
import order.Order;
import order.OrderItem;
import order.OrderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderRead extends OrderStateSup{
    public OrderRead(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    @Override
    public void checkStock(Order order) {
        List<OrderItem> invalidItems = new ArrayList<>();
        List<OrderItem> orderItems = order.getItems();
        ItemInventory inventory = ItemInventory.getInstance();
        Map<String, Item> inventoryItems= inventory.getInventory();
        for(OrderItem orderItem: orderItems){
            Item item = inventoryItems.get(orderItem.getName());
            if(item.getQuantity()<orderItem.getQuantity()){
                invalidItems.add(orderItem);
            }
        }
        // TODO write to output file
        if(invalidItems.size()>0){
            System.out.println("Please correct quantities.");
            for(OrderItem item : invalidItems){
                System.out.println(item);
            }
            orderProcessor.setCurrState(OrderStates.INVALID);
        }else{
            System.out.println("Inventory has enough stock!");
            orderProcessor.setCurrState(OrderStates.DBVALIDATED);
        }
    }
}
