package order.state;

public enum OrderStates {
    INIT,
    READ,
    DBVALIDATED,
    RESTRICTIONVALIDATED,
    BILLGENERATED,
    CARDDETAILSSAVED,
    ORDERPROCESSED,
    INVALID
}
