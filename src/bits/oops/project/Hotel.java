/*
 * Created by JFormDesigner on Sun Nov 11 20:39:30 IST 2018
 */

package bits.oops.project;

import javax.swing.*;
import java.awt.*;

/**
 * @author unknown
 */
public class Hotel extends JPanel {
    public Hotel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Utkarsh grover
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label1 = new JLabel();
        label7 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        scrollPane1 = new JScrollPane();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- label2 ----
        label2.setText("REVIEWS : 4.5/5");
        label2.setFont(new Font("Open Sans", Font.BOLD, 19));

        //---- label3 ----
        label3.setText("Location");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 2f));

        //---- label4 ----
        label4.setText("Amenities");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 2f));

        //---- label5 ----
        label5.setText("#hotelName (temp)");
        label5.setFont(new Font("PlainBlackWide", Font.PLAIN, 20));

        //---- label6 ----
        label6.setText("#yahan location aayega (temp)");

        //---- label8 ----
        label8.setText("photo if possible");

        //---- label9 ----
        label9.setText("Description");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD, label9.getFont().getSize() + 2f));

        //---- label10 ----
        label10.setText("#yahan description aayega");

        //---- label11 ----
        label11.setText("text");

        //---- label1 ----
        label1.setText("5 -> 50%");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        label1.setIcon(new ImageIcon(getClass().getResource("bits/oops/project/star_icon.png")));

        //---- label7 ----
        label7.setText("4 -> 50%");
        label7.setIcon(new ImageIcon("/home/euge/Downloads/star_icon.png"));
        label7.setFont(label7.getFont().deriveFont(label7.getFont().getSize() + 3f));

        //---- label12 ----
        label12.setText("3 -> 0%");
        label12.setIcon(new ImageIcon("/home/euge/Downloads/star_icon.png"));
        label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 3f));

        //---- label13 ----
        label13.setText("2 -> 0%");
        label13.setIcon(new ImageIcon("/home/euge/Downloads/star_icon.png"));
        label13.setFont(label13.getFont().deriveFont(label13.getFont().getSize() + 3f));

        //---- label14 ----
        label14.setText("1 -> 0%");
        label14.setIcon(new ImageIcon("/home/euge/Downloads/star_icon.png"));
        label14.setFont(label14.getFont().deriveFont(label14.getFont().getSize() + 3f));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(label8, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 118, Short.MAX_VALUE))
                                .addComponent(label11, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                        .addComponent(label10, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label5)
                                .addComponent(label9, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 203, Short.MAX_VALUE)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(label1)
                        .addComponent(label7)
                        .addComponent(label13)
                        .addComponent(label12)
                        .addComponent(label14)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label8, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addGap(140, 140, 140))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label12, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label11, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label13, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label14, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                            .addComponent(label10, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(12, Short.MAX_VALUE))))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Utkarsh grover
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label1;
    private JLabel label7;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
