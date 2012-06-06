package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Anas
 */
public class CustomerDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewCustomer = null;
    private PreparedStatement psUpdateCustomer = null;
    private PreparedStatement psDeleteCustomer = null;
    
    private final String sqlAddNewCustomer = "INSERT INTO customer " +
            "( firstName, " +
            "  lastName, " +
            "  phoneNumber, " +
            "  mobileNumber, " +
            "  emailAddress, " +
            "  streetAddline1, " +
            "  streetAddLine2, " +
            "  city, " +
            "  province, " +
            "  country, " +
            "  bankName, " +
            "  branchName, " +
            "  branchCode, " +
            "  bankAccountNo " +
            ") VALUES ( " +
            "  ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );";
    
    private final String sqlUpdateCustomer = "UPDATE customer " +
            "SET " +
            "  firstName = ? , " +
            "  lastName = ? , " +
            "  phoneNumber = ? , " +
            "  mobileNumber = ? , " +
            "  emailAddress = ? " +
            "  streetAddline1 = ? , " +
            "  streetAddLine2 = ? , " +
            "  city = ? , " +
            "  province = ? , " +
            "  country = ? , " +
            "  bankName = ? , " +
            "  branchName = ? , " +
            "  branchCode = ? , " +
            "  bankAccountNo = ? " +
            "WHERE customerID = ? ;";
    
    private final String sqlDeleteCustomer = "DELETE FROM customer " +
                                             "WHERE customerID = ? ;";
    
    public CustomerDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewCustomer = connection.prepareStatement( sqlAddNewCustomer );
            psUpdateCustomer = connection.prepareStatement( sqlUpdateCustomer );
            psDeleteCustomer = connection.prepareStatement( sqlDeleteCustomer );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewCustomer );
        close( psUpdateCustomer );
        close( psDeleteCustomer );
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
    
    public void addNewCustomer( String firstN, String lastN, String phone, String mobile, String email, String add1, String add2, String city, String province, String country, String bank, String branch, String branchCode, String accountNo )
    {
        open();
        
        try
        {
            psAddNewCustomer.setString( 1, firstN );
            psAddNewCustomer.setString( 2, lastN );
            psAddNewCustomer.setString( 3, phone );
            psAddNewCustomer.setString( 4, mobile );
            psAddNewCustomer.setString( 5, email );
            psAddNewCustomer.setString( 6, add1 );
            psAddNewCustomer.setString( 7, add2 );
            psAddNewCustomer.setString( 8, city );
            psAddNewCustomer.setString( 9, province );
            psAddNewCustomer.setString( 10, country );
            psAddNewCustomer.setString( 11, bank );
            psAddNewCustomer.setString( 12, branch );
            psAddNewCustomer.setString( 13, branchCode );
            psAddNewCustomer.setString( 14, accountNo );
            psAddNewCustomer.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateCustomer( int customerID, String firstN, String lastN, String phone, String mobile, String email, String add1, String add2, String city, String province, String country, String bank, String branch, String branchCode, String accountNo )
    {
        open();
        
        try
        {
            psUpdateCustomer.setString( 1, firstN );
            psUpdateCustomer.setString( 2, lastN );
            psUpdateCustomer.setString( 3, phone );
            psUpdateCustomer.setString( 4, mobile );
            psUpdateCustomer.setString( 5, email );
            psUpdateCustomer.setString( 6, add1 );
            psUpdateCustomer.setString( 7, add2 );
            psUpdateCustomer.setString( 8, city );
            psUpdateCustomer.setString( 9, province );
            psUpdateCustomer.setString( 10, country );
            psUpdateCustomer.setString( 11, bank );
            psUpdateCustomer.setString( 12, branch );
            psUpdateCustomer.setString( 13, branchCode );
            psUpdateCustomer.setString( 14, accountNo );
            psUpdateCustomer.setInt( 15, customerID );
            psUpdateCustomer.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteCustomer( int customerID )
    {
        open();
        
        try
        {
            psDeleteCustomer.setInt( 1, customerID );
            psDeleteCustomer.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
