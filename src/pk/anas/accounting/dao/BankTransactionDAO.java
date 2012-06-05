package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Muhammad Anas
 */
public class BankTransactionDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psNewBankTransaction = null;
    private PreparedStatement psUpdatebankTransaction = null ;
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
            "  transactionDescription = ? " +
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
            psUpdatebankTransaction = connection.prepareStatement( sqlUpdateBankTransaction );
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
        close( psUpdatebankTransaction );
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
    
    public void updateTransaction( int transactionID )
    {
        open();
        
        try
        {
            psUpdatebankTransaction.setInt( 1, transactionID );
            psUpdatebankTransaction.executeUpdate();
        }
        catch ( SQLException e )
        {
            
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
}
