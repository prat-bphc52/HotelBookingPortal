/*
 * Created by JFormDesigner on Wed Nov 21 17:15:56 IST 2018
 */

package bits.oops.project;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Rashi Jain
 */
public class Hotel_tab extends JPanel {
    public Hotel_tab() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Rashi Jain
        Location = new JLabel();
        amenities = new JLabel();
        cost = new JLabel();
        nights = new JLabel();
        stars = new JLabel();
        hotel_id = new JLabel();
        name = new JLabel();
        imagestar = new JLabel();
        label4 = new JLabel();

        //======== this ========
        setBorder(LineBorder.createBlackLineBorder());

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- Location ----
        Location.setText("LOCATION");

        //---- amenities ----
        amenities.setText("AMENITIES");

        //---- cost ----
        cost.setText("cost");

        //---- nights ----
        nights.setText("Starting at:");

        //---- stars ----
        stars.setText("star");

        //---- hotel_id ----
        hotel_id.setText("HOTEL ID");

        //---- name ----
        name.setText("NAME");

        //---- imagestar ----
        imagestar.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/star.png")));

        //---- label4 ----
        label4.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(hotel_id, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(Location, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amenities, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
                            .addGap(446, 446, 446))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(name, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(stars, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(imagestar, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nights, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cost, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(hotel_id, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nights)
                        .addComponent(cost)
                        .addComponent(name))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(stars)
                                .addComponent(imagestar)))
                        .addComponent(Location)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                            .addComponent(amenities, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(43, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Rashi Jain
    public JLabel Location;
    public JLabel amenities;
    public JLabel cost;
    public JLabel nights;
    public JLabel stars;
    public JLabel hotel_id;
    public JLabel name;
    public JLabel imagestar;
    public JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
