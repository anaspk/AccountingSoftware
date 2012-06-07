/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.anas.accounting.gui;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhammad Anas
 */
public class MainWindow extends javax.swing.JFrame
{

    /**
     * Creates new form MainWindow
     */
    public MainWindow()
    {
        initComponents();
        dashBoard.setParentWindow( this );
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

        centralPanel = new javax.swing.JPanel();
        dashBoard = new pk.anas.accounting.gui.DashBoard();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AccountingSoftware");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        centralPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        centralPanel.add(dashBoard, gridBagConstraints);

        getContentPane().add(centralPanel, java.awt.BorderLayout.CENTER);

        jMenu11.setText("File");

        jMenuItem7.setText("Dashboard");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem7);

        jMenuItem8.setText("Exit");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem8);

        jMenuBar1.add(jMenu11);

        jMenu1.setText("Customers");

        jMenuItem2.setText("Add New Customer");
        jMenu1.add(jMenuItem2);

        jMenuItem9.setText("Manage Existing Customers");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Suppliers");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Add New Supplier");
        jMenu2.add(jMenuItem3);

        jMenuItem10.setText("Manage Existing Suppliers");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Products");

        jMenuItem4.setText("Add New Product");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem11.setText("Manage Existing Products");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenu17.setText("Product Categories");

        jMenuItem24.setText("Add New Category");
        jMenu17.add(jMenuItem24);

        jMenuItem25.setText("Manage Existing Categories");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu17.add(jMenuItem25);

        jMenu4.add(jMenu17);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Orders");

        jMenu9.setText("Sales Orders");

        jMenuItem5.setText("New Sales Order");
        jMenu9.add(jMenuItem5);

        jMenuItem12.setText("Manage Sales Orders");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem12);

        jMenu3.add(jMenu9);

        jMenu10.setText("Purchase Orders");

        jMenuItem6.setText("New Purchase Order");
        jMenu10.add(jMenuItem6);

        jMenuItem13.setText("Manage Purchase Orders");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenu3.add(jMenu10);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Accounts");

        jMenu12.setText("Bank Accounts");

        jMenuItem14.setText("Add New Bank Account");
        jMenu12.add(jMenuItem14);

        jMenuItem15.setText("Manage Bank Accounts");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem15);

        jMenu5.add(jMenu12);

        jMenu13.setText("Capital Accounts");

        jMenuItem16.setText("Add New Capital Account");
        jMenu13.add(jMenuItem16);

        jMenuItem17.setText("Manage Capital Accounts");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem17);

        jMenu5.add(jMenu13);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Transactions");

        jMenu14.setText("Bank Transactions");

        jMenuItem18.setText("New Bank Transaction");
        jMenu14.add(jMenuItem18);

        jMenuItem19.setText("Manage Bank Transactions");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem19);

        jMenu6.add(jMenu14);

        jMenu15.setText("Capital Transactions");

        jMenuItem20.setText("New Capital Transaction");
        jMenu15.add(jMenuItem20);

        jMenuItem21.setText("Manage Capital Transactions");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem21);

        jMenu6.add(jMenu15);

        jMenu16.setText("Cash Transactions");

        jMenuItem22.setText("New Cash Transaction");
        jMenu16.add(jMenuItem22);

        jMenuItem23.setText("Manage Cash Transactions");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem23);

        jMenu6.add(jMenu16);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Reports");
        jMenuBar1.add(jMenu7);

        jMenu8.setText("Help");

        jMenuItem1.setText("About");
        jMenu8.add(jMenuItem1);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ////////////////// -- Our Custom Methods -- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //////////////////////////////////////////////////////////////////////////
    public void showDashBoard()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        centralPanel.setLayout( new BorderLayout() );
        centralPanel.add( dashBoard, BorderLayout.CENTER );
        this.revalidate();
    }
    
    public void openCustomersManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openSuppliersManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openSalesOrdersManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openPurchaseOrdersManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openProductsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openProductsCategoriesManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openBankAccountsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openCapitalAccountsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openBankTransactionsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openCapitalTransactionsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openCashTransactionsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    
    public void openReportsManager()
    {
        centralPanel.removeAll();
        centralPanel.repaint();
        this.revalidate();
    }
    //////////////////////////////////////////////////////////////////////////
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem4ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenu2ActionPerformed
    {//GEN-HEADEREND:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem8ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem8ActionPerformed
        int choice = JOptionPane.showConfirmDialog( this, "Are you sure you want to exit the\nAccounting Software", "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION );
        
        if ( choice == 0 )
            System.exit( 0 );
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem7ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem7ActionPerformed
        showDashBoard();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem12ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem12ActionPerformed
        this.openSalesOrdersManager();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem9ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem9ActionPerformed
        this.openCustomersManager();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem10ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem10ActionPerformed
        this.openSuppliersManager();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem11ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem11ActionPerformed
        this.openProductsManager();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem13ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem13ActionPerformed
        this.openPurchaseOrdersManager();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem15ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem15ActionPerformed
        this.openBankAccountsManager();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem17ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem17ActionPerformed
        this.openCapitalAccountsManager();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem19ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem19ActionPerformed
        this.openBankTransactionsManager();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem21ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem21ActionPerformed
        this.openCapitalTransactionsManager();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem23ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem23ActionPerformed
        this.openCashTransactionsManager();
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jMenuItem25ActionPerformed
    {//GEN-HEADEREND:event_jMenuItem25ActionPerformed
        this.openProductsCategoriesManager();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable()
        {

            public void run()
            {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel centralPanel;
    private pk.anas.accounting.gui.DashBoard dashBoard;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
