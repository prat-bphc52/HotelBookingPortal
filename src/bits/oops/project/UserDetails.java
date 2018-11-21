/*
 * Created by JFormDesigner on Wed Nov 21 05:18:31 IST 2018
 */

package bits.oops.project;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Rashi Jain
 */
public class UserDetails extends JDialog {
    public static JSONArray adults;
    public static JSONArray child;
    public static int adult_count;
    public static int child_count;
    public UserDetails(Frame owner, int adult_count, int child_count) {
        super(owner);
        initComponents();
        this.adult_count = adult_count;
        this.child_count = child_count;
        adults=new JSONArray();
        child=new JSONArray();
    }

    public UserDetails(Dialog owner, int adult_count, int child_count) {
        super(owner);
        initComponents();
        this.adult_count = adult_count ;
        this.child_count = child_count;
    }

    private void okButtonActionPerformed(ActionEvent e) {
        String nameText = name.getText();
        String ageText = age.getText();
        String contactText = contact.getText();
        JSONObject obj = new JSONObject();

        try {
            obj.put("name", nameText);
            obj.put("age", ageText);
            obj.put("contact", contactText);
            if (Integer.parseInt(ageText) < 18)
                child.put(obj);
            else {
                if(adults.length() == adult_count)
                    error.setText("YOU HAVE ALREADY ADDED " + adult_count + " ADULTS.");

                else
                    adults.put(obj);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        this.setVisible(false);

    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        name.setText("");
        age.setText("");
        contact.setText("");

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rashi Jain
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        name = new JTextField();
        label4 = new JLabel();
        age = new JTextField();
        contact = new JTextField();
        error = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("ENTER DETAILS");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("AGE:");

                //---- label3 ----
                label3.setText("CONTACT:");

                //---- label4 ----
                label4.setText("NAME:");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4)
                                .addComponent(label1)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(error, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contact, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 43, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addGap(7, 7, 7)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(age, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(contact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(error)
                            .addContainerGap(77, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rashi Jain
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label3;
    private JTextField name;
    private JLabel label4;
    private JTextField age;
    private JTextField contact;
    private JLabel error;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
