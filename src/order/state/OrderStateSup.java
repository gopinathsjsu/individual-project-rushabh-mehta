package order.state;

import order.Order;
import order.OrderProcessor;

public class OrderStateSup implements OrderState{
    OrderProcessor orderProcessor;

    public OrderStateSup(OrderProcessor orderProcessor) {
        this.orderProcessor = orderProcessor;
    }

    //TODO handle failure cases
    @Override
    public Order read(String path) {
        System.out.println("Order already read!");
        return null;
    }

    @Override
    public void checkStock(Order order) {
        System.out.println("Invalid state!");
    }

    @Override
    public void checkOrderRestrictions(Order order){
        System.out.println("Invalid state");
    }

    @Override
    public void generateBill(Order order) {
        System.out.println("Invalid state");
    }

    @Override
    public void saveCardDetails(Order order) {
        System.out.println("Invalid state");
    }

    @Override
    public void markOrderCompleted(Order order) {
        System.out.println("Invalid state");
    }
}
