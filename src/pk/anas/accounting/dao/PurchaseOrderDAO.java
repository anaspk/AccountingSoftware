package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class PurchaseOrderDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewPurchaseOrder = null;
    private PreparedStatement psUpdatePurchaseOrder = null;
    private PreparedStatement psDeletePurchaseOrder = null;
    
    private final String sqlAddNewPurchaseOrder = "INSERT INTO purchase_order " +
            "( supplierID, " +
            "  orderTimestamp, " +
            "  paymentMethod, " +
            "  orderSubtotal, " +
            "  amountPaid " +
            ") VALUES ( " +
            " ? , ? , ? , ? , ? );";
    
    private final String sqlUpdatePurchaseOrder = "UPDATE purchase_order " +
            "SET " +
            "  supplierID = ? , " +
            "  orderTimestamp = ? , " +
            "  paymentMethod = ?  " + 
            "WHERE " +
            "  orderID = ? ;";
    
    private final String sqlDeletePurchaseOrder = "DELETE FROM purchase_order " +
                                                  "WHERE orderID = ? ;";
    
    public PurchaseOrderDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewPurchaseOrder = connection.prepareStatement( sqlAddNewPurchaseOrder );
            psUpdatePurchaseOrder = connection.prepareStatement( sqlUpdatePurchaseOrder );
            psDeletePurchaseOrder = connection.prepareStatement( sqlDeletePurchaseOrder );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewPurchaseOrder );
        close( psUpdatePurchaseOrder );
        close( psDeletePurchaseOrder );
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
    
    public void addNewPurchaseOrder( int supplierID, Timestamp timestamp, String paymentMethod, double subtotal, double amountPaid )
    {
        open();
        
        try
        {
            psAddNewPurchaseOrder.setInt( 1, supplierID );
            psAddNewPurchaseOrder.setTimestamp( 2, timestamp );
            psAddNewPurchaseOrder.setString( 3, paymentMethod );
            psAddNewPurchaseOrder.setDouble( 4, subtotal );
            psAddNewPurchaseOrder.setDouble( 5, amountPaid );
            psAddNewPurchaseOrder.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updatePurchaseOrder( int orderID, int supplierID, Timestamp timestamp, String paymentMethod )
    {
        open();
        
        try
        {
            psUpdatePurchaseOrder.setInt( 1, supplierID );
            psUpdatePurchaseOrder.setTimestamp( 2, timestamp );
            psUpdatePurchaseOrder.setString( 3, paymentMethod );
            psUpdatePurchaseOrder.setInt( 4, orderID );
            psUpdatePurchaseOrder.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deletePurchaseOrder( int orderID )
    {
        open();
        
        try
        {
            psDeletePurchaseOrder.setInt( 1, orderID );
            psDeletePurchaseOrder.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
