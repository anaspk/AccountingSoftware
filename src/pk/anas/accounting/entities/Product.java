package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class Product
{
    private int productID;
    private int categoryID;
    private String productName;
    private double unitPurchasePrice;
    private double unitSalePrice;
    private String productDescription;
    private boolean inventoryItem;
    private InventoryItem inventoryRecord;

    public Product()
    {
        inventoryRecord = new InventoryItem();
    }
    
    public int getProductID()
    {
        return productID;
    }

    public void setProductID(int productID)
    {
        this.productID = productID;
    }

    public int getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getUnitPurchasePrice()
    {
        return unitPurchasePrice;
    }

    public void setUnitPurchasePrice(double unitPurchasePrice)
    {
        this.unitPurchasePrice = unitPurchasePrice;
    }

    public double getUnitSalePrice()
    {
        return unitSalePrice;
    }

    public void setUnitSalePrice(double unitSalePrice)
    {
        this.unitSalePrice = unitSalePrice;
    }

    public String getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(String productDescription)
    {
        this.productDescription = productDescription;
    }

    public void setInventoryItem(boolean inventoryItem)
    {
        this.inventoryItem = inventoryItem;
        if ( inventoryItem )
            inventoryRecord.setProductID( this.getProductID() );
    }

    public boolean isInventoryItem()
    {
        return inventoryItem;
    }
    
    public int getStockQuantity()
    {
        return inventoryRecord.getQuantityInStock();
    }
    
    public void setStockQuantity( int quantity )
    {
        inventoryRecord.setQuantityInStock( quantity );
    }
    
    public int getOrderQuantity()
    {
        return inventoryRecord.getQuantityOnOrder();
    }
    
    public void setOrderQuantity( int quantity )
    {
        inventoryRecord.setQuantityOnOrder( quantity );
    }
    
    public int getReorderQuantity()
    {
        return inventoryRecord.getReorderQuantity();
    }
    
    public void setReorderQuantity( int quantity )
    {
        inventoryRecord.setReorderQuantity( quantity );
    }
}
