package order.state;

import card.Card;
import inventory.CardInventory;
import order.Order;
import order.OrderItem;
import order.OrderProcessor;
import resources.Path;
import writer.CsvWriter;
import writer.Writer;

import java.util.List;
import java.util.Map;
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
                cardInventory.add(new Card(orderItem.getCardNumber()));
            }
        }
        StringBuilder message = new StringBuilder();
        message.append("Card Number");
        message.append("\n");
        for(Card card : cardInventory){
            message.append(card.getNumber());
            message.append("\n");
        }
        Writer writer = new CsvWriter();
        writer.write(Path.cardDatasetPath,message);
        System.out.println("Card details added to database.");
        orderProcessor.setCurrState(OrderStates.CARDDETAILSSAVED);
    }
}
