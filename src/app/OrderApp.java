package app;

import inventory.CardInventory;
import inventory.ItemInventory;
import inventory.builder.CardInventoryBuilder;
import inventory.builder.ItemInventoryBuilder;
import order.Order;
import order.OrderProcessor;
import order.builder.OrderBuilder;
import resources.Path;

public class OrderApp {
    public static void main(String[] args){
        // TODO prepare item database - DONE
        // TODO prepare card database - DONE
        // TODO read input order csv file - DONE
        // TODO process order
            // TODO

        // TODO generate output total amount csv



        // create inventory of items
        ItemInventoryBuilder itemInventoryBuilder = new ItemInventoryBuilder();
        // item inventory is a singleton class
        ItemInventory itemInventory = itemInventoryBuilder.setDataPath(Path.itemDatasetPath).build();

        // create inventory of credit cards
        CardInventoryBuilder cardInventoryBuilder = new CardInventoryBuilder();
        // card inventory is a singleton class
        CardInventory cardInventory = cardInventoryBuilder.setDataPath(Path.cardDatasetPath).build();

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(Path.orderPath);
    }
}
