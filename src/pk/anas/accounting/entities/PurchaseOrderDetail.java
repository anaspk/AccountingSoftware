package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class PurchaseOrderDetail
{
    private int orderDetailID;
    private int purchaseOrderID;
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

    public int getPurchaseOrderID()
    {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(int purchaseOrderID)
    {
        this.purchaseOrderID = purchaseOrderID;
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
