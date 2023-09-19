package com.trackingmore.maven.example.tracking;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.Tracking;

import java.io.IOException;

public class RetrackTrackingByIDExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            String idString = "9a035f5cdd0437c55d48e223c705a66c";
            TrackingMoreResponse result = trackingMore.trackings.RetrackTrackingByID(idString);
            System.out.println(result);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                Tracking  tracking= (Tracking) result.getData();
                System.out.println(tracking);
                System.out.println(tracking.getTrackingNumber());
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
