package pk.anas.accounting.entities;

import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class SalesOrder
{
    private int orderID;
    private int customerID;
    private Timestamp orderTimestamp;
    private String PaymentMethod;
    private double orderDiscount;
    private double orderSubtotal;
    private double amountPaid;

    public int getOrderID()
    {
        return orderID;
    }

    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public Timestamp getOrderTimestamp()
    {
        return orderTimestamp;
    }

    public void setOrderTimestamp(Timestamp orderTimestamp)
    {
        this.orderTimestamp = orderTimestamp;
    }

    public String getPaymentMethod()
    {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod)
    {
        this.PaymentMethod = PaymentMethod;
    }

    public double getOrderDiscount()
    {
        return orderDiscount;
    }

    public void setOrderDiscount(double orderDiscount)
    {
        this.orderDiscount = orderDiscount;
    }

    public double getOrderSubtotal()
    {
        return orderSubtotal;
    }

    public void setOrderSubtotal(double orderSubtotal)
    {
        this.orderSubtotal = orderSubtotal;
    }

    public double getAmountPaid()
    {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid)
    {
        this.amountPaid = amountPaid;
    }
}
