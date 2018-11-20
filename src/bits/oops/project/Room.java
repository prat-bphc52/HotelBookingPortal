/*
 * Created by JFormDesigner on Tue Nov 13 16:35:08 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Utkarsh grover
 */
public class Room extends JPanel {

    public Room(RoomObject roomObject) {
        this.roomData = roomObject;
        initComponents();
        room_title.setText(roomData.getTitle());
        room_shortdesc.setText(roomData.getDescription());
        room_longdesc.setText(roomData.getAmenities());
        costLabel.setText("$ "+roomData.getPrice()+"/night");
    }

    private void initComponents() {
        System.out.print("here");
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        room_title = new JLabel();
        room_img = new JLabel();
        room_shortdesc = new JLabel();
        room_longdesc = new JLabel();
        costLabel = new JLabel();
        bookButton = new JButton();

        //======== this ========
        setMinimumSize(null);
        setPreferredSize(new Dimension(800, 200));
        setMaximumSize(null);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- room_title ----
        room_title.setText("Super Deluxe");
        room_title.setFont(new Font("Pristina", Font.BOLD, 24));

        //---- room_img ----
        room_img.setText("photo of the room");
        room_img.setBorder(LineBorder.createBlackLineBorder());

        //---- room_shortdesc ----
        room_shortdesc.setText("Twin Bed Room for 2 with Buffet Breakfast");
        room_shortdesc.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 16));

        //---- room_longdesc ----
        room_longdesc.setText("<html>Room facilities: Mini Bar, Buffet Breakfast, Complementary airport pickup/drop</html>");
        room_longdesc.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 14));

        //---- costLabel ----
        costLabel.setText("$ 4000/night");
        costLabel.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 16));

        //---- bookButton ----
        bookButton.setText("ADD");
        bookButton.setBackground(new Color(255, 102, 0));
        bookButton.setBorder(new EtchedBorder());
        bookButton.setForeground(Color.white);
        bookButton.setFont(new Font("Swis721 LtEx BT", Font.BOLD, 12));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(room_img, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(room_shortdesc, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(room_longdesc, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 23, Short.MAX_VALUE))))
                        .addComponent(room_title))
                    .addGap(0, 28, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(costLabel, GroupLayout.Alignment.TRAILING)
                        .addComponent(bookButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(room_title)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(room_shortdesc)
                                .addComponent(costLabel))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bookButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(room_img, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                            .addComponent(room_longdesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(18, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Prateek Agarwal
    private JLabel room_title;
    private JLabel room_img;
    private JLabel room_shortdesc;
    private JLabel room_longdesc;
    private JLabel costLabel;
    JButton bookButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    String roomTitle, roomImg, roomShortdesc, roomLongdesc, cost;
    RoomObject roomData;

    public static void main(String args[]){
//        JFrame frame=new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Room obj=new Room();
//        obj.setSize(400,400);
//        obj.setVisible(true);
//        frame.add(obj);
//        frame.pack();
//        frame.setVisible(true);
    }
}
