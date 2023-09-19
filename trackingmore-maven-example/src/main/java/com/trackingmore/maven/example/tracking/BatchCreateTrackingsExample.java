package com.trackingmore.maven.example.tracking;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.BatchItem;
import com.trackingmore.model.tracking.BatchResults;
import com.trackingmore.model.tracking.CreateTrackingParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BatchCreateTrackingsExample {

    public static void main(String[] args) {
        try {
            String apiKey = "you api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            List<CreateTrackingParams> paramsList = new ArrayList<>();

            CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
            createTrackingParams1.setTrackingNumber("92632903279511573030094832");
            createTrackingParams1.setCourierCode("usps");

            CreateTrackingParams createTrackingParams2 = new CreateTrackingParams();
            createTrackingParams2.setTrackingNumber("92642903289511563039994932");
            createTrackingParams2.setCourierCode("usps");

            paramsList.add(createTrackingParams1);
            paramsList.add(createTrackingParams2);

            TrackingMoreResponse result = trackingMore.trackings.BatchCreateTrackings(paramsList);
            System.out.println(result.getMeta().getCode());

            if(result.getData() != null){
                BatchResults batchResults = (BatchResults) result.getData();
                System.out.println(batchResults);
                for (BatchItem batchItem : batchResults.getSuccess()) {
                    String trackingNumber = batchItem.getTrackingNumber();
                    String courierCode = batchItem.getCourierCode();
                    System.out.println("Tracking Number: " + trackingNumber);
                    System.out.println("Courier Code: " + courierCode);
                }
                for (BatchItem batchItem : batchResults.getError()) {
                    String trackingNumber = batchItem.getTrackingNumber();
                    String courierCode = batchItem.getCourierCode();
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
