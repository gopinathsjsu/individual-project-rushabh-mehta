package order.state;

import order.OrderProcessor;

public class OrderProcessed extends OrderStateSup{
    public OrderProcessed(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }
}
