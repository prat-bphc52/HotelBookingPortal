/*
 * Created by JFormDesigner on Tue Nov 13 15:21:24 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*import com.jgoodies.forms.factories.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import info.clearthought.layout.*;
import org.jdesktop.swingx.*;*/

/**
 * @author Shreeya
 */
public class login_portal extends JPanel {
    public login_portal() {
        initComponents();
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Shreeya Nelekar
        RegistrationPortal = new JLabel();
        Name = new JLabel();
        Email = new JLabel();
        Username = new JLabel();
        Password = new JLabel();
        Contact = new JLabel();
        emailidtext = new JFormattedTextField();
        usernametext = new JFormattedTextField();
        passwordField1 = new JPasswordField();
        contacttext = new JFormattedTextField();
        nametext = new JFormattedTextField();
        Address = new JLabel();
        addresstext = new JFormattedTextField();
        Register = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder(Borders.DLU21);
        setForeground(Color.black);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- RegistrationPortal ----
        RegistrationPortal.setText("REGISTRATION PORTAL");
        RegistrationPortal.setToolTipText("ds");
        RegistrationPortal.setHorizontalAlignment(SwingConstants.CENTER);
        RegistrationPortal.setFont(new Font("Baskerville Old Face", RegistrationPortal.getFont().getStyle() | Font.BOLD, RegistrationPortal.getFont().getSize() + 6));
        RegistrationPortal.setBackground(Color.white);
        RegistrationPortal.setForeground(new Color(51, 0, 51));

        //---- Name ----
        Name.setText("NAME:*");
        Name.setHorizontalAlignment(SwingConstants.LEFT);
        Name.setFont(Name.getFont().deriveFont(Name.getFont().getStyle() | Font.BOLD, Name.getFont().getSize() + 2f));
        Name.setForeground(Color.black);

        //---- Email ----
        Email.setText("E-MAIL ID:*");
        Email.setFont(Email.getFont().deriveFont(Email.getFont().getStyle() | Font.BOLD, Email.getFont().getSize() + 2f));
        Email.setHorizontalAlignment(SwingConstants.LEFT);
        Email.setForeground(Color.black);

        //---- Username ----
        Username.setText("USERNAME:*");
        Username.setHorizontalAlignment(SwingConstants.LEFT);
        Username.setFont(Username.getFont().deriveFont(Username.getFont().getStyle() | Font.BOLD, Username.getFont().getSize() + 2f));
        Username.setForeground(Color.black);

        //---- Password ----
        Password.setText("PASSWORD*:");
        Password.setHorizontalAlignment(SwingConstants.LEFT);
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getStyle() | Font.BOLD, Password.getFont().getSize() + 2f));
        Password.setForeground(Color.black);

        //---- Contact ----
        Contact.setText("CONTACT NO:*");
        Contact.setFont(Contact.getFont().deriveFont(Contact.getFont().getStyle() | Font.BOLD, Contact.getFont().getSize() + 2f));
        Contact.setHorizontalAlignment(SwingConstants.LEFT);
        Contact.setForeground(Color.black);

        //---- emailidtext ----
        emailidtext.setBackground(Color.white);
        emailidtext.setForeground(Color.black);

        //---- usernametext ----
        usernametext.setBackground(Color.white);
        usernametext.setForeground(Color.black);

        //---- passwordField1 ----
        passwordField1.setBackground(Color.white);
        passwordField1.setForeground(Color.black);

        //---- contacttext ----
        contacttext.setBackground(Color.white);
        contacttext.setForeground(Color.black);

        //---- nametext ----
        nametext.setBackground(Color.white);
        nametext.setSelectionColor(Color.black);
        nametext.setCaretColor(Color.black);
        nametext.setDisabledTextColor(Color.black);
        nametext.setSelectedTextColor(Color.black);
        nametext.setForeground(Color.black);

        //---- Address ----
        Address.setText("ADDRESS:");
        Address.setForeground(Color.black);
        Address.setFont(Address.getFont().deriveFont(Address.getFont().getStyle() | Font.BOLD, Address.getFont().getSize() + 2f));

        //---- addresstext ----
        addresstext.setForeground(Color.black);
        addresstext.setBackground(Color.white);

        //---- Register ----
        Register.setText("REGISTER");
        Register.setBackground(new Color(0, 51, 102));
        Register.setFont(Register.getFont().deriveFont(Register.getFont().getStyle() | Font.BOLD, Register.getFont().getSize() + 2f));
        Register.setForeground(Color.white);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(Contact)
                                        .addComponent(Username)
                                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Address, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Register)))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(Email, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(passwordField1, GroupLayout.Alignment.LEADING)
                                .addComponent(usernametext, GroupLayout.Alignment.LEADING)
                                .addComponent(emailidtext)
                                .addComponent(contacttext)
                                .addComponent(addresstext, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(RegistrationPortal, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(Name, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(nametext, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(RegistrationPortal, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Name, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailidtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Email, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Username, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Contact, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(contacttext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(Address, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addresstext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Register))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Shreeya Nelekar
    private JLabel RegistrationPortal;
    private JLabel Name;
    private JLabel Email;
    private JLabel Username;
    private JLabel Password;
    private JLabel Contact;
    private JFormattedTextField emailidtext;
    private JFormattedTextField usernametext;
    private JPasswordField passwordField1;
    private JFormattedTextField contacttext;
    private JFormattedTextField nametext;
    private JLabel Address;
    private JFormattedTextField addresstext;
    private JButton Register;

    //public void check(){

    //    if(nametext.)
 //   }
    // JFormDesigner - End of variables declaration  //GEN-END:variables

  //  public static void main(String[] args) {
       // JFrame frame = new JFrame("login_portal");
       // frame.setContentPane(new login_portal().);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  frame.pack();
       // frame.setVisible(true);

  //
}
