package pk.anas.accounting.gui.models;

import java.sql.ResultSet;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Muhammad Anas
 */
public class CustomersTableModel implements TableModel
{
    private 
    public void CustomersTableModel( ResultSet customersResults )
    {
        
    }

    @Override
    public int getRowCount()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getColumnCount()
    {
        
    }

    @Override
    public String getColumnName(int i)
    {
        
    }

    @Override
    public Class<?> getColumnClass(int i)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
        
    }

    @Override
    public Object getValueAt(int i, int i1)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValueAt(Object o, int i, int i1)
    {
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl)
    {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener tl)
    {
        
    }
    
}
