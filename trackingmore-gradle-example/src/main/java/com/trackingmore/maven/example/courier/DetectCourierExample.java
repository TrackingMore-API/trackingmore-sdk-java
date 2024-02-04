package com.trackingmore.maven.example.courier;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;
import com.trackingmore.model.courier.DetectParams;

import java.io.IOException;
import java.util.List;

public class DetectCourierExample {

    public static void main(String[] args) {
        try {
            String apiKey = "your api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            DetectParams detectParams = new DetectParams();
            detectParams.setTrackingNumber("92642903289511563030094932");
            TrackingMoreResponse result = trackingMore.couriers.detect(detectParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                @SuppressWarnings("unchecked")
                List<Courier> couriers = (List<Courier>) result.getData();
                for (Courier courier : couriers) {
                    String courierName = courier.getCourierName();
                    String courierCode = courier.getCourierCode();
                    System.out.println(courierName+"---"+courierCode);
                }
            }
        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
