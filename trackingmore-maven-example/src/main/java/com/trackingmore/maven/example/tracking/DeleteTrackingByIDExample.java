package com.trackingmore.maven.example.tracking;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.Tracking;

import java.io.IOException;

public class DeleteTrackingByIDExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            String idString = "9a28d8ba030596de70c1b0134cdc8b0d";
            TrackingMoreResponse result = trackingMore.trackings.DeleteTrackingByID(idString);
            System.out.println(result);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null) {
                Tracking trackings = (Tracking) result.getData();
                System.out.println(trackings);
                System.out.println(trackings.getTrackingNumber());
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
