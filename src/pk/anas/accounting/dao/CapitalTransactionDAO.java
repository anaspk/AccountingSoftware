package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class CapitalTransactionDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psNewCapitalTransaction = null;
    private PreparedStatement psUpdateCapitalTransaction = null;
    private PreparedStatement psDeleteCapitalTransaction = null;
    
    private final String sqlNewCapitalTransaction = "INSERT INTO capital_transaction " +
            "( capitalAccountID, " +
            "  isCredit, " +
            "  transactionAmount, " +
            "  transactionDescription, " +
            "  transactionTimestamp " +
            ") VALUES ( " +
            " ? , ? , ? , ? , ? );";
    
    private final String sqlUpdateCapitalTransaction = "UPDATE capital_transaction " +
            "SET " +
            "  transactionDescription = ? , " +
            "  transactionTimestamp = ? " +
            "WHERE " +
            "  transactionID = ? ;";
    
    private final String sqlDeleteCapitalTransaction = "DELETE FROM capital_transaction " +
                                                       "WHERE transactionID = ? ;";
    
    public CapitalTransactionDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psNewCapitalTransaction = connection.prepareStatement( sqlNewCapitalTransaction );
            psUpdateCapitalTransaction = connection.prepareStatement( sqlUpdateCapitalTransaction );
            psDeleteCapitalTransaction = connection.prepareStatement( sqlDeleteCapitalTransaction );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psNewCapitalTransaction );
        close( psUpdateCapitalTransaction );
        close( psDeleteCapitalTransaction );
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
    
    public void performNewTransaction( int accID, boolean isCredit, double amount, String description, Timestamp timestamp )
    {
        open();
        
        try
        {
            psNewCapitalTransaction.setInt( 1, accID );
            psNewCapitalTransaction.setBoolean( 2, isCredit );
            psNewCapitalTransaction.setDouble( 3, amount );
            psNewCapitalTransaction.setString( 4, description );
            psNewCapitalTransaction.setTimestamp( 5, timestamp );
            psNewCapitalTransaction.executeUpdate();
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
            psUpdateCapitalTransaction.setString( 1, description );
            psUpdateCapitalTransaction.setTimestamp( 2, timestamp );
            psUpdateCapitalTransaction.setInt( 3, transactionID );
            psUpdateCapitalTransaction.executeUpdate();
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
            psDeleteCapitalTransaction.setInt( 1, transactionID );
            psDeleteCapitalTransaction.executeQuery();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
