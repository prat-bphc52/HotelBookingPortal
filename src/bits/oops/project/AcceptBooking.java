/*
 * Created by JFormDesigner on Wed Nov 21 04:57:59 IST 2018
 */

package bits.oops.project;

import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class AcceptBooking extends JPanel {

    Bookings b1;
    JFrame f;
    public AcceptBooking(Bookings b1,int status) {
        initComponents();
        this.b1=b1;
        if(status==1)
            this.status.setText("YOUR BOOKING IS WAITLISTED");
        else if(status==0)
            this.status.setText("CONFIRMED BOOKING CAN BE MADE");
        f = new JFrame();
        f.add(this);
        f.setVisible(true);

    }

    private void addguestdetailsActionPerformed(ActionEvent e) {

        UserDetails detail = new UserDetails(f,b1.adult_count,b1.child_count);
        detail.setVisible(true);





    }

    private void proceedtopayActionPerformed(ActionEvent e) {


        b1.adults = UserDetails.adults;
        b1.child=UserDetails.child;
        MysqlCon.getInstance().book_now(b1);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rashi Jain
        panel1 = new JPanel();
        status = new JLabel();
        proceedtopay = new JButton();
        addguestdetails = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        cardnumber = new JTextField();
        nameoncard = new JTextField();
        cvv = new JPasswordField();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //======== panel1 ========
        {
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        }

        //---- status ----
        status.setText("BOOKING CAN BE CONFIRMED/AWAITED");

        //---- proceedtopay ----
        proceedtopay.setText("PROCEED TO PAY");
        proceedtopay.addActionListener(e -> proceedtopayActionPerformed(e));

        //---- addguestdetails ----
        addguestdetails.setText("ADD GUEST DETAILS");
        addguestdetails.addActionListener(e -> addguestdetailsActionPerformed(e));

        //---- label1 ----
        label1.setText("ENTER CARD NUMBER:");

        //---- label2 ----
        label2.setText("NAME ON CARD:");

        //---- label3 ----
        label3.setText("CVV:");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(status, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addComponent(addguestdetails))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label1)
                                        .addComponent(label3)
                                        .addComponent(label2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(cardnumber, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameoncard, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cvv, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(99, 99, 99)
                                    .addComponent(proceedtopay)))))
                    .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(status)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(addguestdetails)
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(cardnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(nameoncard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(cvv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addComponent(proceedtopay)
                    .addGap(17, 17, 17))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public static void main(String args[])
    {
        Bookings b1 = new Bookings();
        new AcceptBooking(b1, 1);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rashi Jain
    private JPanel panel1;
    private JLabel status;
    private JButton proceedtopay;
    private JButton addguestdetails;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField cardnumber;
    private JTextField nameoncard;
    private JPasswordField cvv;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
