package com.trackingmore.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trackingmore.exception.ErrorEnums;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;
import com.trackingmore.model.courier.DetectParams;
import com.trackingmore.service.Couriers;
import com.trackingmore.utils.StrUtils;

import java.io.IOException;
import java.util.List;

public class CourierImpl extends BaseTracking implements Couriers {
    public TrackingMoreResponse getAllCouriers() throws IOException{
        String apiPath =  "/couriers/all";
        String body = requestHelper.sendApiRequest(apiPath, "GET",null, null);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<List<Courier>>>() {});
        return response;
    }

    public TrackingMoreResponse detect(DetectParams detectParams) throws TrackingMoreException,IOException {
        if(StrUtils.isEmpty(detectParams.getTrackingNumber())) {
            throw new TrackingMoreException(ErrorEnums.ErrMissingTrackingNumber);
        }
        String apiPath =  "/couriers/detect";
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, detectParams);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<List<Courier>>>() {});
        return response;
    }

}
