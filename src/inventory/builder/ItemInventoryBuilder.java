package inventory.builder;

import builder.Builder;
import builder.InventoryBuilder;
import inventory.ItemInventory;
import item.Item;
import reader.CsvItemReader;
import reader.CsvReader;

public class ItemInventoryBuilder implements InventoryBuilder {
    private String dataPath;
    public ItemInventory build(){
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
        System.out.println(inventory.getInventory());
        System.out.println(count+" items added.");
        System.out.println("Inventory built!");
        return inventory;
    }

    public ItemInventoryBuilder setDataPath(String dataPath) {
        this.dataPath = dataPath;
        return this;
    }
}
