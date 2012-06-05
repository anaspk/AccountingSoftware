package pk.anas.accounting.entities;

import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class PurchaseOrder
{
    private int orderID;
    private int supplierID;
    private Timestamp orderTimestamp;
    private String paymentMethod;
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

    public int getSupplierID()
    {
        return supplierID;
    }

    public void setSupplierID(int supplierID)
    {
        this.supplierID = supplierID;
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
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
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
