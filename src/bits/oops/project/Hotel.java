/*
 * Created by JFormDesigner on Sun Nov 11 20:39:30 IST 2018
 */

package bits.oops.project;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class Hotel extends JPanel {
    public Hotel(HotelObject obj) {
        this.hotelData = obj;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        rating_label = new JLabel();
        location_label = new JLabel();
        amenities_label = new JLabel();
        hotel_name = new JLabel();
        location_field = new JLabel();
        hotel_img = new JLabel();
        desc_label = new JLabel();
        desc_field = new JLabel();
        rating5 = new JLabel();
        rating3 = new JLabel();
        rating2 = new JLabel();
        rating1 = new JLabel();
        reviewPanel = new JScrollPane();
        rating4 = new JLabel();
        panel1 = new JPanel();
        a1 = new JLabel();
        a2 = new JLabel();
        a3 = new JLabel();
        a4 = new JLabel();
        a5 = new JLabel();
        a6 = new JLabel();
        a7 = new JLabel();
        a8 = new JLabel();
        a9 = new JLabel();
        scrollPane2 = new JScrollPane();
        label11 = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- rating_label ----
        rating_label.setText("Rating : 5.0 / 5.0");
        rating_label.setFont(new Font("Papyrus", Font.PLAIN, 20));

        //---- location_label ----
        location_label.setText("Location");
        location_label.setFont(location_label.getFont().deriveFont(location_label.getFont().getStyle() | Font.BOLD, location_label.getFont().getSize() + 2f));

        //---- amenities_label ----
        amenities_label.setText("Amenities");
        amenities_label.setFont(amenities_label.getFont().deriveFont(amenities_label.getFont().getStyle() | Font.BOLD, amenities_label.getFont().getSize() + 2f));

        //---- hotel_name ----
        hotel_name.setText("Taj Mahal Mumbai");
        hotel_name.setFont(new Font("Pristina", Font.BOLD, 24));

        //---- location_field ----
        location_field.setText("Mumbai");

        //---- hotel_img ----
        hotel_img.setText("Image");
        hotel_img.setMinimumSize(new Dimension(200, 200));
        hotel_img.setMaximumSize(new Dimension(400, 400));
        hotel_img.setIcon(new ImageIcon("C:\\Users\\pratd\\Pictures\\Dubai Trip\\Pixel\\IMG_20180312_211154.jpg"));
        hotel_img.setPreferredSize(new Dimension(300, 300));

        //---- desc_label ----
        desc_label.setText("Description");
        desc_label.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- desc_field ----
        desc_field.setText("Luxurious Hotel in Mumbai");

        //---- rating5 ----
        rating5.setText("5 -> 50%");
        rating5.setFont(rating5.getFont().deriveFont(rating5.getFont().getSize() + 3f));
        rating5.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/star.png")));

        //---- rating3 ----
        rating3.setText("3 -> 0%");
        rating3.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/star.png")));
        rating3.setFont(rating3.getFont().deriveFont(rating3.getFont().getSize() + 3f));

        //---- rating2 ----
        rating2.setText("2 -> 0%");
        rating2.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/star.png")));
        rating2.setFont(rating2.getFont().deriveFont(rating2.getFont().getSize() + 3f));

        //---- rating1 ----
        rating1.setText("1 -> 0%");
        rating1.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/star.png")));
        rating1.setFont(rating1.getFont().deriveFont(rating1.getFont().getSize() + 3f));

        //---- rating4 ----
        rating4.setText("4 -> 0%");
        rating4.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/star.png")));
        rating4.setFont(rating4.getFont().deriveFont(rating4.getFont().getSize() + 3f));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(3, 3));

            //---- a1 ----
            a1.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/parking_icon.png")));
            panel1.add(a1);
            panel1.add(a2);
            panel1.add(a3);
            panel1.add(a4);
            panel1.add(a5);
            panel1.add(a6);
            panel1.add(a7);
            panel1.add(a8);
            panel1.add(a9);
        }

        //======== scrollPane2 ========
        {
            scrollPane2.setBorder(LineBorder.createBlackLineBorder());
        }

        //---- label11 ----
        label11.setText("Room Categories");
        label11.setFont(new Font("Segoe UI", Font.BOLD, 14));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(hotel_img, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(location_field, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(location_label)
                                .addComponent(amenities_label)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(hotel_name))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(desc_field, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(label11)
                                        .addComponent(desc_label))
                                    .addGap(0, 346, Short.MAX_VALUE)))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rating_label)
                                .addGap(78, 78, 78))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(reviewPanel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(rating4)
                                .addComponent(rating5)
                                .addComponent(rating3)
                                .addComponent(rating2)
                                .addComponent(rating1)))))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(677, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(hotel_name, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rating_label))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(location_label)
                                .addComponent(rating5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rating4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rating3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rating2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rating1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                    .addGap(73, 73, 73)
                                    .addComponent(reviewPanel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(location_field)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(amenities_label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hotel_img, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(desc_label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(desc_field)))
                    .addGap(18, 18, 18)
                    .addComponent(label11)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(199, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Prateek Agarwal
    private JLabel rating_label;
    private JLabel location_label;
    private JLabel amenities_label;
    private JLabel hotel_name;
    private JLabel location_field;
    private JLabel hotel_img;
    private JLabel desc_label;
    private JLabel desc_field;
    private JLabel rating5;
    private JLabel rating3;
    private JLabel rating2;
    private JLabel rating1;
    private JScrollPane reviewPanel;
    private JLabel rating4;
    private JPanel panel1;
    private JLabel a1;
    private JLabel a2;
    private JLabel a3;
    private JLabel a4;
    private JLabel a5;
    private JLabel a6;
    private JLabel a7;
    private JLabel a8;
    private JLabel a9;
    private JScrollPane scrollPane2;
    private JLabel label11;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    HotelObject hotelData;
}
