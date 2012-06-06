package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class SalesOrderDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewSalesOrder = null;
    private PreparedStatement psUpdateSalesOrder = null;
    private PreparedStatement psDeleteSalesOrder = null;
    
    private final String sqlAddNewSalesOrder = "INSERT INTO sales_order " +
            "( customerID, " +
            "  orderTimestamp, " +
            "  paymentMethod, " +
            "  orderDiscount, " +
            "  orderSubtotal, " +
            "  amountPaid " +
            ") VALUES ( " +
            " ? , ? , ? , ? , ? , ? );";
    
    private final String sqlUpdateSalesOrder = "UPDATE sales_order " +
            "SET " +
            "  customerID = ? , " +
            "  orderTimestamp = ? , " +
            "  paymentMethod = ? " +
            "WHERE " +
            "  orderID = ? ;";
    
    private final String sqlDeleteSalesOrder = "DELETE FROM sales_order " +
                                               "WHERE orderID = ? ;";
    
    public SalesOrderDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewSalesOrder = connection.prepareStatement( sqlAddNewSalesOrder );
            psUpdateSalesOrder = connection.prepareStatement( sqlUpdateSalesOrder );
            psDeleteSalesOrder = connection.prepareStatement( sqlDeleteSalesOrder );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewSalesOrder );
        close( psUpdateSalesOrder );
        close( psDeleteSalesOrder );
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
    
    public void addNewSalesOrder( int customerID, Timestamp timestamp, String paymentMethod, double discount, double subtotal, double amountPaid )
    {
        open();
        
        try
        {
            psAddNewSalesOrder.setInt( 1, customerID );
            psAddNewSalesOrder.setTimestamp( 2, timestamp );
            psAddNewSalesOrder.setString( 3, paymentMethod );
            psAddNewSalesOrder.setDouble( 4, discount );
            psAddNewSalesOrder.setDouble( 5, subtotal );
            psAddNewSalesOrder.setDouble( 6, amountPaid );
            psAddNewSalesOrder.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateSalesOrder( int orderID, int customerID, Timestamp timestamp, String paymentMethod )
    {
        open();
        
        try
        {
            psUpdateSalesOrder.setInt( 1, customerID );
            psUpdateSalesOrder.setTimestamp( 2, timestamp );
            psUpdateSalesOrder.setString( 3, paymentMethod );
            psUpdateSalesOrder.setInt( 4, orderID );
            psUpdateSalesOrder.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteSalesOrder( int orderID )
    {
        open();
        
        try
        {
            psDeleteSalesOrder.setInt( 1, orderID );
            psDeleteSalesOrder.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
