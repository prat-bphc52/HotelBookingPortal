/*
 * Created by JFormDesigner on Wed Nov 21 12:41:10 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Rashi Jain
 */
public class BookingFrame extends JFrame {
    public BookingFrame(Bookings b1, int status) {
        initComponents();
        AcceptBooking p1 = new AcceptBooking(b1,status,this);
        p1.setSize(500,500);
        p1.setVisible(true);
        this.add(p1);
        this.pack();
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rashi Jain

        //======== this ========
        Container contentPane = getContentPane();

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 400, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String args[])
    {
        Bookings b1 = new Bookings();
                b1.adult_count = 2;
                b1.child_count = 4;
        BookingFrame f1 = new BookingFrame(b1,1);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rashi Jain
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
