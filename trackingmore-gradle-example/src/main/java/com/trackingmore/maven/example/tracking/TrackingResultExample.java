package com.trackingmore.maven.example.tracking;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.GetTrackingResultsParams;
import com.trackingmore.model.tracking.Tracking;

import java.io.IOException;
import java.util.List;

public class TrackingResultExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            GetTrackingResultsParams trackingParams = new GetTrackingResultsParams();
            trackingParams.setTrackingNumbers("92612903029511573030094537,92612903029511573030094531");
            trackingParams.setCourierCode("usps");
            trackingParams.setCreatedDateMin("2023-08-23T06:00:00+00:00");
            trackingParams.setCreatedDateMax("2023-09-18T06:00:00+00:00");
            TrackingMoreResponse result = trackingMore.trackings.GetTrackingResults(trackingParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null ){
                @SuppressWarnings("unchecked")
                List<Tracking> trackings = (List<Tracking>) result.getData();
                for (Tracking tracking : trackings) {
                    String trackingNumber = tracking.getTrackingNumber();
                    String courierCode = tracking.getCourierCode();

                    System.out.println("Tracking Number: " + trackingNumber);
                    System.out.println("Courier Code: " + courierCode);
                }
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
