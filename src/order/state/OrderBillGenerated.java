package order.state;

import card.Card;
import inventory.CardInventory;
import order.Order;
import order.OrderItem;
import order.OrderProcessor;

import java.util.List;
import java.util.Set;

public class OrderBillGenerated extends OrderStateSup {
    public OrderBillGenerated(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    @Override
    public void saveCardDetails(Order order) {
        CardInventory inventory = CardInventory.getInstance();
        Set<Card> cardInventory = inventory.getInventory();
        List<OrderItem> orderItems = order.getItems();
        for(OrderItem orderItem : orderItems){
            if(!cardInventory.contains(new Card(orderItem.getCardNumber()))){
                System.out.println(orderItem.getCardNumber());
                cardInventory.add(new Card(orderItem.getCardNumber()));
            }
        }
        System.out.println("Card details added.");
        orderProcessor.setCurrState(OrderStates.CARDDETAILSSAVED);
    }
}
