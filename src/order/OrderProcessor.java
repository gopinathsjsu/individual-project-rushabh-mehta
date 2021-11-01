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
    private OrderState orderInvalid;
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
        orderInvalid = new OrderInvalid(this);
        currState = orderInit;
    }

    public int processOrder(String path){
        this.order = currState.read(path);
        currState.checkStock(order);
        currState.checkOrderRestrictions(order);
//        currState.generateBill();
//        currState.saveCardDetails();
//        currState.markOrderCompleted();
        return -1;
    }

    public void setCurrState(OrderStates nextState) {
        switch (nextState){
            case READ:
                this.currState = orderRead;
                break;
            case INVALID:
                this.currState = orderInvalid;
                break;
            case DBVALIDATED:
                this.currState = orderDBValidated;
                break;
            case RESTRICTIONVALIDATED:
                this.currState = orderRestrictionValidated;
                break;
        }
    }
}
