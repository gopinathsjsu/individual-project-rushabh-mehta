package order.state;

import order.Order;

public interface OrderState {
    Order read(String path);
    void checkStock(Order order);
    void checkOrderRestrictions(Order order);
    void generateBill(Order order);
    void saveCardDetails(Order order);
    void markOrderCompleted(Order order);
}
