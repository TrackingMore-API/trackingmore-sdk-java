package com.trackingmore.service.impl;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.airWaybill.AirWaybill;
import com.trackingmore.model.airWaybill.AirWaybillParams;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

public class AirWaybillImplTest {

    private TrackingMore trackingMore;

    @Before
    public void setUp() throws TrackingMoreException {
        String apiKey = "apiKey";
        trackingMore = new TrackingMore(apiKey);
    }

    @Test
    public void testCreateAnAirWayBillSuccess() throws IOException, TrackingMoreException {
        AirWaybillParams airWaybillParams = new AirWaybillParams();
        airWaybillParams.setAwbNumber("235-69030430");  // 符合要求的 awbNumber

        TrackingMoreResponse response = trackingMore.airWaybills.CreateAnAirWayBill(airWaybillParams);

        System.out.println(response);
        assertNotNull(response);
        if(response.getMeta().getCode() == 200){
            AirWaybill airWaybillData = (AirWaybill) response.getData();
            assertNotNull(airWaybillData);
        }

    }

    @Test(expected = TrackingMoreException.class)
    public void testCreateAnAirWayBillMissingAwbNumber() throws IOException, TrackingMoreException {
        AirWaybillParams airWaybillParams = new AirWaybillParams();
        trackingMore.airWaybills.CreateAnAirWayBill(airWaybillParams);
    }

    @Test(expected = TrackingMoreException.class)
    public void testCreateAnAirWayBillInvalidAwbNumberFormat() throws IOException, TrackingMoreException {
        AirWaybillParams airWaybillParams = new AirWaybillParams();
        airWaybillParams.setAwbNumber("123456");
        trackingMore.airWaybills.CreateAnAirWayBill(airWaybillParams);
    }
}
