package com.trackingmore.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trackingmore.exception.ErrorEnums;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.airWaybill.AirWaybill;
import com.trackingmore.model.airWaybill.AirWaybillParams;
import com.trackingmore.service.AirWaybills;
import com.trackingmore.utils.StrUtils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AirWaybillImpl extends BaseTracking implements AirWaybills {

    public TrackingMoreResponse CreateAnAirWayBill(AirWaybillParams airWaybillParams) throws TrackingMoreException,IOException{
        if(StrUtils.isEmpty(airWaybillParams.getAwbNumber())) {
            throw new TrackingMoreException(ErrorEnums.ErrMissingAwbNumber);
        }

        Pattern pattern = Pattern.compile("^\\d{3}[ -]?(\\d{8})$");
        Matcher matcher = pattern.matcher(airWaybillParams.getAwbNumber());
        if(!matcher.matches()) {
            throw new TrackingMoreException(ErrorEnums.ErrInvalidAirWaybillFormat);
        }

        String apiPath =  "/awb";
        String body = requestHelper.sendApiRequest(apiPath, "POST", null,  airWaybillParams);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<AirWaybill>>() {});
        return response;
    }

}
