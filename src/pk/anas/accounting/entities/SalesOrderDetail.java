package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class SalesOrderDetail
{
    private int orderDetailID;
    private int salesOrderID;
    private int productID;
    private int productQuantity;

    public int getOrderDetailID()
    {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID)
    {
        this.orderDetailID = orderDetailID;
    }

    public int getSalesOrderID()
    {
        return salesOrderID;
    }

    public void setSalesOrderID(int salesOrderID)
    {
        this.salesOrderID = salesOrderID;
    }

    public int getProductID()
    {
        return productID;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public int getProductQuantity()
    {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity)
    {
        this.productQuantity = productQuantity;
    }
}
