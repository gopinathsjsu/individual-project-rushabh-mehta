package order.builder;

import builder.Builder;
import builder.RestrictionBuilder;
import order.OrderRestriction;

import java.util.HashMap;
import java.util.Map;

public class OrderRestrictionBuilder implements RestrictionBuilder {
    Map<String, Integer> map;

    public OrderRestrictionBuilder() {
        this.map = new HashMap<>();
    }

    @Override
    public OrderRestriction build() {
        OrderRestriction orderRestriction = OrderRestriction.getInstance();
        orderRestriction.setMap(this.map);
        System.out.println(orderRestriction);
        System.out.println("Order Restrictions set!");
        return orderRestriction;
    }

    @Override
    public OrderRestrictionBuilder setRestriction(String category, int quantity) {
        this.map.put(category, quantity);
        return this;
    }
}
