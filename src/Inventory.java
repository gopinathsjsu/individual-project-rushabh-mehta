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

    public boolean addItem(String itemStr){
        String[] itemData = itemStr.split(",");
        if(itemData.length!=4){
            return false;
        }
        String category = itemData[0];
        String name = itemData[1];
        int quantity = Integer.parseInt(itemData[2]);
        double price = Double.parseDouble(itemData[3]);
        Item item = new Item(category, name, price);
        inventory.put(item, quantity);
        return true;
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }
}
