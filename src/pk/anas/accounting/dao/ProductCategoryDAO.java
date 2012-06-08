package pk.anas.accounting.dao;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Muhammad Anas
 */
public class ProductCategoryDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewCategory = null;
    private PreparedStatement psUpdateCategory = null;
    private PreparedStatement psDeleteCategory = null;
    private PreparedStatement psCategoryNameByID = null;
    
    private final String sqlAddNewCategory = "INSERT INTO product_category " +
            "( parentCategoryID, " +
            "  categoryName, " +
            "  categoryDescription " +
            ") VALUES ( " +
            " ? , ? , ? );";
    
    private final String sqlUpdateCategory = "UPDATE product_category " +
            "SET " +
            "  parentCategoryID = ? , " +
            "  categoryName = ? , " +
            "  categoryDescription = ? " +
            "WHERE " +
            "  categoryID = ? ;";
    
    private final String sqlDeleteCategory = "DELETE FROM product_category " +
                                             "WHERE categoryID = ? ;";
    
    private final String sqlCategoryNameByID = "SELECT categoryName FROM product_category " +
                                               "WHERE categoryID = ? ;";
    
    public ProductCategoryDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewCategory = connection.prepareStatement( sqlAddNewCategory );
            psUpdateCategory = connection.prepareStatement( sqlUpdateCategory );
            psDeleteCategory = connection.prepareStatement( sqlDeleteCategory );
            psCategoryNameByID = connection.prepareStatement( sqlCategoryNameByID );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewCategory );
        close( psUpdateCategory );
        close( psDeleteCategory );
        close( psCategoryNameByID );
        connectionManager.closeConnection();
    }
    
    public void close( PreparedStatement ps )
    {
        if ( ps != null )
        {
            try
            {
                ps.close();
            }
            catch ( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
    
    public void addNewCategory( int pCatID, String name, String description )
    {
        open();
        
        try
        {
            psAddNewCategory.setInt( 1, pCatID );
            psAddNewCategory.setString( 2, name );
            psAddNewCategory.setString( 3, description );
            psAddNewCategory.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateCategory(int catID, int pCatID, String name, String description )
    {
        open();
        
        try
        {
            psUpdateCategory.setInt( 1, pCatID );
            psUpdateCategory.setString( 2, name );
            psUpdateCategory.setString( 3, description );
            psUpdateCategory.setInt( 4, catID );
            psUpdateCategory.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteCategory( int categoryID )
    {
        open();
        
        try
        {
            psDeleteCategory.setInt( 1, categoryID );
            psDeleteCategory.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public String getCategoryNameByID( int categoryID )
    {
        open();
        
        try
        {
            psCategoryNameByID.setInt( 1, categoryID );
            ResultSet resultSet = psCategoryNameByID.executeQuery();
            
            if ( resultSet.next() )
                return resultSet.getString( "categoryName" );
            else
                return null;
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            close();
        }
    }
    
    public CachedRowSet getDataForTableModel()
    {
        try
        {
            CachedRowSet rowSet = new CachedRowSetImpl();
            rowSet.setUsername( connectionManager.getUsername() );
            rowSet.setPassword( connectionManager.getPassword() );
            rowSet.setUrl( connectionManager.getUrl() );
            
            rowSet.setCommand( "SELECT categoryName AS 'Category Name', " +
                    "categoryDescription AS 'Category Description', " +
                    "categoryID AS 'Category ID', " +
                    "parentCategoryID AS 'Parent Category ID' " +
                    "FROM product_category;" );
            rowSet.execute();
            return rowSet;
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
            return null;
        }
    }
}
