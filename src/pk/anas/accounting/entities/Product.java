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
    private boolean isInventoryItem;

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

    public boolean isIsInventoryItem()
    {
        return isInventoryItem;
    }

    public void setIsInventoryItem(boolean isInventoryItem)
    {
        this.isInventoryItem = isInventoryItem;
    }
}
