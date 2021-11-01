package order.state;

import order.OrderProcessor;

public class OrderInvalid extends OrderStateSup{
    public OrderInvalid(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

}
