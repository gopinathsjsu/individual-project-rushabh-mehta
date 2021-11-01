package order;


import order.state.*;



public class OrderProcessor {
    private OrderState currState;
    private final OrderState orderInit;
    private final OrderState orderRead;
    private final OrderState orderDBValidated;
    private final OrderState orderRestrictionValidated;
    private final OrderState orderBillGenerated;
    private final OrderState orderCardDetailsSaved;
    private final OrderState orderProcessed;
    private final OrderState orderInvalid;
    Order order;

    public OrderProcessor(){
        this.orderInit = new OrderInit(this);
        this.orderRead = new OrderRead(this);
        this.orderDBValidated = new OrderDBValidated(this);
        this.orderRestrictionValidated = new OrderRestrictionValidated(this);
        this.orderBillGenerated = new OrderBillGenerated(this);
        this.orderCardDetailsSaved = new OrderCardDetailsSaved(this);
        this.orderProcessed = new OrderProcessed(this);
        this.orderInvalid = new OrderInvalid(this);
        this.currState = this.orderInit;
    }

    public void processOrder(String path){
        this.order = currState.read(path);
        currState.checkStock(order);
        currState.checkOrderRestrictions(order);
        currState.generateBill(order);
        currState.saveCardDetails(order);
        currState.markOrderCompleted(order);
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
            case BILLGENERATED:
                this.currState = orderBillGenerated;
                break;
            case CARDDETAILSSAVED:
                this.currState = orderCardDetailsSaved;
                break;
            case ORDERPROCESSED:
                this.currState = orderProcessed;
                break;
        }
    }
}
