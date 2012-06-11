package pk.anas.accounting.dao;

/**
 *
 * @author Muhammad Anas
 */
public class InventoryItemDAO
{
    private ConnectionManager connectionManager;
    
    public InventoryItemDAO( ConnectionManager connectionManager )
    {
        this.connectionManager = connectionManager;
    }
}
