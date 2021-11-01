package order.state;

import order.Order;
import order.OrderProcessor;
import order.builder.OrderBuilder;
import resources.Path;

public class OrderInit extends OrderStateSup{

    public OrderInit(OrderProcessor orderProcessor) {
        super(orderProcessor);
    }

    public Order read(String path){
        // read order from file
        OrderBuilder orderBuilder = new OrderBuilder();
        Order order = orderBuilder.setDataPath(path).build();
        orderProcessor.setCurrState(OrderStates.READ);
        return order;
    }
}
