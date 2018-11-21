package bits.oops.project;

import org.json.JSONArray;
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

        System.out.print("pwd printed +" + pwd + "   " +user);
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "draco");
            smt = con.createStatement();
            ResultSet rs;
            if (user != "") {

                rs = smt.executeQuery("Select * from USER Where UID = '"+user+"' AND PASSWORD = '"+pwd+"';");
                if (rs.next()) {
                    System.out.print("reached here");
                    User u = new User();
                    u.Name = rs.getString("NAME");
                    u.Username=rs.getString("UID");
                    u.Emailid=rs.getString("EMAIL");
                    u.password=rs.getString("PASSWORD");
                    u.Contact=rs.getString("PHONE");
                    u.Address=rs.getString("ADDRESS");
                    return u;
                }
                else return null;
            }
            else
                return null;
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
            return null;
        }

    }

     int register(String user, String name, String email, String phone, String address, String password) {
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
     ArrayList<Hotel_tab> gethotels(String location, Date check_in, Date check_out)
    {
        //location = "+" + location + "+";
        System.out.println("location sent " + location);

        ArrayList<Hotel_tab> a1 = new ArrayList<>();
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/mydb" , "root" , "draco");
            smt=con.createStatement();
            ResultSet rs;
            rs=smt.executeQuery("SELECT * from HOTEL where CITY= '"+location+"'; ");
            while(rs.next())
            {
                System.out.print("reached here");
                Hotel_tab h1 = new Hotel_tab();
                int hid = rs.getInt("HID");
                String name = rs.getString("NAME");
                String loc = rs.getString("ADDRESS");
                String amenities= rs.getString("AMENITIES");
                String description=rs.getString("DESCRIPTION");
                String check_in_time = rs.getString("CHECK_IN_TIME");
                String check_out_time=rs.getString("CHECK_OUT_TIME");
                float cost=rs.getFloat("COST");
                int star = rs.getInt("HOTEL_STAR");
                String image = rs.getString("IMAGE");
                h1.Location.setText(loc);
                h1.amenities.setText(amenities);
               // int nights = (int) Math.abs((check_in.getTime()-check_out.getTime())/86400000);
                h1.cost.setText("Rs " + cost);
                h1.hotel_id.setText("" + hid);
                //h1.image.setIcon(new ImageIcon(getClass().getResource(image))) ;
                h1.name.setText(name);
                h1.nights.setText(" Starting at");
                h1.stars.setText(""+star);
                a1.add(h1);

            }
        }
        catch(Exception e)
        {
                System.out.print(e);
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
                b1.status = 0;
                b1.waitlist = O;
                String str1 = dateFormat.format(b1.check_in_date);
                String str2 = dateFormat.format(b1.check_out_date);
                int row = smt.executeUpdate("INSERT INTO BOOKINGS (REF, UID, HID, ADULTS, CHILD, ROOMS, CHECK_IN, CHECK_OUT, COST, TIMESTAMP, STATUS, WAITLIST) VALUES ('" + b1.ref + "','" + b1.uid + "','" + b1.hid + "','" + b1.adults + "','" + b1.child + "', '" + b1.rooms + "','" + str1 + "', '" + str2 + "' ,'" + b1.cost + "', '" + timestamp2 + "' , "+0+", '" + b1.waitlist + "');");

            } else {

                b1.status =1;
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
                int row = smt.executeUpdate("INSERT INTO BOOKINGS (REF, UID, HID, ADULTS, CHILD, ROOMS, CHECK_IN, CHECK_OUT, COST, TIMESTAMP, STATUS) VALUES ('" + b1.ref + "','" + b1.uid + "','" + b1.hid + "','" +b1.adults + "','" + b1.child + "', '" + str1 + "', '" + str2 + "' , " + b1.cost + ", '" + timestamp2 + "', "+1+");");

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
            try {
                h.description = rs.getString("DESCRIPTION");
            }
            catch(Exception e)
            {
                h.description = null;
            }
            h.amenities  = rs.getString("AMENITIES");
            h.address = rs.getString("ADDRESS");
            h.check_in_time = rs.getString("CHECK_IN_TIME");
            h.check_out_time = rs.getString("CHECK_OUT_TIME");
            h.totalrooms = rs.getInt("TOTALROOMS");
            h.star_category = rs.getInt("HOTEL_STAR");
            h.rooms = rs.getString("ROOMS").split("/");
            try {
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
            }
            catch(Exception e)
            {
                h.reviews = null;
            }

            return h;



        }
        catch(Exception e)
        {
            System.out.print("exception is" + e);
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
            String[] rooms = rs.getString("ROOMS").split("/");
            System.out.print(rooms);
            for (String x : rooms) {
                ResultSet r = smt.executeQuery("SELECT * FROM mydb.ROOM WHERE RID = '" + x + "' ; ");
                r.next();
                System.out.print(r.toString());
                String title = r.getString("TITLE");
                String rid = r.getString("RID");
                String description = r.getString("DESCRIPTION");
                String amenities = r.getString("AMENITIES");
                Double price = r.getDouble("PRICE");
                Double extra = r.getDouble("EXTRA_PERSON_CHARGES");
                int size = r.getInt("SIZE");
                int total = r.getInt("TOTAL");
                JSONObject bookings;
                try {
                    String book = r.getString("BOOKINGS");
                    bookings = new JSONObject(book);
                }
                catch(Exception e)
                {
                    bookings=null;
                }
                JSONObject waitlist;
                try {
                    String wait = r.getString("WAITLIST");
                    waitlist = new JSONObject(wait);
                }
                catch(Exception e)
                {
                    waitlist=null;
                }
                RoomObject room = new RoomObject(rid, title, hid, description, amenities, price, extra, size, total, bookings, waitlist);
                a1.add(room);
            }
            return a1;
        }
        catch(Exception e)
        {
            System.out.print("error is display_rooms" + e);
            return null;
        }



    }
   void cancel(String ref)
    {
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            smt=con.createStatement();
            ResultSet rs;
            rs= smt.executeQuery("SELECT * FROM mydb.BOOKINGS WHERE REF = '"+ref+"' ; ");
            rs.next();
            if(rs.getInt("STATUS")==1)
            {
                String check_in_date = rs.getString("CHECK_IN_DATE");
                String check_out_date = rs.getString("CHECK_OUT_DATE");
                DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date check_in = format.parse(check_in_date);
                Date check_out = format.parse(check_out_date);
                while(check_in.compareTo(check_out) < 0) {
                    String str = rs.getString("ROOMS");
                    JSONObject obj = new JSONObject(str);
                    while (obj.keys().hasNext()) {
                        String rid = obj.keys().next().toString();
                        int i = Integer.parseInt(obj.getString(rid));
                        ResultSet result = smt.executeQuery("SELECT * FROM ROOM WHERE RID = '" + rid + "' ;");
                        String str1 = result.getString("BOOKINGS");
                        JSONObject obj2 = new JSONObject("str1");
                        String number = obj2.getString("check_in");
                        String topass0 = "" + (Integer.parseInt(number) - i) ;
                        String topass = "$." + check_in;
                        smt.executeUpdate("UPDATE mydb.ROOM SET BOOKINGS = JSON_SET(BOOKINGS, '"+topass+"', '"+topass0+"') WHERE RID= '"+rid+"' ; ");
                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(check_in);
                    c.add(Calendar.DATE, 1);
                    check_in = c.getTime();
                }
            }
            else if(rs.getInt("STATUS")==0) {
                String check_in_date = rs.getString("CHECK_IN_DATE");
                String check_out_date = rs.getString("CHECK_OUT_DATE");
                DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
                Date check_in = format.parse(check_in_date);
                Date check_out = format.parse(check_out_date);
                while(check_in.compareTo(check_out) < 0) {
                    String str = rs.getString("ROOMS");
                    JSONObject obj = new JSONObject(str);
                    while (obj.keys().hasNext()) {
                        String rid = obj.keys().next().toString();
                        int i = Integer.parseInt(obj.getString(rid));
                        ResultSet result = smt.executeQuery("SELECT * FROM ROOM WHERE RID = '" + rid + "' ;");
                        String str1 = result.getString("WAITLIST");
                        JSONObject obj2 = new JSONObject("str1");
                        String number = obj2.getString("check_in");
                        String topass0 = "" + (Integer.parseInt(number) - i) ;
                        String topass = "$." + check_in;
                        smt.executeUpdate("UPDATE mydb.ROOM SET WAITLIST = JSON_SET(WAITLIST, '"+topass+"', '"+topass0+"') WHERE RID= '"+rid+"' ; ");
                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(check_in);
                    c.add(Calendar.DATE, 1);
                    check_in = c.getTime();
                }

            }
        }
        catch(Exception e)
        {

        }
    }
    int modify_booking(String ref, Date check_in_new , Date check_out_new)
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM mydb.BOOKINGS WHERE REF = '" + ref + "';");
            String check_in_string = rs.getString("CHECK_IN_DATE");
            String check_out_string = rs.getString("CHECK_OUT_DATE");
            String st1 = rs.getString("ROOMS");
            JSONObject object = new JSONObject(st1);

            DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
            Date check_in_date = format.parse(check_in_string);
            Date check_out_date = format.parse(check_out_string);
            String hid = rs.getString("HID");

            Date CHECKIN2 = check_in_new;
            Date CHECKIN3 = check_out_date;
            ArrayList<String> a1 = new ArrayList<>();
            while (object.keys().hasNext()) {
                String x = object.keys().next().toString();
                a1.add(x);
            }


            int status=0;
            while (check_in_new.compareTo(check_in_date) < 0) {
                String str1 = format.format(check_in_new);
                String str2 = format.format(check_in_date);


                for (int i = 0; i < a1.size(); i++) {
                    rs = smt.executeQuery("SELECT * from ROOM where HID= ' " + hid + " ' AND RID = '" + a1.get(i) + "'; ");
                    rs.next();
                    String s = rs.getString("BOOKINGS");
                    JSONObject obj = new JSONObject(s);
                    try {
                        String find_date = obj.getString(str1);
                        if (Integer.parseInt(find_date) + Integer.parseInt(object.getString(a1.get(i))) > rs.getInt("TOTALROOMS")) {
                            status = 1;
                        }
                    } catch (Exception e) {


                    }
                }
                Calendar c = Calendar.getInstance();
                c.setTime(check_in_new);
                c.add(Calendar.DATE, 1);
                check_in_new = c.getTime();

            }
            while (check_out_date.compareTo(check_out_new) < 0) {
                String str1 = format.format(check_out_date);
                String str2 = format.format(check_in_date);


                for (int i = 0; i < a1.size(); i++) {
                    rs = smt.executeQuery("SELECT * from ROOM where HID= ' " + hid + " ' AND RID = '" + a1.get(i) + "'; ");
                    rs.next();
                    String s = rs.getString("BOOKINGS");
                    JSONObject obj = new JSONObject(s);
                    try {
                        String find_date = obj.getString(str1);
                        if (Integer.parseInt(find_date) + Integer.parseInt(object.getString(a1.get(i))) > rs.getInt("TOTALROOMS")) {
                            status = 1;
                        }
                    } catch (Exception e) {


                    }
                }
                Calendar c = Calendar.getInstance();
                c.setTime(check_out_date);
                c.add(Calendar.DATE, 1);
                check_out_date = c.getTime();

            }
            while (CHECKIN2.compareTo(check_in_date) < 0) {
                String str1 = format.format(CHECKIN2);
                String str2 = format.format(check_out_date);

                for (int i = 0; i < a1.size(); i++) {
                    rs = smt.executeQuery("SELECT * from ROOM where HID= ' " +hid + " ' AND RID = '" + a1.get(i) + "'; ");
                    rs.next();
                    String s1 = rs.getString("BOOKINGS");
                    JSONObject obj = new JSONObject(s1);
                    String s;
                    try {
                        String find_value = obj.getString(str1);
                        str1 = "$." + str1;
                        s = "" + Integer.parseInt(find_value) + Integer.parseInt(object.getString(a1.get(i)));
                    } catch (Exception e) {
                        str1 = "$." + str1;
                        s = object.getString(a1.get(i));
                    }
                    int r = smt.executeUpdate("UPDATE ROOM SET BOOKINGS = JSON_SET(BOOKINGS, '" + str1 + "' , '" + s + "'  where HID= ' " + hid + " ' AND RID = '" + a1.get(i) + "'; ");


                    // if (Integer.parseInt(str1) + a1.get(i).number > rs.getInt("TOTALROOMS")) {
                    // status = 1;

                }
                Calendar c = Calendar.getInstance();
                c.setTime(CHECKIN2);
                c.add(Calendar.DATE, 1);
                CHECKIN2 = c.getTime();

            }
            while (CHECKIN3.compareTo(check_out_new) < 0) {
                String str1 = format.format(CHECKIN3);
                String str2 = format.format(check_out_new);

                for (int i = 0; i < a1.size(); i++) {
                    rs = smt.executeQuery("SELECT * from ROOM where HID= ' " + hid + " ' AND RID = '" + a1.get(i) + "'; ");
                    rs.next();
                    String s1 = rs.getString("BOOKINGS");
                    JSONObject obj = new JSONObject(s1);
                    String s;
                    try {
                        String find_value = obj.getString(str1);
                        str1 = "$." + str1;
                        s = "" + Integer.parseInt(find_value) + Integer.parseInt(object.getString(a1.get(i)));
                    } catch (Exception e) {
                        str1 = "$." + str1;
                        s = object.getString(a1.get(i));
                    }
                    int r = smt.executeUpdate("UPDATE ROOM SET BOOKINGS = JSON_SET(BOOKINGS, '" + str1 + "' , '" + s + "'  where HID= ' " + hid + " ' AND RID = '" + a1.get(i) + "'; ");


                    // if (Integer.parseInt(str1) + a1.get(i).number > rs.getInt("TOTALROOMS")) {
                    // status = 1;

                }
                Calendar c = Calendar.getInstance();
                c.setTime(CHECKIN3);
                c.add(Calendar.DATE, 1);
                CHECKIN3 = c.getTime();

            }
            return status;
        }
        catch (Exception e)
        {
            return 1;
        }

        }
    void clear_waitlist(String timestamp, String ref)
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPS", "root", "draco");
            smt = con.createStatement();
            ResultSet rs;
            rs=smt.executeQuery("SELECT * FROM mydb.BOOKINGS where REF = '"+ref+"';");
            String s1= rs.getString("TIMESTAMP");
            ResultSet r2 = smt.executeQuery("Select * FROM mydb.BOOKINGS;");
            int a=0;
            while(r2.next())
            {
                String s2 = r2.getString("TIMESTAMP");
                long timestamp1 = Long.parseLong(s1);
                long timestamp2 = Long.parseLong(s2);
                if(timestamp2 != timestamp1)
                {
                    Bookings b1 = new Bookings();

                    b1.uid=r2.getString("UID");
                    b1.hid=r2.getString("HID");
                    b1.ref=r2.getString("REF");
                    String adults_string=r2.getString("ADULTS");
                    b1.adults = new JSONArray(adults_string);
                    b1.child=new JSONArray(r2.getString("CHILD"));
                    b1.rooms=new JSONObject(r2.getString("ROOMS"));
                    DateFormat d = new SimpleDateFormat("yyyy-mm-dd");
                    b1.check_in_date = d.parse(rs.getString("CHECK_IN_DATE"));
                    b1.check_out_date = d.parse(rs.getString("CHECK_OUT_DATE"));
                    b1.cost=r2.getFloat("COST");
                    b1.timestamp=Long.parseLong(r2.getString("TIMESTAMP"));
                    b1.status = r2.getInt("STATUS");
                    b1.adult_count = r2.getInt("ADULT_COUNT");
                    b1.child_count=r2.getInt("CHILD_COUNT");
                    try {
                        b1.rating = r2.getInt("RATING");
                    }
                    catch(Exception e)
                    {
                        b1.rating = -1;
                    }
                    try {
                        b1.review = r2.getString("REVIEW");
                    }
                    catch(Exception e)
                    {
                        b1.review = null;
                    }
                    if(b1.status == 0)
                        b1.waitlist=new JSONObject(r2.getString("WAITLIST"));
                    else
                        b1.waitlist=null;


                        int i = check(b1);
                        if (i == 1)
                            continue;
                        if (i == 0)
                            book_now_modify(b1);



                    }
                }



            }
            catch(Exception e)
            {

            }


    }
    void book_now_modify(Bookings b1)
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/OOPS", "root", "draco");
            smt = con.createStatement();
            ResultSet rs;
            int status = 0;
            Date CHECK_IN2 = b1.check_in_date;
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
            b1.status =1;
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
            smt.executeUpdate("DELETE FROM BOOKINGS WHERE REF = '"+b1.ref+"';");
            int row = smt.executeUpdate("INSERT INTO BOOKINGS (REF, UID, HID, ADULTS, CHILD, ROOMS, CHECK_IN, CHECK_OUT, COST, TIMESTAMP, STATUS) VALUES ('" + b1.ref + "','" + b1.uid + "','" + b1.hid + "','" +b1.adults + "','" + b1.child + "', '" + str1 + "', '" + str2 + "' , " + b1.cost + ", '" + timestamp2 + "', "+1+");");

        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }

    int check(Bookings b1)
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
            return status;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 3;
        }
    }
    ArrayList<Bookings> getBookings(String uid)
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            smt = con.createStatement();
            ResultSet rs;
            ArrayList<Bookings> a1 = new ArrayList<>();
            rs = smt.executeQuery("SELECT * FROM mydb.BOOKINGS WHERE REF='" + uid + "';");
            while (rs.next())
            {
                Bookings b1 = new Bookings();
                b1.uid=uid;
                b1.hid=rs.getString("HID");
                b1.ref=rs.getString("REF");
                String adults_string=rs.getString("ADULTS");
                b1.adults = new JSONArray(adults_string);
                b1.child=new JSONArray(rs.getString("CHILD"));
                b1.rooms=new JSONObject(rs.getString("ROOMS"));
                DateFormat d = new SimpleDateFormat("yyyy-mm-dd");
                b1.check_in_date = d.parse(rs.getString("CHECK_IN_DATE"));
                b1.check_out_date = d.parse(rs.getString("CHECK_OUT_DATE"));
                b1.cost=rs.getFloat("COST");
                b1.timestamp=Long.parseLong(rs.getString("TIMESTAMP"));
                b1.status = rs.getInt("STATUS");
                b1.adult_count = rs.getInt("ADULT_COUNT");
                b1.child_count=rs.getInt("CHILD_COUNT");
                try {
                    b1.rating = rs.getInt("RATING");
                }
                catch(Exception e)
                {
                    b1.rating = -1;
                }
                try {
                    b1.review = rs.getString("REVIEW");
                }
                catch(Exception e)
                {
                    b1.review = null;
                }
                if(b1.status == 0)
                    b1.waitlist=new JSONObject(rs.getString("WAITLIST"));
                else
                    b1.waitlist=null;

                a1.add(b1);
            }
            return a1;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
    void edit_profile(User u)
    {
        System.out.print("enter edit profile");

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "draco");
            System.out.println("connection established");
            smt = con.createStatement();
            ResultSet rs;
            rs = smt.executeQuery("SELECT * FROM mydb.USER WHERE UID = '"+u.Username+"';");
            if(rs.next())
                System.out.print("match found");
            smt.executeUpdate("UPDATE USER SET NAME = '"+u.Name+"' WHERE UID = '"+u.Username+"';");
            smt.executeUpdate("UPDATE USER SET EMAIL = '"+u.Emailid+"' WHERE UID = '"+u.Username+"';");
            smt.executeUpdate("UPDATE USER SET PHONE = '"+u.Contact+"' WHERE UID = '"+u.Username+"';");
            smt.executeUpdate("UPDATE USER SET ADDRESS = '"+u.Address+"' WHERE UID = '"+u.Username+"';");
            smt.executeUpdate("UPDATE USER SET PASSWORD = '"+u.password+"'WHERE UID = '"+u.Username+"';");

        }
        catch (Exception e)
        {
            System.out.print(e);
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

