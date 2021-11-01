package order;

import java.util.Map;

public class OrderRestriction {
    Map<String, Integer> map;

    public OrderRestriction(Map map){
        this.map = map;
    }

    @Override
    public String toString() {
        return "OrderRestriction{" +
                "map=" + map +
                '}';
    }
}
