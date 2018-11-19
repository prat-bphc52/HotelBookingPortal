/*
 * Created by JFormDesigner on Tue Nov 13 16:35:08 IST 2018
 */

package bits.oops.project;

import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Utkarsh grover
 */
public class Room extends JPanel {
    public Room() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Utkarsh grover
        panel1 = new JPanel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();

        //======== panel1 ========
        {

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- label6 ----
            label6.setText("RoomType/Name");

            //---- label7 ----
            label7.setText("photo of the room");

            //---- label8 ----
            label8.setText("descrption of the room");

            //---- label9 ----
            label9.setText("detailed description of the room");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label6, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(label8, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                    .addComponent(label9, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label7, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(132, Short.MAX_VALUE))
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Utkarsh grover
    private JPanel panel1;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
