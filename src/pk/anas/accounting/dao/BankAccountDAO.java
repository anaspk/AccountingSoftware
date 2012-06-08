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
public class BankAccountDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewBankAccount = null;
    private PreparedStatement psUpdateBankAccount = null;
    private PreparedStatement psDeleteBankAccount = null;
    
    private final String sqlAddNewBankAccount = "INSERT INTO bank_account " +
            "( accountHolderName, " +
            "  accountNumber, " +
            "  bankName, " +
            "  bankBranchName, " +
            "  bankBranchCode, " +
            "  bankAddress, " +
            "  branchCity, " +
            "  accountType, " +
            "  accountBalance " +
            ") VALUES ( " +
            " ?, ?, ?, ?, ?, ?, ?, ? );";
    
    private final String sqlUpdateBankAccount = "UPDATE bank_account " +
            "SET " +
            "  accountHolderName = ? , " +
            "  accountNumber = ? , " +
            "  bankName = ? , " +
            "  bankBranchName = ? , " +
            "  bankBranchCode = ? , " +
            "  bankAddress = ? , " +
            "  branchCity = ? , " +
            "  accountType = ? , " +
            "  accountBalance = ? " +
            "WHERE " +
            "  accountID = ? ;";
    
    private final String sqlDeleteBankAccount = "DELETE FROM bank_account " +
                                                "WHERE account_id = ? ;";
    
    public BankAccountDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewBankAccount = connection.prepareStatement( sqlAddNewBankAccount );
            psUpdateBankAccount = connection.prepareStatement( sqlUpdateBankAccount );
            psDeleteBankAccount = connection.prepareStatement( sqlDeleteBankAccount );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewBankAccount );
        close( psUpdateBankAccount );
        close( psDeleteBankAccount );
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
    
    public void addNewBankAccount( String accountHolder, String accNum, String bank, String branch, String branchCode, String branchAdd, String city, String accountType, double balance )
    {
        open();
        try
        {
            psAddNewBankAccount.setString( 1, accountHolder );
            psAddNewBankAccount.setString( 2, accNum );
            psAddNewBankAccount.setString( 3, bank );
            psAddNewBankAccount.setString( 4, branch );
            psAddNewBankAccount.setString( 5, branchCode );
            psAddNewBankAccount.setString( 6, branchAdd );
            psAddNewBankAccount.setString( 7, city );
            psAddNewBankAccount.setString( 8, accountType );
            psAddNewBankAccount.setDouble( 9, balance );
            psAddNewBankAccount.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        close();
    }
    
    public void updateBankAccount( int accID, String accountHolder, String accNum, String bank, String branch, String branchCode, String branchAdd, String city, String accountType, double balance )
    {
        open();
        try
        {
            psUpdateBankAccount.setString( 1, accountHolder );
            psUpdateBankAccount.setString( 2, accNum );
            psUpdateBankAccount.setString( 3, bank );
            psUpdateBankAccount.setString( 4, branch );
            psUpdateBankAccount.setString( 5, branchCode );
            psUpdateBankAccount.setString( 6, branchAdd );
            psUpdateBankAccount.setString( 7, city );
            psUpdateBankAccount.setString( 8, accountType );
            psUpdateBankAccount.setDouble( 9, balance );
            psUpdateBankAccount.setInt( 10, accID );
            psUpdateBankAccount.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        close();
    }
    
    public void deleteBankAccount( int accID )
    {
        open();
        
        try
        {
            psDeleteBankAccount.setInt( 1, accID );
            psDeleteBankAccount.executeUpdate();
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
            
            rowSet.setCommand( "SELECT accountID AS 'Account ID', " +
                    "accountNumber AS 'Account Number', " +
                    "accountHolderName AS 'Account Holder', " +
                    "bankName AS Bank, " +
                    "branchName AS Branch, " +
                    "accountBalance AS Balance " +
                    "FROM bank_account;" );
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
