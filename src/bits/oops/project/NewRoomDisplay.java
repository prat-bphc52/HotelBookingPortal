/*
 * Created by JFormDesigner on Wed Nov 21 13:38:18 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import javax.swing.*;

/**
 * @author Prateek Agarwal
 */
public class NewRoomDisplay extends JPanel {
    RoomObject room;
    public NewRoomDisplay(RoomObject room) {
        this.room=room;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        room_no = new JLabel();
        label3 = new JLabel();
        adultfield = new JTextField();
        remove = new JLabel();
        title = new JLabel();
        label4 = new JLabel();
        childfield = new JTextField();
        extra = new JCheckBox();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 39, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

        //---- room_no ----
        room_no.setText("Room 1");
        room_no.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(room_no, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- label3 ----
        label3.setText("Adults:");
        add(label3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- adultfield ----
        adultfield.setText("0");
        add(adultfield, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- remove ----
        remove.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/remove.png")));
        add(remove, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- title ----
        title.setText("Super Deluxe");
        title.setFont(new Font("Segoe UI", Font.BOLD, 12));
        add(title, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label4 ----
        label4.setText("Child:");
        add(label4, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- childfield ----
        childfield.setText("0");
        add(childfield, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- extra ----
        extra.setText("Add Extra person");
        add(extra, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Prateek Agarwal
    public JLabel room_no;
    private JLabel label3;
    public JTextField adultfield;
    public JLabel remove;
    public JLabel title;
    private JLabel label4;
    public JTextField childfield;
    public JCheckBox extra;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
