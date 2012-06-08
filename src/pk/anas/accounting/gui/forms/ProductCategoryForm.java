/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.anas.accounting.gui.forms;

import java.util.LinkedList;
import pk.anas.accounting.dao.ConnectionManager;
import pk.anas.accounting.dao.ProductCategoryDAO;
import pk.anas.accounting.entities.ProductCategory;

/**
 *
 * @author Shahjahan
 */
public class ProductCategoryForm extends javax.swing.JPanel
{
    ConnectionManager connectionManager;
    ProductCategoryDAO productCategoryDAO;

    /**
     * Creates new form ProductCategoryForm
     */
    public ProductCategoryForm()
    {
        initComponents();
    }
    
    public ProductCategoryForm( ConnectionManager connectionManager )
    {
        initComponents();
        
        this.connectionManager = connectionManager;
        productCategoryDAO = new ProductCategoryDAO( this.connectionManager );
        updateParentComboItems();
    }
    
    public void updateParentComboItems()
    {
        parentCategoryCombo.removeAllItems();
        
        LinkedList<String> parentCategories = productCategoryDAO.getAllCategoryNames();
        
        parentCategoryCombo.addItem( "" ); // allow no choice
        for ( String category : parentCategories )
            parentCategoryCombo.addItem( category );
    }

    public void populate( ProductCategory category )
    {
        populate( category.getCategoryName(), category.getParentCategoryID(), category.getCategoryDescription() );
    }
    
    public void populate( String name, int parentID, String description )
    {
        categoryNameField.setText( name );
        parentCategoryCombo.setSelectedItem( productCategoryDAO.getCategoryNameByID( parentID ) );
        categoryDescriptionArea.setText( description );
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
        categoryNameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        parentCategoryCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryDescriptionArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Category Name");
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
        add(categoryNameField, gridBagConstraints);

        jLabel2.setText("Parent Category");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel2, gridBagConstraints);

        parentCategoryCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(parentCategoryCombo, gridBagConstraints);

        jLabel3.setText("Category Description");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jLabel3, gridBagConstraints);

        categoryDescriptionArea.setColumns(20);
        categoryDescriptionArea.setRows(5);
        jScrollPane1.setViewportView(categoryDescriptionArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 5, 12);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea categoryDescriptionArea;
    private javax.swing.JTextField categoryNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox parentCategoryCombo;
    // End of variables declaration//GEN-END:variables
}
