package order.state;

import order.OrderProcessor;

public class OrderRestrictionValidated extends OrderStateSup{
    public OrderRestrictionValidated(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }
}
