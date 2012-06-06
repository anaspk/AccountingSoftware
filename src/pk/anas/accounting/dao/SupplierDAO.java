package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
    public void addNewSupplier()
    {
        open();
        
        try
        {
            
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
    
    public void updateSupplier()
    {
        open();
        
        try
        {
            
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
            
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
        
        close();
    }
}
