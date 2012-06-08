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
public class SupplierDAO
{
    private ConnectionManager connectionManager;
    private Connection connection;
    private PreparedStatement psAddNewSupplier = null;
    private PreparedStatement psUpdateSupplier = null;
    private PreparedStatement psDeleteSupplier = null;
    
    private final String sqlAddNewSupplier = "INSERT INTO supplier " +
            "( companyName, " +
            "  contactPersonFirstName, " +
            "  contactPersonLastName, " +
            "  phoneNumber, " +
            "  mobileNumber, " +
            "  emailAddress, " +
            "  streetAddLine1, " +
            "  streetAddline2, " +
            "  city, " +
            "  provine, " +
            "  country, " +
            "  bankName, " +
            "  branchName, " +
            "  branchCode, " +
            "  bankAccountNo " +
            ") VALUES ( " +
            " ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? );";
    
    private final String sqlUpdateSupplier = "UPDATE supplier " +
            "SET " +
            "  companyName = ? , " +
            "  contactPersonFirstName = ? , " +
            "  contactPersonLastName = ? , " +
            "  phoneNumber = ? , " +
            "  mobileNumber = ? , " +
            "  emailAddress = ? , " +
            "  streetAddLine1 = ? , " +
            "  streetAddline2 = ? , " +
            "  city = ? , " +
            "  provine = ? , " +
            "  country = ? , " +
            "  bankName = ? , " +
            "  branchName = ? , " +
            "  branchCode = ? , " +
            "  bankAccountNo = ? " +
            "WHERE " +
            "  supplierID = ? ;";
    
    private final String sqlDeleteSupplier = "DELETE FROM supplier " +
                                             "WHERE supplierID = ? ;";
    
    public SupplierDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
    
    public void open()
    {
        connectionManager.openConnection();
        connection = connectionManager.getConnection();
        
        try
        {
            psAddNewSupplier = connection.prepareStatement( sqlAddNewSupplier );
            psUpdateSupplier = connection.prepareStatement( sqlUpdateSupplier );
            psDeleteSupplier = connection.prepareStatement( sqlDeleteSupplier );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        close( psAddNewSupplier );
        close( psUpdateSupplier );
        close( psDeleteSupplier );
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
    
    public void addNewSupplier( String cName, String cpfName, String cplName, String phone, String mobile, String email, String addLine1, String addLine2, String city, String province, String country, String bank, String branch, String branchCode, String accountNo )
    {
        open();
        
        try
        {
            psAddNewSupplier.setString( 1, cName );
            psAddNewSupplier.setString( 2, cpfName );
            psAddNewSupplier.setString( 3, cplName );
            psAddNewSupplier.setString( 4, phone );
            psAddNewSupplier.setString( 5, mobile );
            psAddNewSupplier.setString( 6, email );
            psAddNewSupplier.setString( 7, addLine1 );
            psAddNewSupplier.setString( 8, addLine2 );
            psAddNewSupplier.setString( 9, city );
            psAddNewSupplier.setString( 10, province );
            psAddNewSupplier.setString( 11, country );
            psAddNewSupplier.setString( 12, bank );
            psAddNewSupplier.setString( 13, branch );
            psAddNewSupplier.setString( 14, branchCode );
            psAddNewSupplier.setString( 15, accountNo );
            psAddNewSupplier.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateSupplier( int suplierID, String cName, String cpfName, String cplName, String phone, String mobile, String email, String addLine1, String addLine2, String city, String province, String country, String bank, String branch, String branchCode, String accountNo )
    {
        open();
        
        try
        {
            psAddNewSupplier.setString( 1, cName );
            psAddNewSupplier.setString( 2, cpfName );
            psAddNewSupplier.setString( 3, cplName );
            psAddNewSupplier.setString( 4, phone );
            psAddNewSupplier.setString( 5, mobile );
            psAddNewSupplier.setString( 6, email );
            psAddNewSupplier.setString( 7, addLine1 );
            psAddNewSupplier.setString( 8, addLine2 );
            psAddNewSupplier.setString( 9, city );
            psAddNewSupplier.setString( 10, province );
            psAddNewSupplier.setString( 11, country );
            psAddNewSupplier.setString( 12, bank );
            psAddNewSupplier.setString( 13, branch );
            psAddNewSupplier.setString( 14, branchCode );
            psAddNewSupplier.setString( 15, accountNo );
            psAddNewSupplier.setInt( 16 , suplierID);
            psAddNewSupplier.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void deleteSupplier( int supplierID )
    {
        open();
        
        try
        {
            psDeleteSupplier.setInt( 1, supplierID );
            psDeleteSupplier.executeUpdate();
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
            
            rowSet.setCommand( "SELECT supplierID AS 'Supplier ID', " +
                    "supplierID AS 'Supplier ID', " +
                    "paymentMethod AS 'Payment Method', " +
                    "orderSubtotal AS 'Order Subtotal', " +
                    "amountPaid AS 'Amount Paid', " +
                    "FROM supplier;" );
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
