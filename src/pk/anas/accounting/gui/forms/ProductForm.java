/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.anas.accounting.gui.forms;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import pk.anas.accounting.dao.ConnectionManager;
import pk.anas.accounting.dao.ProductCategoryDAO;
import pk.anas.accounting.dao.ProductDAO;
import pk.anas.accounting.entities.Product;

/**
 *
 * @author Shahjahan
 */
public class ProductForm extends javax.swing.JPanel
{
    private ConnectionManager connectionManager;
    private ProductDAO productDAO;
    private ProductCategoryDAO productCategoryDAO;

    /**
     * Creates new form ProductForm
     */
    public ProductForm()
    {
        initComponents();
    }

    public ProductForm( ConnectionManager connectionManager )
    {
        initComponents();
        
        this.connectionManager = connectionManager;
        productDAO = new ProductDAO( this.connectionManager );
        productCategoryDAO = new ProductCategoryDAO( this.connectionManager );
        
        stockQuantityLabel.setVisible( false );
        stockQuantityField.setVisible( false );
        orderQuantityLabel.setVisible( false );
        orderQuantityField.setVisible( false );
        reorderQuantityLabel.setVisible( false );
        reorderQuantityField.setVisible( false );
        
        inventoryItemCheckBox.addItemListener(
            new ItemListener()
            {
                @Override
                public void itemStateChanged( ItemEvent eve )
                {
                    if ( eve.getStateChange() == ItemEvent.SELECTED )
                    {
                        stockQuantityLabel.setVisible( true );
                        stockQuantityField.setVisible( true );
                        orderQuantityLabel.setVisible( true );
                        orderQuantityField.setVisible( true );
                        reorderQuantityLabel.setVisible( true );
                        reorderQuantityField.setVisible( true );
                        ProductForm.this.revalidate();
                    }
                    else
                    {
                        stockQuantityLabel.setVisible( false );
                        stockQuantityField.setVisible( false );
                        orderQuantityLabel.setVisible( false );
                        orderQuantityField.setVisible( false );
                        reorderQuantityLabel.setVisible( false );
                        reorderQuantityField.setVisible( false );
                        ProductForm.this.revalidate();
                    }
                }
            }
        );
        populateCategoriesCombo();
    }
    
    public void populateCategoriesCombo()
    {
        productCategoryCombo.removeAllItems();
        
        LinkedList<String> productCategories = productCategoryDAO.getAllCategoryNames();
        
        productCategoryCombo.addItem( "" ); // force to choose a category manually
        for ( String category : productCategories )
            productCategoryCombo.addItem( category );
    }
    
    public void populateForm( Product product )
    {
        productNameField.setText( product.getProductName() );
        purchasePriceField.setText( ""+product.getUnitPurchasePrice() );
        salesPriceField.setText( ""+product.getUnitSalePrice() );
        productCategoryCombo.setSelectedItem( productCategoryDAO.getCategoryNameByID( product.getCategoryID() ) );
        productDescriptionArea.setText( product.getProductDescription() );
        if ( product.isInventoryItem() )
        {
            inventoryItemCheckBox.setSelected( true );
            stockQuantityField.setText( ""+product.getStockQuantity() );
            orderQuantityField.setText( ""+product.getOrderQuantity() );
            reorderQuantityField.setText( ""+product.getReorderQuantity() );
        }
        else
            inventoryItemCheckBox.setSelected( false );
    }
    
    public boolean validateForm()
    {
        String errorMessage = "";
        
        if ( productNameField.getText().compareTo( "" ) == 0 )
            errorMessage += "Product name field couldn\'t be left blank";
        if ( salesPriceField.getText().compareTo( "" ) == 0 )
            errorMessage += "\nPlease enter a sales price for this product";
        if ( productCategoryCombo.getSelectedIndex() == 0 )
            errorMessage += "\nPlease select a category for this product.";
        if ( inventoryItemCheckBox.isSelected() )
        {
            if ( stockQuantityField.getText().compareTo( "" ) == 0 )
                errorMessage += "\nQuantity in Stock field couldn\'t be left blank";
            if ( orderQuantityField.getText().compareTo( "" ) == 0 )
                errorMessage += "\nQuantity on order field couldn\'t be left blank";
        }
        
        if ( errorMessage.compareTo( "" ) != 0 )
        {
            JOptionPane.showMessageDialog( this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE );
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public Product getProductObject()
    {
        Product product = new Product();
        
        product.setProductName( productNameField.getText() );
        if ( purchasePriceField.getText().compareTo( "" ) != 0 )
            product.setUnitPurchasePrice( Double.parseDouble( purchasePriceField.getText() ) );
        else
            product.setUnitPurchasePrice( 0.0 );
        product.setUnitSalePrice( Double.parseDouble( salesPriceField.getText() ) );
        product.setCategoryID( productCategoryDAO.getCategoryIDByName( (String)productCategoryCombo.getSelectedItem() ) );
        product.setProductDescription( productDescriptionArea.getText() );
        if ( inventoryItemCheckBox.isSelected() )
        {
            product.setInventoryItem(true);
            product.setStockQuantity( Integer.parseInt( stockQuantityField.getText() ) );
            product.setOrderQuantity( Integer.parseInt( orderQuantityField.getText() ) );
            if ( reorderQuantityField.getText().compareTo( "" ) != 0 )
                product.setReorderQuantity( Integer.parseInt( reorderQuantityField.getText() ) );
            else
                product.setReorderQuantity( 0 );
        }
        return product;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        productNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        purchasePriceField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        salesPriceField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productCategoryCombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDescriptionArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        inventoryItemCheckBox = new javax.swing.JCheckBox();
        stockQuantityLabel = new javax.swing.JLabel();
        stockQuantityField = new javax.swing.JTextField();
        orderQuantityLabel = new javax.swing.JLabel();
        orderQuantityField = new javax.swing.JTextField();
        reorderQuantityLabel = new javax.swing.JLabel();
        reorderQuantityField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Product Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(productNameField, gridBagConstraints);

        jLabel2.setText("Purchase Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(purchasePriceField, gridBagConstraints);

        jLabel3.setText("Sales Price");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(salesPriceField, gridBagConstraints);

        jLabel4.setText("Product Category");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel4, gridBagConstraints);

        productCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(productCategoryCombo, gridBagConstraints);

        jLabel5.setText("Product Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel5, gridBagConstraints);

        productDescriptionArea.setColumns(20);
        productDescriptionArea.setRows(5);
        jScrollPane1.setViewportView(productDescriptionArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jScrollPane1, gridBagConstraints);

        jLabel6.setText("Inventory Item");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(inventoryItemCheckBox, gridBagConstraints);

        stockQuantityLabel.setText("Quantity in Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(stockQuantityLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(stockQuantityField, gridBagConstraints);

        orderQuantityLabel.setText("Quantity on Order");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(orderQuantityLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(orderQuantityField, gridBagConstraints);

        reorderQuantityLabel.setText("Reorder Quantity");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(reorderQuantityLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(reorderQuantityField, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox inventoryItemCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField orderQuantityField;
    private javax.swing.JLabel orderQuantityLabel;
    private javax.swing.JComboBox productCategoryCombo;
    private javax.swing.JTextArea productDescriptionArea;
    private javax.swing.JTextField productNameField;
    private javax.swing.JTextField purchasePriceField;
    private javax.swing.JTextField reorderQuantityField;
    private javax.swing.JLabel reorderQuantityLabel;
    private javax.swing.JTextField salesPriceField;
    private javax.swing.JTextField stockQuantityField;
    private javax.swing.JLabel stockQuantityLabel;
    // End of variables declaration//GEN-END:variables
}
