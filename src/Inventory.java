import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Inventory {
    private Map<Item, Integer> inventory;
    private static Inventory instance = null;

    private Inventory() {
        inventory = new HashMap<>();
    }

    public static Inventory getInstance(){
        if(instance==null){
            instance = new Inventory();
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
