package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class InventoryItem
{
    private int productID;
    private int quantityInStock;
    private int quantityOnOrder;
    private int reorderQuantity;

    public int getProductID()
    {
        return productID;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public int getQuantityInStock()
    {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock)
    {
        this.quantityInStock = quantityInStock;
    }

    public int getQuantityOnOrder()
    {
        return quantityOnOrder;
    }

    public void setQuantityOnOrder(int quantityOnOrder)
    {
        this.quantityOnOrder = quantityOnOrder;
    }

    public int getReorderQuantity()
    {
        return reorderQuantity;
    }

    public void setReorderQuantity(int reorderQuantity)
    {
        this.reorderQuantity = reorderQuantity;
    }
    
    
}
