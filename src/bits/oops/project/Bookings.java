package bits.oops.project;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.Date;

public class Bookings {

    String ref;
    String uid;
    String hid;
    JSONArray adults = new JSONArray();
    JSONArray child = new JSONArray();
    JSONObject rooms = new JSONObject();
    Date check_in_date;
    Date check_out_date;
    int cost;
    long timestamp;
    int status,rating,adult_count,child_count;
    String review;
    JSONObject waitlist = new JSONObject();


}
