import inventory.CardInventory;
import inventory.builder.CardInventoryBuilder;
import inventory.ItemInventory;
import inventory.builder.ItemInventoryBuilder;
import order.Order;
import order.builder.OrderBuilder;
import resources.Path;

public class OrderProcessor {
    public static void main(String[] args){
        // TODO prepare item database - DONE
        // TODO prepare card database - DONE
        // TODO read input order csv file - DONE
        // TODO process order
            // TODO

        // TODO generate output total amount csv


        // TODO refactor to add builder interface
        // TODO refactor to add inventory interface


        // create inventory of items
        ItemInventoryBuilder itemInventoryBuilder = new ItemInventoryBuilder();
        // item inventory is a singleton class
        ItemInventory itemInventory = itemInventoryBuilder.setDataPath(Path.itemDatasetPath).build();

        // create inventory of credit cards
        CardInventoryBuilder cardInventoryBuilder = new CardInventoryBuilder();
        // card inventory is a singleton class
        CardInventory cardInventory = cardInventoryBuilder.setDataPath(Path.cardDatasetPath).build();

        // create order
        OrderBuilder orderBuilder = new OrderBuilder();
        // card inventory is a singleton class
        Order order = orderBuilder.setDataPath(Path.orderPath).build();



    }
}
