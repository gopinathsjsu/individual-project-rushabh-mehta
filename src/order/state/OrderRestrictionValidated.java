package order.state;

import inventory.ItemInventory;
import item.Item;
import order.Order;
import order.OrderItem;
import order.OrderProcessor;
import resources.Path;
import writer.CsvWriter;
import writer.Writer;

import java.util.List;
import java.util.Map;

public class OrderRestrictionValidated extends OrderStateSup{
    public OrderRestrictionValidated(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }
    public void generateBill(Order order){
        //TODO update inventory
        List<OrderItem> orderItems = order.getItems();
        ItemInventory itemInventory = ItemInventory.getInstance();
        Map<String, Item> inventory = itemInventory.getInventory();
        double total=0;
        for(OrderItem orderItem : orderItems){
            String name = orderItem.getName();
            double price = inventory.get(name).getPrice();
            total = total + price*orderItem.getQuantity();
        }
        StringBuilder message = new StringBuilder();
        message.append("Amt Paid");
        message.append("\n");
        message.append(total);
        Writer writer = new CsvWriter();
        writer.write(Path.outputPath,message);
        System.out.println("Bill generated!");
        orderProcessor.setCurrState(OrderStates.BILLGENERATED);
    }
}
