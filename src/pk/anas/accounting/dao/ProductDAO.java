package pk.anas.accounting.dao;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Muhammad Anas
 */
public class ProductDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewProduct = null;
    private PreparedStatement psUpdateProduct = null;
    private PreparedStatement psDeleteProduct = null;
    
    private final String sqlAddNewProduct = "INSERT INTO product " +
            "( categoryID, " +
            "  productName, " +
            "  unitPurchasePrice, " +
            "  unitSalePrice, " +
            "  productDescription, " +
            "  isInventoryItem " +
            ") VALUES ( " +
            " ? , ? , ? , ? , ? , ? );";
    
    private final String sqlUpdateproduct = "UPDATE product " +
            "SET " +
            "  categoryID = ? , " +
            "  productName = ? , " +
            "  unitPurchasePrice = ? , " +
            "  unitSalePrice = ? , " +
            "  productDescription = ? , " +
            "  isInventoryItem = ? " +
            "WHERE " +
            "  productID = ? ;";
    
    private final String sqlDeleteProduct = "DELETE FROM product  " +
                                            "WHERE productID = ? ;";
    
    public ProductDAO( ConnectionManager conectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewProduct = connection.prepareStatement( sqlAddNewProduct );
            psUpdateProduct = connection.prepareStatement( sqlUpdateproduct );
            psDeleteProduct = connection.prepareStatement( sqlDeleteProduct );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewProduct );
        close( psUpdateProduct );
        close( psDeleteProduct );
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
    
    public void addNewProduct( int catID, String name, double pPrice, double sPrice, String description, boolean isInventoryItem )
    {
        open();
        
        try
        {
            psAddNewProduct.setInt( 1, catID );
            psAddNewProduct.setString( 2, name );
            psAddNewProduct.setDouble( 3 , pPrice );
            psAddNewProduct.setDouble( 4, sPrice );
            psAddNewProduct.setString( 5, description );
            psAddNewProduct.setBoolean( 6, isInventoryItem );
            psAddNewProduct.executeUpdate();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateProduct( int productID, int catID, String name, double pPrice, double sPrice, String description, boolean isInventoryItem)
    {
        open();
        
        try
        {
            psUpdateProduct.setInt( 1, catID );
            psUpdateProduct.setString( 2, name );
            psUpdateProduct.setDouble( 3 , pPrice );
            psUpdateProduct.setDouble( 4, sPrice );
            psUpdateProduct.setString( 5, description );
            psUpdateProduct.setBoolean( 6, isInventoryItem );
            psUpdateProduct.setInt( 7, productID );
            psUpdateProduct.executeUpdate();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteProduct( int productID )
    {
        open();
        
        try
        {
            psDeleteProduct.setInt( 1, productID );
            psDeleteProduct.executeUpdate();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public CachedRowSet getDataForTableModel()
    {
        try
        {
            CachedRowSet rowSet = new CachedRowSetImpl();
            rowSet.setUsername( connectionManager.getUsername() );
            rowSet.setPassword( connectionManager.getPassword() );
            rowSet.setUrl( connectionManager.getUrl() );
            
            rowSet.setCommand( "SELECT productID AS 'Product ID', " +
                    "productName AS 'Product Name', " +
                    "unitPurchasePrice AS 'Purchase Price', " +
                    "unitSalePrice AS 'Sale Price', " +
                    "productDescription AS Description " +
                    "FROM product;" );
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
