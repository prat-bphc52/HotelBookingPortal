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

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new Font("Dialog", Font.BOLD, 12),
                Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- label2 ----
        label2.setText("REVIEWS : 4.5/5");
        label2.setFont(new Font("Open Sans", Font.PLAIN, 14));

        //---- label3 ----
        label3.setText("Location");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

        //---- label4 ----
        label4.setText("Amenities");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- label5 ----
        label5.setText("#hotelName (temp)");
        label5.setFont(new Font("PlainBlackWide", Font.PLAIN, 20));

        //---- label6 ----
        label6.setText("#yahan location aayega (temp)");

        //---- label8 ----
        label8.setText("photo if possible");

        //---- label9 ----
        label9.setText("Description");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 2f));

        //---- label10 ----
        label10.setText("#yahan description aayega");

        //---- label11 ----
        label11.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label5)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label10, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label9, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup()
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 176, Short.MAX_VALUE))
                                        .addComponent(label11, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label2)
                            .addGap(43, 43, 43)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(label6, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .addGap(10, 10, 10)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label11, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10))
                        .addComponent(label8, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label10, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
