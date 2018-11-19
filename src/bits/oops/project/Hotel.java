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
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        rating_label = new JLabel();
        location_label = new JLabel();
        amenities_label = new JLabel();
        hotel_name = new JLabel();
        location_field = new JLabel();
        hotel_img = new JLabel();
        desc_label = new JLabel();
        desc_field = new JLabel();
        amenities_field = new JLabel();
        rating5 = new JLabel();
        rating4 = new JLabel();
        rating3 = new JLabel();
        rating2 = new JLabel();
        rating1 = new JLabel();
        scrollPane1 = new JScrollPane();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- rating_label ----
        rating_label.setText("Rating : 5.0 / 5.0");
        rating_label.setFont(new Font("Open Sans", Font.BOLD, 19));

        //---- location_label ----
        location_label.setText("Location");
        location_label.setFont(location_label.getFont().deriveFont(location_label.getFont().getStyle() | Font.BOLD, location_label.getFont().getSize() + 2f));

        //---- amenities_label ----
        amenities_label.setText("Amenities");
        amenities_label.setFont(amenities_label.getFont().deriveFont(amenities_label.getFont().getStyle() | Font.BOLD, amenities_label.getFont().getSize() + 2f));

        //---- hotel_name ----
        hotel_name.setText("Taj Mahal Mumbai");
        hotel_name.setFont(new Font("PlainBlackWide", Font.PLAIN, 20));

        //---- location_field ----
        location_field.setText("Mumbai");

        //---- hotel_img ----
        hotel_img.setText("Image");

        //---- desc_label ----
        desc_label.setText("Description");
        desc_label.setFont(desc_label.getFont().deriveFont(desc_label.getFont().getStyle() | Font.BOLD, desc_label.getFont().getSize() + 2f));

        //---- desc_field ----
        desc_field.setText("Luxurious Hotel in Mumbai");

        //---- amenities_field ----
        amenities_field.setText("GYM, Swimming Pool, Valet Parking, ....");

        //---- rating5 ----
        rating5.setText("5 -> 50%");
        rating5.setFont(rating5.getFont().deriveFont(rating5.getFont().getSize() + 3f));
        rating5.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\star.png"));

        //---- rating4 ----
        rating4.setText("4 -> 50%");
        rating4.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\star.png"));
        rating4.setFont(rating4.getFont().deriveFont(rating4.getFont().getSize() + 3f));

        //---- rating3 ----
        rating3.setText("3 -> 0%");
        rating3.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\star.png"));
        rating3.setFont(rating3.getFont().deriveFont(rating3.getFont().getSize() + 3f));

        //---- rating2 ----
        rating2.setText("2 -> 0%");
        rating2.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\star.png"));
        rating2.setFont(rating2.getFont().deriveFont(rating2.getFont().getSize() + 3f));

        //---- rating1 ----
        rating1.setText("1 -> 0%");
        rating1.setIcon(new ImageIcon("C:\\Users\\pratd\\IdeaProjects\\HotelBookingPortal\\src\\bits\\oops\\project\\star.png"));
        rating1.setFont(rating1.getFont().deriveFont(rating1.getFont().getSize() + 3f));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(hotel_img, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(location_field, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(amenities_label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(location_label, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(amenities_field, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(hotel_name)
                                .addComponent(desc_label, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(desc_field, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(rating_label)
                        .addComponent(rating5)
                        .addComponent(rating4)
                        .addComponent(rating2)
                        .addComponent(rating3)
                        .addComponent(rating1)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(hotel_name, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(rating_label))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(hotel_img, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addGap(140, 140, 140))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(location_label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rating5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(location_field, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rating4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(amenities_label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(rating3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(rating2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(amenities_field))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(rating1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(desc_label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(desc_field))
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE))
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
    private JLabel amenities_field;
    private JLabel rating5;
    private JLabel rating4;
    private JLabel rating3;
    private JLabel rating2;
    private JLabel rating1;
    private JScrollPane scrollPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
