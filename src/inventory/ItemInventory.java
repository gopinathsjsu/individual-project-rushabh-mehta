package inventory;

import item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemInventory implements Inventory<Item,Map<String,Item>>{
    private Map<String, Item> inventory;
    private static ItemInventory instance = null;

    private ItemInventory() {
        inventory = new HashMap<>();
    }

    public static ItemInventory getInstance(){
        if(instance==null){
            instance = new ItemInventory();
        }
        return instance;
    }

    public boolean add(Item item){
        inventory.put(item.getName(), item);
        return true;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }
}
