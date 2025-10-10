package model;

public class Order {

    private String orderId;
    private String customerId;
    private double amount;
    private OrderStatus status;

    public enum OrderStatus {
        PENDING, PROCESSING, COMPLETED, FAILED
    }

    public Order(String orderId, String customerId, double amount){
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getOrderId(){
        return orderId;
    }

    public String setOrderId(String orderId){
        return this.orderId = orderId;
    }


    public String getCustomerId(){
        return customerId;
    }

    public String setCustomerId(String customerId){
        return this.customerId = customerId;
    }


    public double getAmount(){
        return amount;
    }

    public double setAmount(double amount){
        return this.amount = amount;
    }


    public OrderStatus getStatus(){
        return status;
    }

    public OrderStatus setStatus(OrderStatus status){
        return this.status = status; 
    }
}
