package order;


import order.state.*;



public class OrderProcessor {
    private OrderState currState;
    private OrderState orderInit;
    private OrderState orderRead;
    private OrderState orderDBValidated;
    private OrderState orderRestrictionValidated;
    private OrderState orderCompValidated;
    private OrderState orderBillGenerated;
    private OrderState orderCardDetailsSaved;
    private OrderState orderProcessed;
    Order order;

    public OrderProcessor(){
        orderInit = new OrderInit(this);
        orderRead = new OrderRead(this);
        orderDBValidated = new OrderDBValidated(this);
        orderRestrictionValidated = new OrderRestrictionValidated(this);
        orderCompValidated = new OrderCompValidated(this);
        orderCardDetailsSaved = new OrderBillGenerated(this);
        orderCardDetailsSaved = new OrderCardDetailsSaved(this);
        orderProcessed = new OrderProcessed(this);
        currState = orderInit;
    }

    public int processOrder(String path){
        this.order = currState.read(path);
        return -1;
    }

    public void setCurrState(OrderStates nextState) {
        switch (nextState){
            case READ:
                this.currState = orderRead;
                break;
        }
    }
}
