package order.state;

import inventory.ItemInventory;
import item.Item;
import order.Order;
import order.OrderItem;
import order.OrderProcessor;
import order.OrderRestriction;
import resources.Path;
import writer.CsvWriter;
import writer.Writer;

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
            StringBuilder invalidMessage = new StringBuilder();
            invalidMessage.append("Please correct quantities.");
            invalidMessage.append("\n");
            for(String category : invalidCategories){
                invalidMessage.append(category);
                invalidMessage.append("\n");
            }
            Writer writer = new CsvWriter();
            writer.write(Path.outputPath,invalidMessage);
            orderProcessor.setCurrState(OrderStates.INVALID);
        }else{
            System.out.println("Restrictions met!");
            orderProcessor.setCurrState(OrderStates.RESTRICTIONVALIDATED);
        }
    }
}
