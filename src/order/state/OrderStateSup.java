package order.state;

import order.Order;
import order.OrderProcessor;

public class OrderStateSup implements OrderState{
    OrderProcessor orderProcessor;

    public OrderStateSup(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    @Override
    public Order read(String path) {
        System.out.println("Order already read!");
        return null;
    }
}
