package order.state;

import inventory.ItemInventory;
import item.Item;
import order.Order;
import order.OrderItem;
import order.OrderProcessor;
import order.OrderRestriction;

import java.util.*;

public class OrderDBValidated extends OrderStateSup{
    public OrderDBValidated(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }
    public void checkOrderRestrictions(Order order){
        //TODO write to file and output item instead of category
        List<String> invalidCategories = new ArrayList<>();
        List<OrderItem> orderItems = order.getItems();
        Map<String, Integer> orderQuantities = new HashMap<>();
        ItemInventory inventory = ItemInventory.getInstance();
        Map<String, Item> inventoryItems= inventory.getInventory();
        for(OrderItem orderItem: orderItems){
            String orderItemcategory = inventoryItems.get(orderItem.getName()).getCategory();
          if(orderQuantities.containsKey(orderItemcategory)){
            orderQuantities.put(orderItemcategory,orderQuantities.get(orderItemcategory)+orderItem.getQuantity());
          }else{
              orderQuantities.put(orderItemcategory,orderItem.getQuantity());
          }
        }
        OrderRestriction orderRestriction = OrderRestriction.getInstance();
        Map<String, Integer> restrictionMap= orderRestriction.getMap();
        for(Map.Entry set : orderQuantities.entrySet()){
            if(restrictionMap.containsKey(set.getKey())){

                if((Integer)set.getValue()>(restrictionMap.get(set.getKey()))){
                    invalidCategories.add((String) set.getKey());
                }
            }
        }
        if(invalidCategories.size()>0){
            System.out.println("Please correct quantities to meet restriction cap.");
            for(String category : invalidCategories){
                System.out.println(category);
            }
            orderProcessor.setCurrState(OrderStates.INVALID);
        }else{
            System.out.println("Restrictions met!");
            orderProcessor.setCurrState(OrderStates.RESTRICTIONVALIDATED);
        }
    }
}
