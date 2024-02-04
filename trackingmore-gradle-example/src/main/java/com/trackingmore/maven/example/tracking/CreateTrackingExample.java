package com.trackingmore.maven.example.tracking;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.CreateTrackingParams;
import com.trackingmore.model.tracking.Tracking;

import java.io.IOException;

public class CreateTrackingExample {

    public static void main(String[] args) {
        try {
            String apiKey = "your api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            CreateTrackingParams createTrackingParams = new CreateTrackingParams();
            createTrackingParams.setTrackingNumber("92612903029511573030094537");
            createTrackingParams.setCourierCode("usps");
            TrackingMoreResponse result = trackingMore.trackings.CreateTracking(createTrackingParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
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
