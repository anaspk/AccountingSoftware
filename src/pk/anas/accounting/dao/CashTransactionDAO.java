package pk.anas.accounting.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Anas
 */
public class CashTransactionDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psNewCashTransaction = null;
    private PreparedStatement psUpdateCashTransaction = null;
    private PreparedStatement psDeleteCashTransaction = null;
    
    private final String sqlNewCashTransaction = "INSERT INTO cash_transaction " +
            "( transactionAmount, " +
            "  cashInHand, " +
            "  transactionTimestamp, " +
            "  transactionDescription, " +
            "  isCredit " +
            ") VALUES ( " +
            " ? , ? , ? , ? , ? );";
    
    private final String sqlUpdateCashTransaction = "UPDATE cash_transaction " +
            "SET " +
            "  transactionDescription = ? , " +
            "  transactionTimestamp = ? " +
            "WHERE " +
            "  transactionID = ? ;";
    
    private final String sqlDeleteCashTransaction = "DELETE FROM cash_transaction " +
            "WHERE transactionID = ? ;" ;
    
    public CashTransactionDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psNewCashTransaction = connection.prepareStatement( sqlNewCashTransaction );
            psUpdateCashTransaction = connection.prepareStatement( sqlUpdateCashTransaction );
            psDeleteCashTransaction = connection.prepareStatement( sqlDeleteCashTransaction );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psNewCashTransaction );
        close( psUpdateCashTransaction );
        close( psDeleteCashTransaction );
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
    
    public void performNewTransaction( double amount, double cash, Timestamp timestamp, String description, boolean isCredit )
    {
        open();
        
        try
        {
            psNewCashTransaction.setDouble( 1, amount );
            psNewCashTransaction.setDouble( 2, cash );
            psNewCashTransaction.setTimestamp( 3, timestamp );
            psNewCashTransaction.setString( 4, description );
            psNewCashTransaction.setBoolean( 5, isCredit );
            psNewCashTransaction.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateTransaction( int transactionID, String description, Timestamp timestamp )
    {
        open();
        
        try
        {
            psUpdateCashTransaction.setString( 1, description );
            psUpdateCashTransaction.setTimestamp( 2, timestamp );
            psUpdateCashTransaction.setInt( 3, transactionID );
            psUpdateCashTransaction.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteTransaction( int transactionID )
    {
        open();
        
        try
        {
            psDeleteCashTransaction.setInt( 1, transactionID );
            psDeleteCashTransaction.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
