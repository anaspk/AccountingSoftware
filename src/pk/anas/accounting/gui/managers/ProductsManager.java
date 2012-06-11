package pk.anas.accounting.gui.managers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import pk.anas.accounting.dao.ConnectionManager;
import pk.anas.accounting.dao.InventoryItemDAO;
import pk.anas.accounting.dao.ProductDAO;
import pk.anas.accounting.entities.Product;
import pk.anas.accounting.gui.forms.ProductForm;
import pk.anas.accounting.gui.models.CustomTableModel;

/**
 *
 * @author Muhammad Anas
 */
public class ProductsManager extends JPanel
{
    private ProductDAO productDAO;
    private InventoryItemDAO inventoryItemDAO;
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
    private ProductForm editingForm;
    private JButton saveButton;
    private JButton updateButton;
    
    public ProductsManager( ConnectionManager connectionManager )
    {
        super();
        productDAO = new ProductDAO( connectionManager );
        inventoryItemDAO = new InventoryItemDAO( connectionManager );
        displayTableModel = new CustomTableModel( productDAO.getDataForTableModel() );
        displayTable = new JTable( displayTableModel );
        displayTable.doLayout();
        displayTable.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        displayTableScrollPane = new JScrollPane( displayTable );
        
        toolBar = new JToolBar();
        addNew = new JButton( "Add New Product" );
        updateSelected = new JButton( "Update Product" );
        deleteSelected = new JButton( "Delete Product" );
        backToTable = new JButton( "Back To Data Display" );
        editingForm = new ProductForm( connectionManager );
        
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
                    
                    editingForm.populateCategoriesCombo();
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
                                    Product product = editingForm.getProductObject();
                                    productDAO.addNewProduct( product.getCategoryID(), product.getProductName(), product.getUnitPurchasePrice(),
                                            product.getUnitSalePrice(), product.getProductDescription(), product.isInventoryItem() );
                                    if ( product.isInventoryItem() )
                                        ;
                                }
                            }
                        }
                    );
                    middleBottomPanel.add( saveButton );
                    middlePanel.add( middleBottomPanel, BorderLayout.SOUTH );
                    
                    backToTable.setEnabled( true );
                    ProductsManager.this.revalidate();
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
                    
                    ProductsManager.this.revalidate();
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
                    
                    ProductsManager.this.revalidate();
                }
            }
        );
        toolBar.add( backToTable );
        
        this.add(toolBar, BorderLayout.NORTH );
    }
}
