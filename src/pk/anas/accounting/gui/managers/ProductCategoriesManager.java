package pk.anas.accounting.gui.managers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import pk.anas.accounting.dao.ConnectionManager;
import pk.anas.accounting.dao.ProductCategoryDAO;
import pk.anas.accounting.entities.ProductCategory;
import pk.anas.accounting.gui.forms.ProductCategoryForm;
import pk.anas.accounting.gui.models.CustomTableModel;

/**
 *
 * @author Muhammad Anas
 */
public class ProductCategoriesManager extends JPanel
{
    private ConnectionManager connectionManager;
    private ProductCategoryDAO productCategoryDAO;
    private JScrollPane displayTableScrollPane;
    private JTable displayTable;
    private CustomTableModel displayTableModel;
    private JPanel middlePanel;
    private JPanel middleBottomPanel;
    private JToolBar toolBar;
    private JButton addNew;
    private JButton updateSelected;
    private JButton deleteSelected;
    private JButton backToTable;
    private ProductCategoryForm editingForm;
    private JButton saveButton;
    private JButton updateButton;
    private int noOfSelectedRows;
    private int choice;
    
    public ProductCategoriesManager( ConnectionManager connectionManager )
    {
        super();
        this.connectionManager = connectionManager;
        productCategoryDAO = new ProductCategoryDAO( this.connectionManager );
        displayTableModel = new CustomTableModel( productCategoryDAO.getDataForTableModel() );
        displayTable = new JTable( displayTableModel );
        displayTable.doLayout();
        displayTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        displayTable.getSelectionModel().addListSelectionListener( 
                new ListSelectionListener()
                {
                    @Override
                    public void valueChanged( ListSelectionEvent e )
                    {
                        noOfSelectedRows = displayTable.getSelectedRowCount();
                        if ( noOfSelectedRows == -1 )
                        {
                            updateSelected.setEnabled( false );
                            deleteSelected.setEnabled( false );
                        }
                        else
                        {
                            updateSelected.setEnabled( true );
                            deleteSelected.setEnabled( true );
                        }
                    }
                }
        );
        displayTableScrollPane = new JScrollPane( displayTable );
        
        toolBar = new JToolBar();
        addNew = new JButton( "Add New Category" );
        updateSelected = new JButton( "Update Category" );
        deleteSelected = new JButton( "Delete Category" );
        backToTable = new JButton( "Back To Data Display" );
        editingForm = new ProductCategoryForm( this.connectionManager );
        
        this.setLayout( new BorderLayout() );
        middlePanel = new JPanel();
        this.add( middlePanel, BorderLayout.CENTER );
        middlePanel.setLayout( new BorderLayout() );
        middlePanel.add( displayTableScrollPane, BorderLayout.CENTER );
        
        saveButton = new JButton( "Save" );
        updateButton = new JButton( "Update" );
        middleBottomPanel = new JPanel();
        middleBottomPanel.setLayout( new FlowLayout() );
        
        addNew.addActionListener( new ActionListener()
            {
                @Override
                public void actionPerformed( ActionEvent e )
                {
                    middlePanel.removeAll();
                    middlePanel.repaint();
                    
                    editingForm.updateParentComboItems();
                    middlePanel.add( editingForm, BorderLayout.NORTH );
                    middleBottomPanel.removeAll();
                    middleBottomPanel.repaint();
                    saveButton.addActionListener(
                        new ActionListener()
                        {
                            @Override
                            public void actionPerformed( ActionEvent eve )
                            {
                                if ( editingForm.validateForm() )
                                {
                                    ProductCategory category = editingForm.getCategoryObject();
                                    productCategoryDAO.addNewCategory( category.getParentCategoryID(),
                                            category.getCategoryName(), category.getCategoryDescription() );
                                }
                            }
                        }
                    );
                    middleBottomPanel.add( saveButton );
                    middlePanel.add( middleBottomPanel, BorderLayout.SOUTH );
                    
                    backToTable.setEnabled( true );
                    ProductCategoriesManager.this.revalidate();
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
                    middleBottomPanel.removeAll();
                    middleBottomPanel.repaint();
                    middleBottomPanel.add( updateButton );
                    middlePanel.add( middleBottomPanel, BorderLayout.SOUTH );
                    
                    int pid = Integer.parseInt( (String) displayTable.getValueAt( displayTable.getSelectedRow(), 2 ) );
                    ProductCategory category = productCategoryDAO.getCategoryByID( pid );
                    editingForm.populateForm( category );
                    
                    backToTable.setEnabled( true );
                    ProductCategoriesManager.this.revalidate();
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
                    int catID = Integer.parseInt( (String) displayTable.getValueAt( displayTable.getSelectedRow(), 2 ) );
                    choice = JOptionPane.showConfirmDialog( ProductCategoriesManager.this, "Are you sure you want to delete\nselected product category?",
                            "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION );
                    if ( choice == 0 )
                    {
                        productCategoryDAO.deleteCategory( catID );
                    
                        //backToTable.setEnabled( true );
                        ( (CustomTableModel)displayTable.getModel() ).refresh();
                        displayTable.revalidate();
                        //ProductCategoriesManager.this.revalidate();
                    }
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
                    
                    ProductCategoriesManager.this.revalidate();
                }
            }
        );
        toolBar.add( backToTable );
        
        this.add(toolBar, BorderLayout.NORTH );
    }
}
