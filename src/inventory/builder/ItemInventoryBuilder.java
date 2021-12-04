package inventory.builder;

import builder.Builder;
import builder.InventoryBuilder;
import inventory.ItemInventory;
import item.Item;
import reader.CsvItemReader;
import reader.CsvReader;

import java.util.Map;

public class ItemInventoryBuilder implements InventoryBuilder {
    private String dataPath;
    public ItemInventory build(){
        System.out.println("===============");
        System.out.println("Building Item Inventory!");
        ItemInventory inventory = ItemInventory.getInstance();
        CsvReader<Item> reader = new CsvItemReader();
        int count = 0;
        reader.open(this.dataPath);
        reader.readHeader();
        Item item;
        while((item = reader.read()) != null){
            count++;
            inventory.add(item);
        }
        System.out.println(count+" items added.");
        printItemInventory(inventory.getInventory());
        System.out.println("Item Inventory built!");
        System.out.println("===============");
        return inventory;
    }

    public ItemInventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }

    public void printItemInventory(Map<String, Item> map){
        for (Map.Entry<String, Item> set :
                map.entrySet()) {

            // Printing all elements of a Map
            System.out.println(set.getKey() + " = "
                    + set.getValue());
        }
    }
}
