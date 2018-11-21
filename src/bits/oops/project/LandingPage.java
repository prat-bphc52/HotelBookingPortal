/*
 * Created by JFormDesigner on Sun Nov 11 15:52:15 IST 2018
 */

package bits.oops.project;

import com.google.gson.Gson;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
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
        try {
            File f = new File(getClass().getResource("/bits/oops/project/user.csf").toURI());
            if(f.exists()) {
                Scanner sc=new Scanner(f);
                String content = sc.next();
                System.out.println(content);
                byte[] decodedBytes = Base64.getDecoder().decode(content.getBytes());
                String userJson = new String(decodedBytes);
                currentUser = new Gson().fromJson(userJson,User.class);
                loggedInPanel.setVisible(true);
                userName.setText(currentUser.getName());
                return;
            }
        }
        catch (Exception e){
        }
        loggedOutPanel.setVisible(true);
        currentUser = null;
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
                        errorCheckIn.setText("Date cannot be ahead of current date");
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
            errorCheckIn.setVisible(true);
            errorCheckIn.setText("Please choose checkin date");
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
                        errorCheckOut.setText("Date should be ahead of checkin date");
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
        if(currentUser==null){

        }
        System.out.print("Submit Button Clicked");
        if(checkinStatus!=2){
            errorCheckIn.setVisible(true);
            errorCheckIn.setText("Please choose checkin date");
            return;
        }
        if(checkoutStatus!=2){
            errorCheckOut.setVisible(true);
            errorCheckOut.setText("Please choose checkout date");
            return;
        }
        errorAdults.setVisible(false);
        errorChild.setVisible(false);
        try {
            if (Integer.parseInt(adult.getSelectedItem().toString()) <= 0) {
                errorAdults.setVisible(true);
                errorAdults.setText("Choose at least 1 adult");
                return;
            }
        }
        catch (Exception ex){
            errorAdults.setVisible(true);
            errorAdults.setText("Enter a valid number");
            return;
        }
        try {
            Integer.parseInt(child.getSelectedItem().toString());
        }
        catch (Exception ex){
            errorChild.setVisible(true);
            errorChild.setText("Enter a valid number");
            return;
        }
        Bookings newBooking = new Bookings();
        newBooking.uid = currentUser.getUsername();
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
        try {
            Date c_in = format.parse(checkin.getText());
            Date c_out = format.parse(checkout.getText());
            newBooking.check_in_date = c_in;
            newBooking.check_out_date = c_out;
            newBooking.adult_count = Integer.parseInt(adult.getSelectedItem().toString());
            newBooking.child_count = Integer.parseInt(child.getSelectedItem().toString());
            ArrayList<HotelTab> hlist= MysqlCon.getInstance().gethotels(cityChooser.getSelectedItem().toString(),c_in,c_out);
            container hotel_list = new container(hlist);
            JScrollPane pane=new JScrollPane();
            pane.getViewport().add(hotel_list);
            parent.remove(this);
            parent.add(pane);
            parent.pack();
            parent.setVisible(true);
            for(HotelTab t:hlist){
                t.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.print(t.name);
                        HotelObject obj = MysqlCon.getInstance().display_hotel(t.hotel_id.getText());
                        if(obj==null){
                            return;
                        }
                        else{
                            JFrame hotelHolder = new JFrame();
                            Hotel hotel = new Hotel(obj,newBooking,hotelHolder);
                            hotelHolder.add(hotel);
                            hotelHolder.pack();
                            hotelHolder.setVisible(true);
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }
        }
        catch (Exception ex){

        }
    }

    private void doLogin(ActionEvent e) {
        JFrame loginFrame = new JFrame();
        LoginPortal loginwindow = new LoginPortal(loginFrame);
        loginwindow.setVisible(true);
        loginFrame.add(loginwindow);
        loginFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        loginFrame.pack();
        this.parent.setEnabled(false);
        loginFrame.setVisible(true);
        loginFrame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                if(loginwindow.getCurrentUser()!=null){
                    currentUser = loginwindow.getCurrentUser();
                    loggedInPanel.setVisible(true);
                    loggedOutPanel.setVisible(false);
                    userName.setText(currentUser.getName());
                }
                parent.setEnabled(true);
                parent.setVisible(true);
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

    private void doLogOut(ActionEvent e) {
        try {
            File f = new File(getClass().getResource("/bits/oops/project/user.csf").toURI());
            f.delete();
            currentUser=null;
            loggedInPanel.setVisible(false);
            loggedOutPanel.setVisible(true);
        }
        catch (Exception ex){

        }
    }

    private void displayProfile(ActionEvent e) {
        ProfileDisplay profileFrame = new ProfileDisplay(currentUser);
        profileFrame.pack();
        profileFrame.setVisible(true);
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
        adult = new JComboBox<>();
        label3 = new JLabel();
        child = new JComboBox<>();
        errorAdults = new JLabel();
        errorChild = new JLabel();
        checkout = new JLabel();
        button1 = new JButton();
        loggedInPanel = new JPanel();
        label6 = new JLabel();
        userName = new JLabel();
        button3 = new JButton();
        profile = new JButton();
        loggedOutPanel = new JPanel();
        label7 = new JLabel();
        button2 = new JButton();
        errorCheckIn = new JLabel();
        errorCheckOut = new JLabel();

        //======== this ========
        setBackground(Color.white);

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
        label1.setFont(new Font("Swis721 BlkOul BT", Font.PLAIN, 20));
        label1.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/logo36.png")));

        //---- guestsLabel ----
        guestsLabel.setText("Guests                 :");

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);

            //---- label2 ----
            label2.setText("Adults");

            //---- adult ----
            adult.setModel(new DefaultComboBoxModel<>(new String[] {
                "1",
                "2",
                "3",
                "4"
            }));
            adult.setEditable(true);

            //---- label3 ----
            label3.setText("Child(<18)");

            //---- child ----
            child.setModel(new DefaultComboBoxModel<>(new String[] {
                "0",
                "1",
                "2",
                "3",
                "4"
            }));
            child.setEditable(true);

            //---- errorAdults ----
            errorAdults.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/error.png")));
            errorAdults.setText("Number of adults can't be zero");
            errorAdults.setForeground(Color.red);

            //---- errorChild ----
            errorChild.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/error.png")));
            errorChild.setText("Choose a valid number");
            errorChild.setForeground(Color.red);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(adult, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(errorAdults))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(child, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(errorChild)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(adult, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(errorAdults))
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(child, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(errorChild))
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
        button1.setBackground(new Color(255, 102, 0));
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
            button3.addActionListener(e -> doLogOut(e));

            //---- profile ----
            profile.setText("PROFILE");
            profile.addActionListener(e -> displayProfile(e));

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
                            .addComponent(userName)
                            .addGroup(GroupLayout.Alignment.TRAILING, loggedInPanelLayout.createSequentialGroup()
                                .addComponent(profile)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button3)))
                        .addContainerGap())
            );
            loggedInPanelLayout.setVerticalGroup(
                loggedInPanelLayout.createParallelGroup()
                    .addGroup(loggedInPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(loggedInPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button3)
                            .addComponent(profile))
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
            button2.addActionListener(e -> doLogin(e));

            GroupLayout loggedOutPanelLayout = new GroupLayout(loggedOutPanel);
            loggedOutPanel.setLayout(loggedOutPanelLayout);
            loggedOutPanelLayout.setHorizontalGroup(
                loggedOutPanelLayout.createParallelGroup()
                    .addGroup(loggedOutPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(loggedOutPanelLayout.createParallelGroup()
                            .addGroup(loggedOutPanelLayout.createSequentialGroup()
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, loggedOutPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(button2)))
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
        errorCheckIn.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/error.png")));
        errorCheckIn.setText("Date cannot be ahead of current date");
        errorCheckIn.setForeground(Color.red);

        //---- errorCheckOut ----
        errorCheckOut.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/error.png")));
        errorCheckOut.setForeground(Color.red);
        errorCheckOut.setText("Date cannot..");

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
                                    .addComponent(errorCheckIn))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(checkoutLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(checkout, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(errorCheckOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(guestsLabel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(loggedInPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(loggedOutPanel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(loggedInPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(loggedOutPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cityLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(cityChooser, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(checkinLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkin, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(errorCheckIn))
                            .addGroup(layout.createParallelGroup()
                                .addComponent(checkoutLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkout, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(errorCheckOut))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(guestsLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(55, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        loggedInPanel.setVisible(false);
        loggedOutPanel.setVisible(false);
        errorCheckIn.setVisible(false);
        errorCheckOut.setVisible(false);
        errorAdults.setVisible(false);
        errorChild.setVisible(false);
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
    private JComboBox<String> adult;
    private JLabel label3;
    private JComboBox<String> child;
    private JLabel errorAdults;
    private JLabel errorChild;
    private JLabel checkout;
    private JButton button1;
    private JPanel loggedInPanel;
    private JLabel label6;
    private JLabel userName;
    private JButton button3;
    private JButton profile;
    private JPanel loggedOutPanel;
    private JLabel label7;
    private JButton button2;
    private JLabel errorCheckIn;
    private JLabel errorCheckOut;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JFrame parent;
    int checkinStatus,checkoutStatus;
    User currentUser;
    public static void main(String args[]){
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,500);
        LandingPage panelLanding = new LandingPage(frame);
        panelLanding.setSize(500,500);
        frame.add(panelLanding);
        panelLanding.setVisible(true);
        frame.setVisible(true);
    }
}
