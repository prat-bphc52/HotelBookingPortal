package bits.oops.project;

import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

public class Bookings {

    String ref;
    String uid;
    String hid;
    JSONObject adults = new JSONObject();
    JSONObject child = new JSONObject();
    JSONObject rooms = new JSONObject();
    Date check_in_date;
    Date check_out_date;
    int cost;
    long timestamp;
    String status;
    int rating;
    String review;
    JSONObject waitlist = new JSONObject();


}
