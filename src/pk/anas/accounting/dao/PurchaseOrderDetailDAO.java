package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Anas
 */
public class PurchaseOrderDetailDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewPurchaseOrderDetail = null;
    private PreparedStatement psUpdatePurchaseOrderDetail = null;
    private PreparedStatement psDeletePurchaseOrderDetail = null;
    
    private final String sqlAddNewPurchaseOrderDetail = "INSERT INTO purchase_order_detail " +
            "( purchaseOrderID, " +
            "  productID, " +
            "  productQuantity " +
            ") VALUES ( " +
            " ? , ? , ? );";
    
    private final String sqlUpdatePurchaseOrderDetail = "UPDATE purchase_order_detail " +
            "SET " +
            "  purchaseOrdeID = ? , " +
            "  productID = ? , " +
            "  productQuantity = ? " +
            "WHERE " +
            "  orderDetailID = ? ;";
    
    private final String sqlDeletePurchaseOrderDetail = "DELETE FROM purchase_order_detail " +
                                                        "WHERE orderDetailID = ? ;";
    
    public PurchaseOrderDetailDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewPurchaseOrderDetail = connection.prepareStatement( sqlAddNewPurchaseOrderDetail );
            psUpdatePurchaseOrderDetail = connection.prepareStatement( sqlUpdatePurchaseOrderDetail );
            psDeletePurchaseOrderDetail = connection.prepareStatement( sqlDeletePurchaseOrderDetail );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewPurchaseOrderDetail );
        close( psUpdatePurchaseOrderDetail );
        close( psDeletePurchaseOrderDetail );
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
    
    public void addNewPurchaseOrderDetail( int orderID, int productID, int quantity )
    {
        open();
        
        try
        {
            psAddNewPurchaseOrderDetail.setInt( 1, orderID );
            psAddNewPurchaseOrderDetail.setInt( 2, productID );
            psAddNewPurchaseOrderDetail.setInt( 3, quantity );
            psAddNewPurchaseOrderDetail.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updatePurchaseOrderDetail( int orderDetailID, int orderID, int productID, int quantity )
    {
        open();
        
        try
        {
            psUpdatePurchaseOrderDetail.setInt( 1, orderID );
            psUpdatePurchaseOrderDetail.setInt( 2, productID );
            psUpdatePurchaseOrderDetail.setInt( 3, quantity );
            psUpdatePurchaseOrderDetail.setInt( 4, orderDetailID );
            psUpdatePurchaseOrderDetail.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deletePurchaseOrderDetail(int orderDetailID )
    {
        open();
        
        try
        {
            psDeletePurchaseOrderDetail.setInt( 1, orderDetailID );
            psDeletePurchaseOrderDetail.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
