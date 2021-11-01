package app;

import builder.RestrictionBuilder;
import inventory.CardInventory;
import inventory.ItemInventory;
import inventory.builder.CardInventoryBuilder;
import inventory.builder.ItemInventoryBuilder;
import order.Order;
import order.OrderProcessor;
import order.builder.OrderBuilder;
import order.builder.OrderRestrictionBuilder;
import resources.Path;

public class OrderApp {
    public static void main(String[] args){
        // create inventory of items
        ItemInventoryBuilder itemInventoryBuilder = new ItemInventoryBuilder();
        // item inventory is a singleton class
        ItemInventory itemInventory = itemInventoryBuilder.setDataPath(Path.itemDatasetPath).build();

        // create inventory of credit cards
        CardInventoryBuilder cardInventoryBuilder = new CardInventoryBuilder();
        // card inventory is a singleton class
        CardInventory cardInventory = cardInventoryBuilder.setDataPath(Path.cardDatasetPath).build();

        OrderRestrictionBuilder orderRestrictionBuilder = new OrderRestrictionBuilder();
        // TODO change restrictions to enum
        orderRestrictionBuilder.setRestriction("Essential",10).setRestriction("Luxury",10).setRestriction("Misc", 10).build();

        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(Path.orderPath);
    }
}
