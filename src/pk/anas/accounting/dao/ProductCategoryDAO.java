package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    private final String sqlAddNewCategory = "" +
            "";
    
    private final String sqlUpdateCategory = "" +
            "";
    
    private final String sqlDeleteCategory = "" +
            "";
    
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
}
