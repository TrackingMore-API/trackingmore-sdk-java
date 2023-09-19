package com.trackingmore.service;

import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.DetectParams;

import java.io.IOException;

public interface Couriers {

    TrackingMoreResponse getAllCouriers() throws IOException;

    TrackingMoreResponse detect(DetectParams detectParams) throws TrackingMoreException,IOException;

}
