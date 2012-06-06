package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Anas
 */
public class SalesOrderDetailDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewSalesOrderDetail = null;
    private PreparedStatement psUpdateSalesOrderDetail = null;
    private PreparedStatement psDeleteSalesOrderDetail = null;
    
    private final String sqlAddNewSalesOrderDetail = "INSERT INTO sales_order_detail " +
            "( salesOrderID, " +
            "  productID, " +
            "  productQuantity " +
            ") VALUES ( " +
            " ? , ? , ? );";
    
    private final String sqlUpdateSalesOrderDetail = "UPDATE sales_order_detail " +
            "SET " +
            "  salesOrderID = ? , " +
            "  productID = ? , " +
            "  productQuantity = ? " +
            "WHERE " +
            "  orderDetailID = ? ;";
    
    private final String sqlDeleteSalesOrderDetail = "DELETE FROM sales_order_detail " +
                                                     "WHERE orderDetailID = ? ;";
    
    public void SalesOrderDetailDAO( ConnectionManager connectionManager )
    {
        
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewSalesOrderDetail = connection.prepareStatement( sqlAddNewSalesOrderDetail );
            psUpdateSalesOrderDetail = connection.prepareStatement( sqlUpdateSalesOrderDetail );
            psDeleteSalesOrderDetail = connection.prepareStatement( sqlDeleteSalesOrderDetail );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewSalesOrderDetail );
        close( psUpdateSalesOrderDetail );
        close( psDeleteSalesOrderDetail );
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
    
    public void addNewSalesOrderDetail( int orderId, int productID, int quantity )
    {
        open();
        
        try
        {
            psAddNewSalesOrderDetail.setInt( 1, orderId );
            psAddNewSalesOrderDetail.setInt( 2, productID );
            psAddNewSalesOrderDetail.setInt( 3, quantity );
            psAddNewSalesOrderDetail.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateSalesOrderDetail( int orderDetailID, int orderID, int productID, int quantity )
    {
        open();
        
        try
        {
            psUpdateSalesOrderDetail.setInt( 1, orderID );
            psUpdateSalesOrderDetail.setInt( 2, productID );
            psUpdateSalesOrderDetail.setInt( 3, quantity );
            psUpdateSalesOrderDetail.setInt( 4, orderDetailID );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteSalesOrderDetail( int orderDetailID )
    {
        open();
        
        try
        {
            psDeleteSalesOrderDetail.setInt( 1, orderDetailID );
            psDeleteSalesOrderDetail.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
