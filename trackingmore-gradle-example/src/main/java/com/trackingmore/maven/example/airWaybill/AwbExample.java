package com.trackingmore.maven.example.airWaybill;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.airWaybill.AirWaybill;
import com.trackingmore.model.airWaybill.AirWaybillParams;

import java.io.IOException;

public class AwbExample {

    public static void main(String[] args) {
        try {
            String apiKey = "your api key";
            TrackingMore trackingMore = new TrackingMore(apiKey);
            AirWaybillParams airWaybillParams = new AirWaybillParams();
            airWaybillParams.setAwbNumber("235-69030430");
            TrackingMoreResponse result = trackingMore.airWaybills.CreateAnAirWayBill(airWaybillParams);
            System.out.println(result.getMeta().getCode());
            if(result.getData() != null){
                AirWaybill airWaybills = (AirWaybill) result.getData();
                System.out.println(airWaybills);
                System.out.println(airWaybills.getAwbNumber());
                System.out.println(airWaybills.getAirlineInfo().getName());
                System.out.println(airWaybills.getFlightInfo().get("TK0721").getDepartStation());
            }

        } catch (TrackingMoreException e) {
            System.err.println("error：" + e.getMessage());
        } catch (IOException e) {
            System.err.println("error：" + e.getMessage());
        }
    }

}
