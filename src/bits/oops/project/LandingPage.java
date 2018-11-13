/*
 * Created by JFormDesigner on Sun Nov 11 15:52:15 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class LandingPage extends JPanel {
    public LandingPage(JFrame parent) {
        this.parent = parent;
        initComponents();
    }

    private void datecheckin(MouseEvent e) {
        parent.setEnabled(false);
        DateChooser obj = new DateChooser(parent);
        obj.setSize(500,500);
        obj.pack();
        obj.setVisible(true);
        obj.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                parent.setEnabled(true);
                parent.setVisible(true);
                if(obj.date!=null && !obj.date.equals("")) {
                    Calendar cal = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(2000+Integer.parseInt(obj.date.substring(6)),Integer.parseInt(obj.date.substring(3,5))-1,Integer.parseInt(obj.date.substring(0,2)));
                    System.out.print(obj.date+"   "+cal2.getTime()+"   "+cal.getTime()+"   "+cal.compareTo(cal2));
                    if(cal.compareTo(cal2)>0){
                        checkinStatus = 1;
                        checkin.setText("");
                        errorCheckIn.setVisible(true);
                        errorCheckIn.setText("<html>Date cannot be ahead of current date</html>");
                    }
                    else {
                        checkin.setText(obj.date);
                        checkinStatus=2;
                        checkoutStatus=0;
                        checkout.setText("");
                        errorCheckIn.setVisible(false);
                    }
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void datecheckout(MouseEvent e) {
        if(checkinStatus!=2){
            errorCheckOut.setVisible(true);
            errorCheckOut.setText("<html>Please choose checkin date</html>");
            return;
        }
        parent.setEnabled(false);
        DateChooser obj = new DateChooser(parent);
        obj.setSize(500,500);
        obj.pack();
        obj.setVisible(true);
        obj.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                parent.setEnabled(true);
                parent.setVisible(true);
                if(obj.date!=null || !obj.date.equals("")){
                    Calendar cal = Calendar.getInstance();
                    cal.set(2000+Integer.parseInt(obj.date.substring(6)),Integer.parseInt(obj.date.substring(3,5))-1,Integer.parseInt(obj.date.substring(0,2)));
                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(2000+Integer.parseInt(checkin.getText().substring(6)),Integer.parseInt(checkin.getText().substring(3,5))-1,Integer.parseInt(checkin.getText().substring(0,2)));
                    if(cal.compareTo(cal2)<=0){
                        checkoutStatus = 1;
                        checkout.setText("");
                        errorCheckOut.setVisible(true);
                        errorCheckOut.setText("<html>Date should be ahead of checkin date</html>");
                    }
                    else {
                        checkout.setText(obj.date);
                        checkoutStatus=2;
                        errorCheckOut.setVisible(false);
                    }
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    private void submit(ActionEvent e) {
        System.out.print("Submit Button Clicked");
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        cityLabel = new JLabel();
        checkinLabel = new JLabel();
        checkin = new JLabel();
        cityChooser = new JComboBox<>();
        checkoutLabel = new JLabel();
        label1 = new JLabel();
        guestsLabel = new JLabel();
        panel1 = new JPanel();
        label2 = new JLabel();
        comboBox1 = new JComboBox<>();
        label3 = new JLabel();
        comboBox2 = new JComboBox<>();
        label4 = new JLabel();
        label5 = new JLabel();
        checkout = new JLabel();
        button1 = new JButton();
        loggedInPanel = new JPanel();
        label6 = new JLabel();
        userName = new JLabel();
        button3 = new JButton();
        loggedOutPanel = new JPanel();
        label7 = new JLabel();
        button2 = new JButton();
        errorCheckIn = new JLabel();
        errorCheckOut = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- cityLabel ----
        cityLabel.setText("Select City          :");

        //---- checkinLabel ----
        checkinLabel.setText("Checkin Date     :");

        //---- checkin ----
        checkin.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/calendar_icon.png")));
        checkin.setBorder(new EtchedBorder());
        checkin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                datecheckin(e);
            }
        });

        //---- cityChooser ----
        cityChooser.setEditable(true);
        cityChooser.setModel(new DefaultComboBoxModel<>(new String[] {
            "Hyderabad",
            "Mumbai",
            "Delhi",
            "Kolkata",
            "Bangalore"
        }));

        //---- checkoutLabel ----
        checkoutLabel.setText("Checkout Date   :");

        //---- label1 ----
        label1.setText("  Hotel Booking Portal");
        label1.setFont(new Font("Swis721 BlkOul BT", Font.PLAIN, 20));
        label1.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/hotel_icon.png")));

        //---- guestsLabel ----
        guestsLabel.setText("Guests                 :");

        //======== panel1 ========
        {

            //---- label2 ----
            label2.setText("Adults");

            //---- comboBox1 ----
            comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "1",
                "2",
                "3",
                "4"
            }));
            comboBox1.setEditable(true);

            //---- label3 ----
            label3.setText("Child(<18)");

            //---- comboBox2 ----
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                "0",
                "1",
                "2",
                "3",
                "4"
            }));
            comboBox2.setEditable(true);

            //---- label4 ----
            label4.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\adult_icon.png"));

            //---- label5 ----
            label5.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\child_icon.png"));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
            );
        }

        //---- checkout ----
        checkout.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/calendar_icon.png")));
        checkout.setBorder(new EtchedBorder());
        checkout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                datecheckout(e);
            }
        });

        //---- button1 ----
        button1.setText("SEARCH");
        button1.setBorder(new EtchedBorder());
        button1.setBackground(new Color(102, 102, 255));
        button1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 12));
        button1.addActionListener(e -> submit(e));

        //======== loggedInPanel ========
        {
            loggedInPanel.setBorder(LineBorder.createBlackLineBorder());

            //---- label6 ----
            label6.setText("Welcome,");
            label6.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- userName ----
            userName.setText("<html>Prateek Agarwal</html>");
            userName.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- button3 ----
            button3.setText("LOGOUT");

            GroupLayout loggedInPanelLayout = new GroupLayout(loggedInPanel);
            loggedInPanel.setLayout(loggedInPanelLayout);
            loggedInPanelLayout.setHorizontalGroup(
                loggedInPanelLayout.createParallelGroup()
                    .addGroup(loggedInPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loggedInPanelLayout.createParallelGroup()
                            .addGroup(loggedInPanelLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(userName, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, loggedInPanelLayout.createSequentialGroup()
                                .addGap(0, 42, Short.MAX_VALUE)
                                .addComponent(button3)))
                        .addContainerGap())
            );
            loggedInPanelLayout.setVerticalGroup(
                loggedInPanelLayout.createParallelGroup()
                    .addGroup(loggedInPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(button3)
                        .addContainerGap())
            );
        }

        //======== loggedOutPanel ========
        {
            loggedOutPanel.setBorder(LineBorder.createBlackLineBorder());

            //---- label7 ----
            label7.setText("<html>Kindly LOGIN in order to gain access to the portal!</html>");
            label7.setFont(new Font("Segoe UI", Font.BOLD, 12));

            //---- button2 ----
            button2.setText("LOGIN");

            GroupLayout loggedOutPanelLayout = new GroupLayout(loggedOutPanel);
            loggedOutPanel.setLayout(loggedOutPanelLayout);
            loggedOutPanelLayout.setHorizontalGroup(
                loggedOutPanelLayout.createParallelGroup()
                    .addGroup(loggedOutPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, loggedOutPanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button2)
                        .addContainerGap())
            );
            loggedOutPanelLayout.setVerticalGroup(
                loggedOutPanelLayout.createParallelGroup()
                    .addGroup(loggedOutPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(button2)
                        .addContainerGap())
            );
        }

        //---- errorCheckIn ----
        errorCheckIn.setIcon(UIManager.getIcon("TextField.darcula.clear.icon"));
        errorCheckIn.setText("Date cannot be ahead of current date");

        //---- errorCheckOut ----
        errorCheckOut.setIcon(UIManager.getIcon("TextField.darcula.clear.icon"));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(cityChooser, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(checkinLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(checkin, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(errorCheckIn, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(checkoutLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(checkout, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(errorCheckOut, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(guestsLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loggedInPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(loggedOutPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cityChooser, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(checkinLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(errorCheckIn))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(checkoutLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkout, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(guestsLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addComponent(errorCheckOut)))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(loggedInPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loggedOutPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        loggedInPanel.setVisible(true);
        loggedOutPanel.setVisible(false);
        errorCheckIn.setVisible(false);
        errorCheckOut.setVisible(false);
        checkinStatus = checkoutStatus = 0;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Prateek Agarwal
    private JLabel cityLabel;
    private JLabel checkinLabel;
    private JLabel checkin;
    private JComboBox<String> cityChooser;
    private JLabel checkoutLabel;
    private JLabel label1;
    private JLabel guestsLabel;
    private JPanel panel1;
    private JLabel label2;
    private JComboBox<String> comboBox1;
    private JLabel label3;
    private JComboBox<String> comboBox2;
    private JLabel label4;
    private JLabel label5;
    private JLabel checkout;
    private JButton button1;
    private JPanel loggedInPanel;
    private JLabel label6;
    private JLabel userName;
    private JButton button3;
    private JPanel loggedOutPanel;
    private JLabel label7;
    private JButton button2;
    private JLabel errorCheckIn;
    private JLabel errorCheckOut;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JFrame parent;
    int checkinStatus;
    int checkoutStatus;
    public static void main(String args[]){
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
        LandingPage panelLanding = new LandingPage(frame);
        panelLanding.setSize(500,500);
        frame.add(panelLanding);
        panelLanding.setVisible(true);
    }
}
