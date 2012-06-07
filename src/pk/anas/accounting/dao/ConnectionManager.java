package pk.anas.accounting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Muhammad Anas
 */
public class ConnectionManager
{
    private final String url = "jdbc:mysql://localhost/accounting_system";
    private final String username = "root";
    private final String password = "mysqlpass";
    private Connection connection = null;
    
    public ConnectionManager()
    {
        
    }
    
    public Connection getConnection()
    {
        return connection;
    }

    public String getUrl()
    {
        return url;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
    
    public void openConnection()
    {
        if ( getConnection() == null )
        {
            try
            {
                connection = DriverManager.getConnection( getUrl(), getUsername(), getPassword());
            }
            catch ( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
    
    public void closeConnection()
    {
        if ( getConnection() != null )
        {
            try
            {
                connection.close();
                connection = null;
            }
            catch ( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
}
