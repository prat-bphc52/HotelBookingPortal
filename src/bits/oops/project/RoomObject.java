package bits.oops.project;

import com.google.gson.JsonObject;

public class RoomObject {
    private String rid,title,hid,description,amenities;
    private double price,extra;
    private int size, total;
    private JsonObject bookings,waitlist;
    public RoomObject(){

    }
    public RoomObject(String rid,String title, String hid, String description, String amenities,double price, double extra, int size,int total, JsonObject bookings, JsonObject waitlist) {
        this.rid=rid;
        this.title=title;
        this.hid=hid;
        this.description=description;
        this.amenities=amenities;
        this.price=price;
        this.extra=extra;
        this.size=size;
        this.total=total;
        this.bookings=bookings;
        this.waitlist=waitlist;
    }
    public String getDescription() {
        return description;
    }

    public String getHid() {
        return hid;
    }

    public String getAmenities() {
        return amenities;
    }

    public String getRid() {
        return rid;
    }

    public double getExtra() {
        return extra;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public int getTotal() {
        return total;
    }

    public JsonObject getBookings() {
        return bookings;
    }

    public JsonObject getWaitlist() {
        return waitlist;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookings(JsonObject bookings) {
        this.bookings = bookings;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setWaitlist(JsonObject waitlist) {
        this.waitlist = waitlist;
    }
}
