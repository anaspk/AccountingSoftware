package pk.anas.accounting.dao;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Muhammad Anas
 */
public class BankTransactionDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psNewBankTransaction = null;
    private PreparedStatement psUpdateBankTransaction = null ;
    private PreparedStatement psDeleteBankTransaction = null;
    
    private final String sqlNewBankTransaction = "INSERT INTO bank_transaction " +
            "( bankAccountID, " +
            "  isCredit, " +
            "  transactionAmount, " +
            "  transactionDescription, " +
            "  transactionTimestamp ) " +
            "VALUES " +
            "( ? , ? , ? , ? , ? ) ;";
    
    private final String sqlUpdateBankTransaction = "UPDATE bank_transaction " +
            "SET " +
            "  transactionDescription = ?," +
            "  transactionTimestamp = ? " +
            "WHERE " +
            "  transactionID = ? ;";
    
    private final String sqlDelteBankTransaction = "DELETE FROM bank_transaction " +
                                                   "WHERE transactionID = ? ;";
    
    public BankTransactionDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psNewBankTransaction = connection.prepareStatement( sqlNewBankTransaction );
            psUpdateBankTransaction = connection.prepareStatement( sqlUpdateBankTransaction );
            psDeleteBankTransaction = connection.prepareStatement( sqlDelteBankTransaction );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psNewBankTransaction );
        close( psUpdateBankTransaction );
        close( psDeleteBankTransaction );
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
    
    public void performNewTransaction( int accID, boolean isCredit, double amount, String description, Timestamp time )
    {
        open();
        
        try
        {
            psNewBankTransaction.setInt( 1, accID );
            psNewBankTransaction.setBoolean( 2, isCredit );
            psNewBankTransaction.setDouble( 3, amount );
            psNewBankTransaction.setString( 4, description );
            psNewBankTransaction.setTimestamp( 5, time );
            psNewBankTransaction.executeUpdate();
        }
        catch( SQLException e )
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
            psUpdateBankTransaction.setString( 1, description );
            psUpdateBankTransaction.setTimestamp( 2, timestamp );
            psUpdateBankTransaction.setInt( 3, transactionID );
            psUpdateBankTransaction.executeUpdate();
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
            psDeleteBankTransaction.setInt( 1, transactionID );
            psDeleteBankTransaction.executeUpdate();
        }
        catch ( SQLException e )
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
            
            rowSet.setCommand( "SELECT transactionID AS 'Transaction ID', " +
                    "bankAccountID AS 'Bank Account ID', " +
                    "transactionAmount AS Amount, " +
                    "transactionDescription AS Description " +
                    "FROM bank_transaction;" );
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
