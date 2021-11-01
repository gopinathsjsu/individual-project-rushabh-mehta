package order.state;

import order.Order;
import order.OrderProcessor;

public class OrderCardDetailsSaved extends OrderStateSup{
    public OrderCardDetailsSaved(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    @Override
    public void markOrderCompleted(Order order) {
        System.out.println("Order processed!");
        orderProcessor.setCurrState(OrderStates.ORDERPROCESSED);
    }
}
