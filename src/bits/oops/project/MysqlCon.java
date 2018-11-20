package bits.oops.project;

import org.json.JSONObject;

import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MysqlCon {
    static Connection con;
    static Statement smt;
    //String hid;
    //String uid;
    //ArrayList<String> rid;
    //int rooms;
    //int nights;
    //Date check_in_date;
    //Date check_out_date;
    //String book_ref;
    static MysqlCon instance=null;


    public static MysqlCon getInstance(){
        if(instance==null){
            instance=new MysqlCon();
        }
        return instance;
    }

    public MysqlCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver registered");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "draco");
            System.out.println("connection made");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }


     User login(String user, String pwd) {


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306//mydb" , "root" , "draco");
            smt = con.createStatement();
            ResultSet rs;
            if (user != "") {

                rs = smt.executeQuery("Select * from USER Where UID = ' " + user + " ' AND PASSWORD = '"+pwd+"';");
                if (rs.next()) {
                    User u = new User();
                    u.Name = rs.getString("NAME");
                    u.Username=rs.getString("UID");
                    u.Emailid=rs.getString("EMAIL");
                    u.password=rs.getString("PASSWORD");
                    u.Contact=rs.getString("CONTACT");
                    u.Address=rs.getString("ADDRESS");
                    return u;


                    }
                    else return null;
                } else
                    return null;


            }



         catch(Exception e)
        {
            return null;
        }

    }

     int register(String user, String name, String email, int phone, String address, String password) {
       // con = DriverManager.getConnection("jdbc:mysql://localhost/OOPS" , "root" , "draco");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "draco");
            System.out.println("connection established");
            smt = con.createStatement();
            ResultSet rs;
            if (user != "") {


                rs = smt.executeQuery("Select * from USER Where UID = '"+user+"'");
                System.out.println("uery executed");
                if (!rs.next()) {
                    PreparedStatement prep= con.prepareStatement("INSERT INTO USER (UID, NAME, EMAIL, PHONE, ADDRESS, PASSWORD) VALUES ('"+user+"','"+name+"','"+email+"','"+phone+"','"+address+"','"+password+"');");
                    prep.execute();
                    System.out.println("uery executed");

                    return 1;

                } else
                    return 0;

            }



        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return 3;


    }
     int register_id(int i)
    {

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPS" , "root" , "draco");
            smt = con.createStatement();
            int rs;
            rs = smt.executeUpdate("INSERT INTO USER (IDPROOF) VALUES (i)");
            return 1;
        }
        catch(Exception e)
        {
            return 0;
        }

    }
     ArrayList<HotelTab> _hotels(String location, Date check_in, Date check_out, int adults)
    {

        ArrayList<HotelTab> a1 = new ArrayList<>();
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPS" , "root" , "draco");
            smt=con.createStatement();
            ResultSet rs;
            rs=smt.executeQuery("SELECT * from HOTEL where CITY= ' " + location + " '; ");
            while(rs.next())
            {
                HotelTab h1 = new HotelTab();
                int hid = rs.getInt("HID");
                String name = rs.getString("NAME");
                String loc = rs.getString("ADDRESS");
                String amenities= rs.getString("AMENITIES");
                String description=rs.getString("DESCRIPTION");
                //Time check_in_time = rs.getTime("CHECK_IN_TIME");
                //Time check_out_time=rs.getTime("CHECK_OUT_TIME");
                int cost=rs.getInt("COST");
                int star = rs.getInt("HOTEL_STAR");
                String image = rs.getString("IMAGE");
                h1.Location.setText(loc);
                h1.amenities.setText(amenities);
                int nights = (int) Math.abs((check_in.getTime()-check_out.getTime())/86400000);
                h1.cost.setText("Rs " + nights*cost);
                h1.hotel_id.setText("" + hid);
                h1.image.setIcon(new ImageIcon(getClass().getResource(image))) ;
                h1.imagestar.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\HP\\IdeaProjects\\f213\\src")));
                h1.name.setText(name);
                h1.nights.setText("For " + nights + " nights: Starting at");
                h1.stars.setText(""+star);
                a1.add(h1);

            }
        }
        catch(Exception e)
        {

        }
        return a1;
    }

     void book_now(Bookings b1)
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPS", "root", "draco");
            smt = con.createStatement();
            ResultSet rs;
            int status = 0;
            Date CHECK_IN = b1.check_in_date;
            long timestamp = Calendar.getInstance().getTimeInMillis();
            b1.timestamp = timestamp;
            String timestamp2 = "" + timestamp;
            b1.ref = b1.hid + timestamp;
            ArrayList<String> a1 = new ArrayList<>();
            while (b1.rooms.keys().hasNext()) {
                String x = b1.rooms.keys().next().toString();
                a1.add(x);
            }


            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            while (CHECK_IN.compareTo(b1.check_out_date) < 0) {
                String str1 = dateFormat.format(CHECK_IN);
                String str2 = dateFormat.format(b1.check_out_date);


                for (int i = 0; i < a1.size(); i++) {
                    rs = smt.executeQuery("SELECT * from ROOM where HID= ' " + b1.hid + " ' AND RID = '" + a1.get(i) + "'; ");
                    rs.next();
                    String s = rs.getString("BOOKINGS");
                    JSONObject object = new JSONObject(s);
                    try {
                        String find_date = object.getString(str1);
                        if (Integer.parseInt(find_date) + Integer.parseInt(b1.rooms.getString(a1.get(i))) > rs.getInt("TOTALROOMS")) {
                            status = 1;
                        }
                    } catch (Exception e) {


                    }
                }
                Calendar c = Calendar.getInstance();
                c.setTime(CHECK_IN);
                c.add(Calendar.DATE, 1);
                CHECK_IN = c.getTime();

            }
            Date CHECK_IN2 = b1.check_in_date;
            if (status == 1) {

                JSONObject O = new JSONObject();
                while (CHECK_IN2.compareTo(b1.check_out_date) < 0) {
                    String str1 = dateFormat.format(CHECK_IN2);
                    String str2 = dateFormat.format(b1.check_out_date);

                    for (int i = 0; i < a1.size(); i++) {
                        rs = smt.executeQuery("SELECT * from ROOM where HID= ' " + b1.hid + " ' AND RID = '" + a1.get(i) + "'; ");
                        rs.next();
                        String s = rs.getString("WAITLIST");
                        JSONObject object = new JSONObject(s);
                        ResultSet r;
                        String find_value;
                        String s1;
                        try {
                            find_value = object.getString(str1);
                            str1 = "$." + str1;
                            s1 = "" + Integer.parseInt(find_value) + Integer.parseInt(b1.rooms.getString(a1.get(i)));
                        } catch (Exception e) {
                            s1 = b1.rooms.getString(a1.get(i));
                        }

                        int p = smt.executeUpdate("UPDATE ROOM SET WAITLIST = JSON_SET(WAITLIST, '" + str1 + "' , '" + s1 + "')  where HID= ' " + b1.hid + " ' AND RID = '" + a1.get(i) + "'; ");

                        //object.put(str1 , Integer.parseInt(find_value)+Integer.parseInt(b1.rooms.getString(a1.get(i))));
                        O.put(str1 + a1.get(i), s1);


                        // if (Integer.parseInt(str1) + a1.get(i).number > rs.getInt("TOTALROOMS")) {
                        // status = 1;

                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(CHECK_IN2);
                    c.add(Calendar.DATE, 1);
                    CHECK_IN2 = c.getTime();

                }
                b1.waitlist = O;
                String str1 = dateFormat.format(b1.check_in_date);
                String str2 = dateFormat.format(b1.check_out_date);
                int row = smt.executeUpdate("INSERT INTO BOOKINGS (REF, UID, HID, ADULTS, CHILD, ROOMS, CHECK_IN, CHECK_OUT, COST, TIMESTAMP, STATUS, WAITLIST) VALUES ('" + b1.ref + "','" + b1.uid + "','" + b1.hid + "','" + b1.adults + "','" + b1.child + "', '" + b1.rooms + "','" + str1 + "', '" + str2 + "' ,'" + b1.cost + "', '" + timestamp2 + "' , 'waiting', '" + b1.waitlist + "');");

            } else {


                while (CHECK_IN2.compareTo(b1.check_out_date) < 0) {
                    String str1 = dateFormat.format(CHECK_IN2);
                    String str2 = dateFormat.format(b1.check_out_date);

                    for (int i = 0; i < a1.size(); i++) {
                        rs = smt.executeQuery("SELECT * from ROOM where HID= ' " + b1.hid + " ' AND RID = '" + a1.get(i) + "'; ");
                        rs.next();
                        String s1 = rs.getString("BOOKINGS");
                        JSONObject object = new JSONObject(s1);
                        String s;
                        try {
                            String find_value = object.getString(str1);
                            str1 = "$." + str1;
                            s = "" + Integer.parseInt(find_value) + Integer.parseInt(b1.rooms.getString(a1.get(i)));
                        } catch (Exception e) {
                            str1 = "$." + str1;
                            s = b1.rooms.getString(a1.get(i));
                        }
                        int r = smt.executeUpdate("UPDATE ROOM SET BOOKINGS = JSON_SET(BOOKINGS, '" + str1 + "' , '" + s + "'  where HID= ' " + b1.hid + " ' AND RID = '" + a1.get(i) + "'; ");


                        // if (Integer.parseInt(str1) + a1.get(i).number > rs.getInt("TOTALROOMS")) {
                        // status = 1;

                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(CHECK_IN2);
                    c.add(Calendar.DATE, 1);
                    CHECK_IN2 = c.getTime();

                }
                String str1 = dateFormat.format(b1.check_in_date);
                String str2 = dateFormat.format(b1.check_out_date);
                int row = smt.executeUpdate("INSERT INTO BOOKINGS (REF, UID, HID, ADULTS, CHILD, ROOMS, CHECK_IN, CHECK_OUT, COST, TIMESTAMP, STATUS) VALUES ('" + b1.ref + "','" + b1.uid + "','" + b1.hid + "','" +b1.adults + "','" + b1.child + "', '" + str1 + "', '" + str2 + "' , " + b1.cost + ", '" + timestamp2 + "', 'confirmed');");

            }
        }
        catch(Exception E)
        {

        }




    }
    HotelObject display_hotel(String hid)
    {
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            smt=con.createStatement();
            ResultSet rs;
            rs = smt.executeQuery("SELECT * FROM mydb.HOTEL where HID = '"+hid+"'; ");
            rs.next();
            HotelObject h = new HotelObject();
            h.hid = hid;
            h.name = rs.getString("NAME");
            h.city = rs.getString("CITY");
            h.description = rs.getString("DESCRIPTION");
            h.amenities  = rs.getString("AMENITIES");
            h.address = rs.getString("ADDRESS");
            h.check_in_time = rs.getString("CHECK_IN_TIME");
            h.check_out_time = rs.getString("CHECK_OUT_TIME");
            h.totalrooms = rs.getInt("TOTALROOMS");
            h.star_category = rs.getInt("HOTEL_STAR");
            h.rooms = rs.getString("ROOM").split(",");
            String s = rs.getString("REVIEWS");
            JSONObject obj = new JSONObject(s);
            h.reviews = new ArrayList<>();
            while (obj.keys().hasNext())
            {
                String x = obj.keys().next().toString();
                JSONObject obj2 = new JSONObject(x);
                Review r = new Review();
                r.booking_id = x;
                r.username = obj2.getString("username");
                r.rating=obj.getInt("rating");
                r.comment = obj.getString("comment");
                h.reviews.add(r);

            }
            return h;



        }
        catch(Exception e)
        {
            return null;
        }
    }
    ArrayList<RoomObject> display_rooms(String hid)
    {
        ArrayList<RoomObject> a1 = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            smt = con.createStatement();
            ResultSet rs;
            rs = smt.executeQuery("SELECT * FROM mydb.HOTEL where HID = '" + hid + "'; ");
            rs.next();
            String[] rooms = rs.getString("ROOMS").split(",");
            for (String x : rooms) {
                ResultSet r = smt.executeQuery("SELECT * FROM mydb.ROOM WHERE RID = '" + x + "' ; ");

                String title = rs.getString("TITLE");
                String rid = rs.getString("RID");
                String description = rs.getString("DESCRIPTION");
                String amenities = rs.getString("AMENITIES");
                Double price = rs.getDouble("PRICE");
                Double extra = rs.getDouble("EXTRA_PERSON_CHARGES");
                int size = rs.getInt("SIZE");
                int total = rs.getInt("TOTAL");
                String book = rs.getString("BOOKINGS");
                JSONObject bookings = new JSONObject(book);
                String wait = rs.getString("WAITLIST");
                JSONObject waitlist = new JSONObject(wait);
                RoomObject room = new RoomObject(rid, title, hid, description, amenities, price, extra, size, total, bookings, waitlist);
                a1.add(room);


            }
            return a1;
        }
        catch(Exception e)
        {
            return null;
        }



    }

    static void feely(int i)
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            System.out.println("connection established");
            smt = con.createStatement();
            ResultSet rs;
            rs = smt.executeQuery("SELECT * FROM mydb.check;");
            System.out.println("query executed");
            rs.next();
            String object = rs.getString("JSONTYPE");
            JSONObject obj = new JSONObject(object);
            String na = obj.getString("name");
            System.out.println(na);
           // if (!rs.next())
              //  return 1;
            //else
              //  return 0;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }





}

