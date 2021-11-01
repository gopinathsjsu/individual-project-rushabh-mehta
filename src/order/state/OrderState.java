package order.state;

import order.Order;

public interface OrderState {
    Order read(String path);
}
