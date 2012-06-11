package pk.anas.accounting.gui.managers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import pk.anas.accounting.dao.ConnectionManager;
import pk.anas.accounting.dao.CapitalTransactionDAO;
import pk.anas.accounting.gui.forms.CapitalTransactionForm;
import pk.anas.accounting.gui.models.CustomTableModel;

/**
 *
 * @author Muhammad Anas
 */
public class CapitalTransactionsManager extends JPanel
{
    private CapitalTransactionDAO capitalTransactionDAO;
    private JScrollPane displayTableScrollPane;
    private JTable displayTable;
    private CustomTableModel displayTableModel;
    private JPanel middlePanel;
    private JToolBar toolBar;
    private JButton addNew;
    private JButton updateSelected;
    private JButton deleteSelected;
    private JButton backToTable;
    private CapitalTransactionForm editingForm;
    private JButton saveButton;
    private JButton updateButton;
    
    public CapitalTransactionsManager( ConnectionManager connectionManager )
    {
        super();
        capitalTransactionDAO = new CapitalTransactionDAO( connectionManager );
        displayTableModel = new CustomTableModel( capitalTransactionDAO.getDataForTableModel() );
        displayTable = new JTable( displayTableModel );
        displayTable.doLayout();
        displayTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        displayTableScrollPane = new JScrollPane( displayTable );
        
        toolBar = new JToolBar();
        addNew = new JButton( "Add New Transaction" );
        updateSelected = new JButton( "Update Transaction" );
        deleteSelected = new JButton( "Delete Transaction" );
        backToTable = new JButton( "Back To Data Display" );
        editingForm = new CapitalTransactionForm();
        
        this.setLayout( new BorderLayout() );
        middlePanel = new JPanel();
        this.add( middlePanel, BorderLayout.CENTER );
        middlePanel.setLayout( new BorderLayout() );
        middlePanel.add( displayTableScrollPane, BorderLayout.CENTER );
        
        addNew.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    middlePanel.removeAll();
                    middlePanel.repaint();
                    
                    middlePanel.add( editingForm, BorderLayout.NORTH );
                    backToTable.setEnabled( true );
                    CapitalTransactionsManager.this.revalidate();
                }
            }
        );
        toolBar.add( addNew );
        
        updateSelected.setEnabled( false );
        updateSelected.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    middlePanel.removeAll();
                    middlePanel.repaint();
                    
                    middlePanel.add( editingForm, BorderLayout.NORTH );
                    backToTable.setEnabled( true );
                    
                    CapitalTransactionsManager.this.revalidate();
                }
            }
        );
        toolBar.add( updateSelected );
        
        deleteSelected.setEnabled( false );
        deleteSelected.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    
                    backToTable.setEnabled( true );
                }
            }
        );
        toolBar.add( deleteSelected );
        
        backToTable.setEnabled( false );
        backToTable.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    middlePanel.removeAll();
                    middlePanel.repaint();
                    
                    middlePanel.add( displayTableScrollPane, BorderLayout.NORTH );
                    updateSelected.setEnabled( false );
                    deleteSelected.setEnabled( false );
                    backToTable.setEnabled( false );
                    
                    CapitalTransactionsManager.this.revalidate();
                }
            }
        );
        toolBar.add( backToTable );
        
        this.add(toolBar, BorderLayout.NORTH );
    }
}
