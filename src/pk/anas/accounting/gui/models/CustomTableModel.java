package pk.anas.accounting.gui.models;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Muhammad Anas
 */
public class CustomTableModel implements TableModel
{
    CachedRowSet rowSet;
    ResultSetMetaData metaData;
    int columnCount;
    int rowCount;
    
    public CustomTableModel( CachedRowSet rs )
    {
        rowSet = rs;
        try
        {
            metaData = rowSet.getMetaData();
            columnCount = metaData.getColumnCount();
            
            rowSet.beforeFirst();
            rowCount = 0;
            while ( rowSet.next() )
                rowCount++;
            rowSet.beforeFirst();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount()
    {
        return rowCount;
    }

    @Override
    public int getColumnCount()
    {
        return columnCount;
    }

    @Override
    public String getColumnName(int i)
    {
        try
        {
            return metaData.getColumnLabel( i+1 );
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int i)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column )
    {
        Object value;
        
        try
        {
            rowSet.absolute( row + 1 );
            value = rowSet.getObject( column + 1 );
            if ( value != null )
                return value.toString();
            else
                return null;
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
            return null;
        }
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
    
    public void refresh()
    {
        try
        {
            //rowSet.release();
            rowSet.execute();
            rowSet.beforeFirst();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
