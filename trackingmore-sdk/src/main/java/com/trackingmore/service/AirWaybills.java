package com.trackingmore.service;

import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.airWaybill.AirWaybillParams;

import java.io.IOException;

public interface AirWaybills {

    TrackingMoreResponse CreateAnAirWayBill(AirWaybillParams airWaybillParams) throws TrackingMoreException,IOException;

}
