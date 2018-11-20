package bits.oops.project;

import com.google.gson.Gson;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.Base64;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Mon Nov 19 20:06:01 IST 2018
 */



/**
 * @author Shreeya Nelekar
 */
public class LoginPortal extends JPanel {
    public LoginPortal(JFrame parent) {
        this.parent = parent;
        initComponents();
        error.setVisible(false);
        currentUser=null;
    }

    private void button1ActionPerformed(ActionEvent e) {
        this.parent.setEnabled(false);
        JFrame registerframe = new JFrame();
        registerframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        login_portal registerwindow = new login_portal(registerframe);
        registerframe.add(registerwindow);
        registerframe.pack();
        registerwindow.setVisible(true);
        registerframe.setVisible(true);
        parent.setEnabled(false);
        registerframe.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                if(registerwindow.registeredUser!=null){
                    currentUser = registerwindow.registeredUser;
                    parent.dispose();
                }
                else {
                    parent.setEnabled(true);
                    parent.setVisible(true);
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

    private void doLogin(ActionEvent e) {
        String user_name = username.getText();
        String pwd = password.getPassword().toString();
        if(user_name.equals("") || pwd.equals("")){
            error.setVisible(true);
            return;
        }
        currentUser  = MysqlCon.getInstance().login(user_name,pwd);
        if(currentUser==null){
            error.setVisible(true);
            return;
        }
        error.setVisible(false);
        File f=null;
        try {
            f = new File(getClass().getResource("/bits/oops/project/user.csf").toURI());
        }
        catch(Exception ex) {

        }
        if(Remembermebox.isSelected() && f!=null){
            String json = new Gson().toJson(currentUser);
            String encoded = new String(Base64.getEncoder().encode(json.getBytes()));
         try {
             FileWriter fw = new FileWriter(f);
             fw.write(encoded);
             fw.flush();
             fw.close();
         }
         catch(Exception ex2) {
         }
         }

        else {
            try {
                if(f!=null)
                    f.delete();
            } catch (Exception ex) {

            }
        }
        parent.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        LoginPortal = new JLabel();
        label1 = new JLabel();
        username = new JFormattedTextField();
        Password = new JLabel();
        password = new JPasswordField();
        button1 = new JButton();
        newhere = new JLabel();
        Login = new JButton();
        Remembermebox = new JCheckBox();
        error = new JLabel();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.black);
        setBorder(new CompoundBorder(
            new CompoundBorder(),
            null));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- LoginPortal ----
        LoginPortal.setText("LOGIN PORTAL");
        LoginPortal.setHorizontalAlignment(SwingConstants.CENTER);
        LoginPortal.setForeground(Color.black);
        LoginPortal.setFont(new Font("Baskerville Old Face", LoginPortal.getFont().getStyle() | Font.BOLD, LoginPortal.getFont().getSize() + 5));

        //---- label1 ----
        label1.setText("USERNAME:");
        label1.setForeground(Color.black);
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 2f));

        //---- username ----
        username.setBackground(Color.white);
        username.setForeground(Color.black);
        username.setBorder(LineBorder.createBlackLineBorder());

        //---- Password ----
        Password.setText("PASSWORD:");
        Password.setBackground(Color.white);
        Password.setFont(Password.getFont().deriveFont(Password.getFont().getStyle() | Font.BOLD, Password.getFont().getSize() + 2f));
        Password.setForeground(Color.black);

        //---- password ----
        password.setForeground(Color.black);
        password.setBackground(Color.white);
        password.setBorder(LineBorder.createBlackLineBorder());

        //---- button1 ----
        button1.setText("REGISTER");
        button1.setBackground(new Color(0, 0, 51));
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 2f));
        button1.setForeground(Color.white);
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- newhere ----
        newhere.setText("New Here?");
        newhere.setForeground(new Color(0, 0, 51));
        newhere.setFont(newhere.getFont().deriveFont(newhere.getFont().getStyle() | Font.BOLD, newhere.getFont().getSize() + 2f));

        //---- Login ----
        Login.setText("LOGIN");
        Login.setFont(Login.getFont().deriveFont(Login.getFont().getStyle() | Font.BOLD, Login.getFont().getSize() + 2f));
        Login.setForeground(Color.white);
        Login.setBackground(new Color(0, 0, 51));
        Login.addActionListener(e -> doLogin(e));

        //---- Remembermebox ----
        Remembermebox.setText("Remember me?");
        Remembermebox.setBackground(Color.white);
        Remembermebox.setFont(Remembermebox.getFont().deriveFont(Remembermebox.getFont().getStyle() | Font.BOLD, Remembermebox.getFont().getSize() + 2f));
        Remembermebox.setForeground(new Color(0, 0, 102));
        Remembermebox.setBorderPainted(true);

        //---- error ----
        error.setText("Invalid Username or Password");
        error.setForeground(Color.red);
        error.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/error.png")));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(Remembermebox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Login, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(newhere)
                                                .addComponent(button1)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(error)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(username)
                                            .addComponent(password, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addComponent(LoginPortal, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(LoginPortal, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(error)
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(Password, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(newhere)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(Login))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(Remembermebox)
                    .addContainerGap(57, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Prateek Agarwal
    private JLabel LoginPortal;
    private JLabel label1;
    private JFormattedTextField username;
    private JLabel Password;
    private JPasswordField password;
    private JButton button1;
    private JLabel newhere;
    private JButton Login;
    private JCheckBox Remembermebox;
    private JLabel error;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    User currentUser;
    JFrame parent;
}
