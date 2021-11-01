package order.builder;

import inventory.ItemInventory;
import inventory.builder.ItemInventoryBuilder;
import item.Item;
import order.Order;
import order.OrderItem;
import reader.CsvItemReader;
import reader.CsvOrderReader;
import reader.CsvReader;

public class OrderBuilder {
    private String dataPath;
    public Order build(){
        Order order = Order.getInstance();
        CsvReader<OrderItem> reader = new CsvOrderReader();
        int count = 0;
        reader.open(this.dataPath);
        reader.readHeader();
        OrderItem item;
        while((item = reader.read()) != null){
            count++;
            order.addItem(item);
        }
        System.out.println(order.getItems());
        System.out.println(count+" items added.");
        System.out.println("Order read!");
        return order;
    }

    public OrderBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }
}
