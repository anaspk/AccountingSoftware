/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.anas.accounting.gui;

/**
 *
 * @author Muhammad Anas
 */
public class DashBoard extends javax.swing.JPanel
{
    MainWindow parentWindow;

    
    /**
     * Creates new form DashBoard
     */
    public DashBoard()
    {
        initComponents();
    }

    public void setParentWindow( MainWindow mw )
    {
        this.parentWindow = mw;
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

        manageCustomersButton = new javax.swing.JButton();
        manageSuppliersButton = new javax.swing.JButton();
        manageSalesOrdersButton = new javax.swing.JButton();
        managePurchaseOrdersButton = new javax.swing.JButton();
        manageProductsButton = new javax.swing.JButton();
        manageProductCategoriesButton = new javax.swing.JButton();
        manageBankAccountsButton = new javax.swing.JButton();
        manageCapitalAccountsButton = new javax.swing.JButton();
        manageBankTransactionsButton = new javax.swing.JButton();
        manageCapitalTransactionsButton = new javax.swing.JButton();
        manageCashTransactionsButton = new javax.swing.JButton();
        manageReportsButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        manageCustomersButton.setBackground(new java.awt.Color(53, 103, 157));
        manageCustomersButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageCustomersButton.setForeground(new java.awt.Color(255, 255, 255));
        manageCustomersButton.setText("Customers");
        manageCustomersButton.setToolTipText("Manage Customers");
        manageCustomersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCustomersButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 0);
        add(manageCustomersButton, gridBagConstraints);

        manageSuppliersButton.setBackground(new java.awt.Color(53, 103, 157));
        manageSuppliersButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageSuppliersButton.setForeground(new java.awt.Color(255, 255, 255));
        manageSuppliersButton.setText("Suppliers");
        manageSuppliersButton.setToolTipText("Manage Suppliers");
        manageSuppliersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSuppliersButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 168;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 18, 0, 14);
        add(manageSuppliersButton, gridBagConstraints);

        manageSalesOrdersButton.setBackground(new java.awt.Color(53, 103, 157));
        manageSalesOrdersButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageSalesOrdersButton.setForeground(new java.awt.Color(255, 255, 255));
        manageSalesOrdersButton.setText("Sales Orders");
        manageSalesOrdersButton.setToolTipText("Manage Sales Orders");
        manageSalesOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSalesOrdersButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 120;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        add(manageSalesOrdersButton, gridBagConstraints);

        managePurchaseOrdersButton.setBackground(new java.awt.Color(53, 103, 157));
        managePurchaseOrdersButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        managePurchaseOrdersButton.setForeground(new java.awt.Color(255, 255, 255));
        managePurchaseOrdersButton.setText("Purchase Orders");
        managePurchaseOrdersButton.setToolTipText("Manage Purchase Orders");
        managePurchaseOrdersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePurchaseOrdersButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 58;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 14);
        add(managePurchaseOrdersButton, gridBagConstraints);

        manageProductsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageProductsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageProductsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageProductsButton.setText("Products");
        manageProductsButton.setToolTipText("Manage Products");
        manageProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 172;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        add(manageProductsButton, gridBagConstraints);

        manageProductCategoriesButton.setBackground(new java.awt.Color(53, 103, 157));
        manageProductCategoriesButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageProductCategoriesButton.setForeground(new java.awt.Color(255, 255, 255));
        manageProductCategoriesButton.setText("Product Categories");
        manageProductCategoriesButton.setToolTipText("Manage Product Categories");
        manageProductCategoriesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProductCategoriesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 14);
        add(manageProductCategoriesButton, gridBagConstraints);

        manageBankAccountsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageBankAccountsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageBankAccountsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageBankAccountsButton.setText("Bank Accounts");
        manageBankAccountsButton.setToolTipText("Manage Bank Accounts");
        manageBankAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBankAccountsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        add(manageBankAccountsButton, gridBagConstraints);

        manageCapitalAccountsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageCapitalAccountsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageCapitalAccountsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageCapitalAccountsButton.setText("Capital Accounts");
        manageCapitalAccountsButton.setToolTipText("Manage Capital Accounts");
        manageCapitalAccountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCapitalAccountsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 60;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 14);
        add(manageCapitalAccountsButton, gridBagConstraints);

        manageBankTransactionsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageBankTransactionsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageBankTransactionsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageBankTransactionsButton.setText("Bank Transactions");
        manageBankTransactionsButton.setToolTipText("Manage Bank Transactions");
        manageBankTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageBankTransactionsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        add(manageBankTransactionsButton, gridBagConstraints);

        manageCapitalTransactionsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageCapitalTransactionsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageCapitalTransactionsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageCapitalTransactionsButton.setText("Capital Transactions");
        manageCapitalTransactionsButton.setToolTipText("Manage Capital Transactions");
        manageCapitalTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCapitalTransactionsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 0, 14);
        add(manageCapitalTransactionsButton, gridBagConstraints);

        manageCashTransactionsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageCashTransactionsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageCashTransactionsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageCashTransactionsButton.setText("Cash Transactions");
        manageCashTransactionsButton.setToolTipText("Manage Cash Transactions");
        manageCashTransactionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCashTransactionsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 192, 0, 0);
        add(manageCashTransactionsButton, gridBagConstraints);

        manageReportsButton.setBackground(new java.awt.Color(53, 103, 157));
        manageReportsButton.setFont(new java.awt.Font("Stencil Std", 0, 24)); // NOI18N
        manageReportsButton.setForeground(new java.awt.Color(255, 255, 255));
        manageReportsButton.setText("Reports");
        manageReportsButton.setToolTipText("Generate, View and Manage Reports");
        manageReportsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageReportsButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 190;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 192, 13, 0);
        add(manageReportsButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void manageCustomersButtonActionPerformed(//GEN-FIRST:event_manageCustomersButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageCustomersButtonActionPerformed
        parentWindow.openCustomersManager();
    }//GEN-LAST:event_manageCustomersButtonActionPerformed

    private void manageSuppliersButtonActionPerformed(//GEN-FIRST:event_manageSuppliersButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageSuppliersButtonActionPerformed
        parentWindow.openSuppliersManager();
    }//GEN-LAST:event_manageSuppliersButtonActionPerformed

    private void manageSalesOrdersButtonActionPerformed(//GEN-FIRST:event_manageSalesOrdersButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageSalesOrdersButtonActionPerformed
        parentWindow.openSalesOrdersManager();
    }//GEN-LAST:event_manageSalesOrdersButtonActionPerformed

    private void managePurchaseOrdersButtonActionPerformed(//GEN-FIRST:event_managePurchaseOrdersButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_managePurchaseOrdersButtonActionPerformed
        parentWindow.openPurchaseOrdersManager();
    }//GEN-LAST:event_managePurchaseOrdersButtonActionPerformed

    private void manageProductsButtonActionPerformed(//GEN-FIRST:event_manageProductsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageProductsButtonActionPerformed
        parentWindow.openProductsManager();
    }//GEN-LAST:event_manageProductsButtonActionPerformed

    private void manageProductCategoriesButtonActionPerformed(//GEN-FIRST:event_manageProductCategoriesButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageProductCategoriesButtonActionPerformed
        parentWindow.openProductsCategoriesManager();
    }//GEN-LAST:event_manageProductCategoriesButtonActionPerformed

    private void manageBankAccountsButtonActionPerformed(//GEN-FIRST:event_manageBankAccountsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageBankAccountsButtonActionPerformed
        parentWindow.openBankAccountsManager();
    }//GEN-LAST:event_manageBankAccountsButtonActionPerformed

    private void manageCapitalAccountsButtonActionPerformed(//GEN-FIRST:event_manageCapitalAccountsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageCapitalAccountsButtonActionPerformed
        parentWindow.openCapitalAccountsManager();
    }//GEN-LAST:event_manageCapitalAccountsButtonActionPerformed

    private void manageBankTransactionsButtonActionPerformed(//GEN-FIRST:event_manageBankTransactionsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageBankTransactionsButtonActionPerformed
        parentWindow.openBankTransactionsManager();
    }//GEN-LAST:event_manageBankTransactionsButtonActionPerformed

    private void manageCapitalTransactionsButtonActionPerformed(//GEN-FIRST:event_manageCapitalTransactionsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageCapitalTransactionsButtonActionPerformed
        parentWindow.openCapitalTransactionsManager();
    }//GEN-LAST:event_manageCapitalTransactionsButtonActionPerformed

    private void manageCashTransactionsButtonActionPerformed(//GEN-FIRST:event_manageCashTransactionsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageCashTransactionsButtonActionPerformed
        parentWindow.openCashTransactionsManager();
    }//GEN-LAST:event_manageCashTransactionsButtonActionPerformed

    private void manageReportsButtonActionPerformed(//GEN-FIRST:event_manageReportsButtonActionPerformed
            java.awt.event.ActionEvent evt)
    {//GEN-HEADEREND:event_manageReportsButtonActionPerformed
        parentWindow.openReportsManager();
    }//GEN-LAST:event_manageReportsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton manageBankAccountsButton;
    private javax.swing.JButton manageBankTransactionsButton;
    private javax.swing.JButton manageCapitalAccountsButton;
    private javax.swing.JButton manageCapitalTransactionsButton;
    private javax.swing.JButton manageCashTransactionsButton;
    private javax.swing.JButton manageCustomersButton;
    private javax.swing.JButton manageProductCategoriesButton;
    private javax.swing.JButton manageProductsButton;
    private javax.swing.JButton managePurchaseOrdersButton;
    private javax.swing.JButton manageReportsButton;
    private javax.swing.JButton manageSalesOrdersButton;
    private javax.swing.JButton manageSuppliersButton;
    // End of variables declaration//GEN-END:variables
}
