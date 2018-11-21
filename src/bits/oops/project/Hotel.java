/*
 * Created by JFormDesigner on Sun Nov 11 20:39:30 IST 2018
 */

package bits.oops.project;

import org.json.JSONObject;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class Hotel extends JPanel {
    JFrame parent;
    int revPos;
    ArrayList<NewRoomDisplay> roomsadded;
    int adultsadded,childadded;
    Bookings bookingData;
    public Hotel(HotelObject obj, Bookings bookingData, JFrame parent) {
        this.hotelData = obj;
        this.bookingData=bookingData;
        this.parent=parent;
        initComponents();
        errorProceed.setVisible(false);
        hotel_name.setText(hotelData.name);
        location_field.setText("<html>"+hotelData.address+"</html>");
        starCategory.setText("- "+hotelData.star_category+" Star");
        double rating =hotelData.getRating();
        if(rating==-1){
            rating_label.setText("Rating: No Data");
        }
        else{
            rating_label.setText("Rating: " + rating + " / 5.0");
        }
        desc_field.setText("<html>"+hotelData.description+"</html>");
        rating5.setText("5 -> "+ hotelData.get5ratings()+" %");
        rating4.setText("4 -> "+ hotelData.get4ratings()+" %");
        rating3.setText("3 -> "+ hotelData.get3ratings()+" %");
        rating2.setText("2 -> "+ hotelData.get2ratings()+" %");
        rating1.setText("1 -> "+ hotelData.get1ratings()+" %");
        roomsPanel.setVisible(false);
        loadingRooms.setVisible(true);
        rooms = MysqlCon.getInstance().display_rooms(hotelData.hid);
        roomsadded = new ArrayList<>();
        for(RoomObject r:rooms){
            Room roomholder=new Room(r);
            roomsPanel.getViewport().add(roomholder);
            roomholder.bookButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final NewRoomDisplay roomView = new NewRoomDisplay(r);
                    roomView.room_no.setText("Room "+roomsadded.size());
                    roomView.title.setText(r.getTitle());
                    roomsadded.add(roomView);
                    roomView.adultfield.setText(r.getSize()+"");
                    bookingSection.add(roomView,new GridBagConstraints(0, roomsadded.size(), 1, 1, 1.0, 1.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    bookingSection.updateUI();
                    if(roomsadded.size()>1)
                        roomsadded.get(roomsadded.size()-2).remove.setEnabled(true);
                    roomView.remove.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            roomsadded.remove(roomsadded.size()-1);
                            if(roomsadded.size()!=0)
                            roomsadded.get(roomsadded.size()-1).remove.setEnabled(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });
                }
            });
        }
        roomsPanel.updateUI();
        roomsPanel.getViewport().updateUI();
        loadingRooms.setVisible(false);
        roomsPanel.setVisible(true);
        ArrayList<ReviewPanel> panels = new ArrayList<>();
        for(Review r:hotelData.reviews){
            System.out.println("Adding" +r.comment);
            panels.add(new ReviewPanel(r));
        }
        if(panels.size()==0){
            arrowL.setEnabled(false);
            arrowR.setEnabled(false);
            JLabel label = new JLabel("No Reviews");
            reviewHolder.getViewport().add(label);
        }
        else{
            revPos=0;
            arrowL.setEnabled(false);
            if(panels.size()==1)
                arrowR.setEnabled(false);
            reviewHolder.getViewport().add(panels.get(0));
            arrowL.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    reviewHolder.getViewport().remove(panels.get(revPos--));
                    reviewHolder.getViewport().add(panels.get(revPos));
                    reviewHolder.getViewport().updateUI();
                    if(revPos == 0) arrowL.setEnabled(false);
                    arrowR.setEnabled(true);
                }
            });
            arrowR.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    reviewHolder.getViewport().remove(panels.get(revPos++));
                    reviewHolder.getViewport().add(panels.get(revPos));
                    reviewHolder.getViewport().updateUI();
                    if(revPos == panels.size()-1) arrowR.setEnabled(false);
                    arrowL.setEnabled(true);
                }
            });
        }
    }

    private void checkAvailablity(ActionEvent e) {
        bookingData.hid = hotelData.hid;
        int a_count=0,c_count=0;
        double cost=0;
        bookingData.rooms=new JSONObject();
        try {
            for (NewRoomDisplay d : roomsadded) {
                a_count += Integer.parseInt(d.adultfield.getText());
                c_count += Integer.parseInt(d.childfield.getText());
                cost += d.room.getPrice();
                if (bookingData.rooms.has(d.room.getRid())) {
                    bookingData.rooms.put(d.room.getRid(), bookingData.rooms.getInt(d.room.getRid()) + 1);
                } else bookingData.rooms.put(d.room.getRid(), 1);
            }
        }
        catch (Exception ex){
            errorProceed.setVisible(true);
            return;
        }
        if(a_count!=bookingData.adult_count || c_count!=bookingData.child_count){
            errorProceed.setVisible(true);
            return;
        }
        errorProceed.setVisible(false);
        bookingData.cost = (int)cost;
        int status = MysqlCon.getInstance().check(bookingData);
        BookingFrame bookingFrame = new BookingFrame(bookingData,status);
        parent.setEnabled(false);
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
        reviewPanel = new JPanel();
        arrowL = new JLabel();
        reviewHolder = new JScrollPane();
        arrowR = new JLabel();
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
        roomsPanel = new JScrollPane();
        label11 = new JLabel();
        starCategory = new JLabel();
        loadingRooms = new JLabel();
        bookingSection = new JPanel();
        label1 = new JLabel();
        proceed = new JButton();
        errorProceed = new JLabel();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


        //---- rating_label ----
        rating_label.setText("Rating: 5.0/5.0");
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

        //======== reviewPanel ========
        {
            reviewPanel.setBorder(new TitledBorder(null, "Reviews", TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Papyrus", Font.PLAIN, 16)));
            reviewPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)reviewPanel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
            ((GridBagLayout)reviewPanel.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)reviewPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)reviewPanel.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- arrowL ----
            arrowL.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/arrow_l.png")));
            arrowL.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            reviewPanel.add(arrowL, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //======== reviewHolder ========
            {
                reviewHolder.setBorder(null);
                reviewHolder.setPreferredSize(new Dimension(200, 100));
                reviewHolder.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                reviewHolder.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            }
            reviewPanel.add(reviewHolder, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- arrowR ----
            arrowR.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/arrow_r.png")));
            arrowR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            reviewPanel.add(arrowR, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        }

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

        //======== roomsPanel ========
        {
            roomsPanel.setBorder(LineBorder.createBlackLineBorder());
        }

        //---- label11 ----
        label11.setText("Room Categories");
        label11.setFont(new Font("Segoe UI", Font.BOLD, 14));

        //---- starCategory ----
        starCategory.setText("- 7 Star");
        starCategory.setFont(new Font("Pristina", Font.PLAIN, 24));

        //---- loadingRooms ----
        loadingRooms.setText("Loading...");

        //======== bookingSection ========
        {
            bookingSection.setBorder(new TitledBorder(null, "Booking Summary", TitledBorder.CENTER, TitledBorder.TOP,
                new Font("Papyrus", Font.PLAIN, 16)));
            bookingSection.setLayout(new GridBagLayout());
            ((GridBagLayout)bookingSection.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)bookingSection.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)bookingSection.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
            ((GridBagLayout)bookingSection.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("Start adding rooms from left panel");
            bookingSection.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        }

        //---- proceed ----
        proceed.setText("PROCEED");
        proceed.setBackground(new Color(255, 102, 0));
        proceed.setBorder(new EtchedBorder());
        proceed.setForeground(Color.white);
        proceed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        proceed.addActionListener(e -> checkAvailablity(e));

        //---- errorProceed ----
        errorProceed.setText("<html>Number of adults and child do not match</html>");
        errorProceed.setIcon(new ImageIcon(getClass().getResource("/bits/oops/project/error.png")));
        errorProceed.setForeground(Color.red);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(hotel_img, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup()
                                        .addComponent(location_label)
                                        .addComponent(amenities_label)
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(location_field, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(hotel_name)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(starCategory))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(desc_label)))
                            .addGap(0, 273, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(desc_field, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label11)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(loadingRooms))
                                .addComponent(roomsPanel, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup()
                        .addComponent(rating_label)
                        .addComponent(proceed, GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(errorProceed, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rating4)
                                    .addComponent(rating5)
                                    .addComponent(rating3)
                                    .addComponent(rating2)
                                    .addComponent(rating1)
                                    .addComponent(reviewPanel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(bookingSection, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(hotel_name)
                                .addComponent(rating_label)))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(starCategory)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(hotel_img, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(desc_label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(desc_field)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label11)
                                .addComponent(loadingRooms))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(roomsPanel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(89, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(location_label)
                                .addComponent(rating5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(location_field)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(amenities_label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rating4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rating3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rating2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rating1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(reviewPanel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(bookingSection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(proceed)
                                .addComponent(errorProceed, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 207, Short.MAX_VALUE))))
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
    private JPanel reviewPanel;
    private JLabel arrowL;
    private JScrollPane reviewHolder;
    private JLabel arrowR;
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
    private JScrollPane roomsPanel;
    private JLabel label11;
    private JLabel starCategory;
    private JLabel loadingRooms;
    private JPanel bookingSection;
    private JLabel label1;
    private JButton proceed;
    private JLabel errorProceed;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    HotelObject hotelData;
    ArrayList<RoomObject> rooms;
//    public static void main(String args[]){
//        JFrame frame=new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        HotelObject obj=new HotelObject();
//        obj.name="Taj Banjara";
//        obj.star_category = 5;
//        obj.address = "Road number 18, Banjara Hill, Hyderabad, Telangana";
//        obj.description = " Most popular 5-star hotel located in the heart of hyderabad city offering an amazing view of the Buddha Statue at Hussain Sagar Lake.";
//        obj.reviews = new ArrayList<>();
//        for(int i=0;i<5;i++){
//            Review r=new Review();
//            r.rating = 4;
//            for(int j=0;j<2;j++)
//                r.comment += "Review "+i;
//            obj.reviews.add(r);
//        }
//        Hotel hpanel = new Hotel(obj);
//        hpanel.setSize(1000,1000);
//        frame.add(hpanel);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
