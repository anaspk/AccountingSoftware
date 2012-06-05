package pk.anas.accounting.entities;

/**
 *
 * @author Muhammad Anas
 */
public class ProductCategory
{
    private int categoryID;
    private int parentCategoryID;
    private String categoryName;
    private String categoryDescription;

    public int getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }

    public int getParentCategoryID()
    {
        return parentCategoryID;
    }

    public void setParentCategoryID(int parentCategoryID)
    {
        this.parentCategoryID = parentCategoryID;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription()
    {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription)
    {
        this.categoryDescription = categoryDescription;
    }
}
