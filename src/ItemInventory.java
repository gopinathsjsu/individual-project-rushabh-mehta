import java.util.HashMap;
import java.util.Map;

public class ItemInventory {
    private Map<Item, Integer> inventory;
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

    public boolean addItem(Item item, int quantity){
        inventory.put(item, quantity);
        return true;
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }
}
