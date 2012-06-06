package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Anas
 */
public class CapitalAccountDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewCapitalAccount = null;
    private PreparedStatement psUpdateCapitalAccount = null;
    private PreparedStatement psDeleteCapitalAccount = null;
    
    private final String sqlAddNewCapitalAccount = "INSERT INTO capital_account " +
            "( accountHolderName, " +
            "  accountBalance, " +
            "  initialInvestment " +
            " ) VALUES ( " +
            " ? , ? , ? );";
    
    private final String sqlUpdateCapitalAccount = "UPDATE capital_account " +
            "SET " +
            "  accountHolderName = ? , " +
            "  accountBalance = ? , " +
            "  initialInvestment = ? " +
            "WHERE " +
            "  accountID = ? ;";
    
    private final String sqlDeleteCapitalAccount = "DELETE FROM capital_account " +
                                                   "WHERE accountID = ? ;";
    
    public CapitalAccountDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewCapitalAccount = connection.prepareStatement( sqlAddNewCapitalAccount );
            psUpdateCapitalAccount = connection.prepareStatement( sqlUpdateCapitalAccount );
            psDeleteCapitalAccount = connection.prepareStatement( sqlDeleteCapitalAccount );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewCapitalAccount );
        close( psUpdateCapitalAccount );
        close( psDeleteCapitalAccount );
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
    
    public void addNewCapitalAccount( String accountHolder, double balance, double investment )
    {
        open();
        
        try
        {
            psAddNewCapitalAccount.setString( 1, accountHolder );
            psAddNewCapitalAccount.setDouble( 2, balance );
            psAddNewCapitalAccount.setDouble( 3, investment );
            psAddNewCapitalAccount.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateCapitalAccount( String accountHolder, double balance, double investment )
    {
        open();
        
        try
        {
            psUpdateCapitalAccount.setString( 1, accountHolder );
            psUpdateCapitalAccount.setDouble( 2, balance );
            psUpdateCapitalAccount.setDouble( 3, investment );
            psUpdateCapitalAccount.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteCaptalAccount( int accID )
    {
        open();
        
        try
        {
            psDeleteCapitalAccount.setInt( 1, accID );
            psDeleteCapitalAccount.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
