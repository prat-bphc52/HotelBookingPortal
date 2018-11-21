/*
 * Created by JFormDesigner on Wed Nov 21 04:57:59 IST 2018
 */

package bits.oops.project;

import java.awt.event.*;
import javax.swing.*;


/**
 * @author unknown
 */
public class AcceptBooking extends JPanel {

    Bookings b1;
    JFrame f;
    public AcceptBooking(Bookings b1,int status, JFrame frame) {
        initComponents();

        this.b1=b1;
        if(status==1)
            this.status.setText("YOUR BOOKING IS WAITLISTED");
        else if(status==0)
            this.status.setText("CONFIRMED BOOKING CAN BE MADE");
        //f = new JFrame();
        //f.add(this);
        //f.setVisible(true);
        f = frame;

    }

    private void addguestdetailsActionPerformed(ActionEvent e) {

        UserDetails detail = new UserDetails(f,b1.adult_count,b1.child_count);
        System.out.print("printing adult and child in accept booking frame" + b1.child_count + b1.adult_count);
        detail.setVisible(true);

            System.out.print("a is 1");
            //this.guest.setText(UserDetails.adults + "\n" + UserDetails.child.toString());

        System.out.print(detail.adults.toString());




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
        guest = new JLabel();

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

        //---- guest ----
        guest.setText("GUESTS : ");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(layout.createParallelGroup()
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(label2)
                                                .addComponent(label1)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(label3)
                                                    .addGap(8, 8, 8)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(nameoncard, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cardnumber, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cvv, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(91, 91, 91)
                                            .addComponent(proceedtopay))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(status, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(112, 112, 112)
                                    .addComponent(addguestdetails)))
                            .addGap(0, 57, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(guest, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)
                    .addComponent(status)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(addguestdetails)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(guest, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cardnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameoncard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cvv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(18, 18, 18)
                    .addComponent(proceedtopay)
                    .addContainerGap(33, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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
    private JLabel guest;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
