package com.trackingmore;

import com.trackingmore.exception.ErrorEnums;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.service.AirWaybills;
import com.trackingmore.service.Couriers;
import com.trackingmore.service.Trackings;
import com.trackingmore.service.impl.AirWaybillImpl;
import com.trackingmore.service.impl.CourierImpl;
import com.trackingmore.service.impl.TrackingImpl;

public class TrackingMore {

    public static String apiKey;

    public Couriers couriers;

    public AirWaybills airWaybills;

    public Trackings trackings;

    public TrackingMore(String apiKey) throws TrackingMoreException {
         if(apiKey == ""){
             throw new TrackingMoreException(ErrorEnums.ErrEmptyAPIKey);
         }
         this.apiKey = apiKey;
         this.couriers = new CourierImpl();
         this.airWaybills = new AirWaybillImpl();
         this.trackings = new TrackingImpl();
    }
}
