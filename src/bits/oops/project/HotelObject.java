package bits.oops.project;

import java.util.ArrayList;

public class HotelObject {
    String hid,name,city,description,amenities,address,check_in_time,check_out_time;
    String[] rooms;
    int totalrooms,star_category;
    ArrayList<Review> reviews;
    double getRating(){
        if(reviews==null || reviews.size()==0){
            return -1;
        }
        else {
            int ratingsum=0;
            for (Review r : reviews)
                ratingsum += r.rating;
            double rating = (Math.round(ratingsum * 1.0 / reviews.size() * 10)) / 10.0;
            return rating;
        }
    }
    int get5ratings(){
        if(reviews==null || reviews.size()==0)
            return 0;
        else{
            int count=0;
            for(Review r:reviews){
                if(r.rating==5)
                    count++;
            }
            return count*100/reviews.size();
        }
    }
    int get4ratings(){
        if(reviews==null || reviews.size()==0)
            return 0;
        else{
            int count=0;
            for(Review r:reviews){
                if(r.rating==4)
                    count++;
            }
            return count*100/reviews.size();
        }
    }
    int get3ratings(){
        if(reviews==null || reviews.size()==0)
            return 0;
        else{
            int count=0;
            for(Review r:reviews){
                if(r.rating==3)
                    count++;
            }
            return count*100/reviews.size();
        }
    }
    int get2ratings(){
        if(reviews==null || reviews.size()==0)
            return 0;
        else{
            int count=0;
            for(Review r:reviews){
                if(r.rating==2)
                    count++;
            }
            return count*100/reviews.size();
        }
    }
    int get1ratings(){
        if(reviews==null || reviews.size()==0)
            return 0;
        else{
            int count=0;
            for(Review r:reviews){
                if(r.rating==1)
                    count++;
            }
            return count*100/reviews.size();
        }
    }

}
