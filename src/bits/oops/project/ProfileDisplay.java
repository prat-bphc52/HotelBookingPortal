/*
 * Created by JFormDesigner on Wed Nov 21 02:28:54 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Utkarsh grover
 */
public class ProfileDisplay extends JFrame {
    User user;
    public ProfileDisplay(User user) {
        this.user=user;
        initComponents();
        //code added by UG delete this coment edits aend on the begining of other comment
        name_field.setText(user.getName());
        email_field.setText(user.getEmailid());
        label10.setText(user.getUsername());
        pwd_field.setText(user.getPassword());
        contact_field.setText(user.getContact());
        address_field.setText(user.getAddress());
        // UG -- my edits end here
    }

    private boolean isOnEdit = false;//if durrently form is being edited its true

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!isOnEdit){

            name_field.setEnabled(true);
            email_field.setEnabled(true);
            contact_field.setEnabled(true);
            address_field.setEnabled(true);

            button1.setText("Confirm Edits");
            button2.setText("Cancel!");

            isOnEdit = true ;

        }else{
            User user1 = new User(user.getUsername(),name_field.getText(),email_field.getText(),contact_field.getText(),contact_field.getText(),user.getPassword());

            int errors = 0;
            if(user1.getName().equals(""))
                errors++;
            if(user1.getEmailid().equals(""))
                errors++;
            if(user1.getContact().equals(""))
                errors++;
            if(user1.getAddress().equals(""))
                errors++;

            if(errors>0){
                System.out.println("here");
                ErrorDialog dialog = new ErrorDialog(this);
                dialog.setVisible(true);
                //dialogue box saying please fill in all the field
                name_field.setText(user.getName());
                email_field.setText(user.getEmailid());
                contact_field.setText(user.getContact());
                address_field.setText(user.getAddress());
            }
            else {
                name_field.setEnabled(false);
                email_field.setEnabled(false);
                contact_field.setEnabled(false);
                address_field.setEnabled(false);

                button1.setText("Edit Profile");
                button2.setText("Change Password");

                isOnEdit = false;
            }
        }


    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        if(isOnEdit){
            name_field.setText(user.getName());
            email_field.setText(user.getEmailid());
            contact_field.setText(user.getContact());
            address_field.setText(user.getAddress());

            name_field.setEnabled(false);
            email_field.setEnabled(false);
            contact_field.setEnabled(false);
            address_field.setEnabled(false);

            button1.setText("Edit Profile");
            button2.setText("Change Password");

            isOnEdit = false;
        }else{
            //password change pop-up code


        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Utkarsh grover
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        email_field = new JTextField();
        label10 = new JTextField();
        pwd_field = new JPasswordField();
        contact_field = new JTextField();
        address_field = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        name_field = new JTextField();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();

        //======== this ========
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- label2 ----
                label2.setText("Name");

                //---- label3 ----
                label3.setText("Email-ID");

                //---- label4 ----
                label4.setText("Username");

                //---- label5 ----
                label5.setText("Password");

                //---- label6 ----
                label6.setText("Contact");

                //---- label7 ----
                label7.setText("Address");

                //---- email_field ----
                email_field.setText("text");
                email_field.setBorder(new EtchedBorder());
                email_field.setEnabled(false);

                //---- label10 ----
                label10.setText("text");
                label10.setBorder(new EtchedBorder());
                label10.setEnabled(false);

                //---- pwd_field ----
                pwd_field.setText("text");
                pwd_field.setEnabled(false);

                //---- contact_field ----
                contact_field.setText("text");
                contact_field.setBorder(new EtchedBorder());
                contact_field.setEnabled(false);

                //---- address_field ----
                address_field.setText("text");
                address_field.setBorder(new EtchedBorder());
                address_field.setEnabled(false);

                //---- button1 ----
                button1.setText("Edit Profile");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                //---- button2 ----
                button2.setText("Change Password");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button2MouseClicked(e);
                    }
                });

                //---- name_field ----
                name_field.setEnabled(false);

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(name_field, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(email_field, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pwd_field, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(contact_field, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(button1)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addGap(72, 72, 72)
                                            .addComponent(button2))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(address_field, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(170, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(name_field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(email_field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label10, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(pwd_field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(contact_field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(address_field, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(33, 33, 33))
                );
            }
            tabbedPane1.addTab("My Profile", panel1);

            //======== panel2 ========
            {

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(26, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(27, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("My Bookings", panel2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(tabbedPane1)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Utkarsh grover
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField email_field;
    private JTextField label10;
    private JPasswordField pwd_field;
    private JTextField contact_field;
    private JTextField address_field;
    private JButton button1;
    private JButton button2;
    private JTextField name_field;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
