package com.trackingmore.service.impl;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;
import com.trackingmore.model.courier.DetectParams;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CourierImplTest {
    private TrackingMore trackingMore;

    @Before
    public void setUp() throws TrackingMoreException {
        String apiKey = "apiKey";
        trackingMore = new TrackingMore(apiKey);
    }

    @Test
    public void testGetAllCouriers() throws Exception {
        TrackingMoreResponse response = trackingMore.couriers.getAllCouriers();
        assertNotNull(response);
        if(response.getMeta().getCode() == 200){
            List<Courier> couriers = (List<Courier>) response.getData();
            for (Courier courier : couriers) {
                assertNotNull(courier);
            }
        }
    }

    @Test
    public void testDetect() throws Exception {
        DetectParams detectParams = new DetectParams();
        detectParams.setTrackingNumber("92612903029511573030094531");

        TrackingMoreResponse response = trackingMore.couriers.detect(detectParams);
        assertNotNull(response);

        if(response.getMeta().getCode() == 200){
            List<Courier> courierList = (List<Courier>) response.getData();
            assertNotNull(courierList);

            for (Courier courier : courierList) {
                assertNotNull(courier);
            }
        }

    }

    @Test(expected = TrackingMoreException.class)
    public void testDetectWithEmptyTrackingNumber() throws Exception {
        DetectParams detectParams = new DetectParams();
        trackingMore.couriers.detect(detectParams);
    }

}
