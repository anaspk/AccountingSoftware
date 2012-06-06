package pk.anas.accounting.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Muhammad Anas
 */
public class MainWindowOld extends JFrame
{
    private DashBoard dashBoard;
    
    public MainWindowOld()
    {
        super( "Accounting Software" );
        dashBoard = new DashBoard();
        this.add( dashBoard, BorderLayout.CENTER );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 800, 650 );
        this.setVisible( true );
    }
}
