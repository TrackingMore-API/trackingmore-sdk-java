package com.trackingmore.maven.example.tracking;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.UpdateTracking;
import com.trackingmore.model.tracking.UpdateTrackingParams;

import java.io.IOException;

public class UpdateTrackingByIDExample {

    public static void main(String[] args) {
        try {
            String apiKey = "your api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            String idString = "9a035f5cdd0437c55d48e223c705a66c";
            UpdateTrackingParams updateTrackingParams = new UpdateTrackingParams();
            updateTrackingParams.setCustomerName("New name");
            updateTrackingParams.setNote("New tests order note");
            TrackingMoreResponse result = trackingMore.trackings.UpdateTrackingByID(idString, updateTrackingParams);
            System.out.println(result.getMeta().getCode());
            System.out.println(result.getData());
            if(result.getData() != null){
                UpdateTracking  updateTracking= (UpdateTracking) result.getData();
                System.out.println(updateTracking);
                System.out.println(updateTracking.getTrackingNumber());
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
