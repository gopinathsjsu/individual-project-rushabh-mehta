package order;

import inventory.CardInventory;

import java.util.Map;

public class OrderRestriction {
    private Map<String, Integer> map;
    private static OrderRestriction instance = null;

    private OrderRestriction(){

    }

    public static OrderRestriction getInstance(){
        if(instance==null){
            instance = new OrderRestriction();
        }
        return instance;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "OrderRestriction{" +
                "map=" + map +
                '}';
    }
}
