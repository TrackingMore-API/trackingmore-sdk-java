package com.trackingmore.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trackingmore.exception.ErrorEnums;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.*;
import com.trackingmore.service.Trackings;
import com.trackingmore.utils.StrUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TrackingImpl extends BaseTracking implements Trackings {

    public TrackingMoreResponse CreateTracking(CreateTrackingParams createTrackingParams) throws TrackingMoreException,IOException{
        if(StrUtils.isEmpty(createTrackingParams.getTrackingNumber())) {
            throw new TrackingMoreException(ErrorEnums.ErrMissingTrackingNumber);
        }
        if(StrUtils.isEmpty(createTrackingParams.getCourierCode())) {
            throw new TrackingMoreException(ErrorEnums.ErrMissingCourierCode);
        }
        String apiPath =  "/trackings/create";
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, createTrackingParams);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<Tracking>>() {});
        return response;
    }

    public TrackingMoreResponse GetTrackingResults(GetTrackingResultsParams trackingResultsParams) throws IOException{
        String apiPath =  "/trackings/get";
        String body = requestHelper.sendApiRequest(apiPath, "GET", trackingResultsParams,null);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<List<Tracking>>>() {});
        return response;
    }

    public TrackingMoreResponse BatchCreateTrackings(List<CreateTrackingParams> paramsList) throws TrackingMoreException,IOException{
        if(paramsList.size() > 40){
            throw new TrackingMoreException(ErrorEnums.ErrMaxTrackingNumbersExceeded);
        }

        for (CreateTrackingParams params : paramsList) {
            if(StrUtils.isEmpty(params.getTrackingNumber())){
                throw new TrackingMoreException(ErrorEnums.ErrMissingTrackingNumber);
            }
            if(StrUtils.isEmpty(params.getCourierCode())){
                throw new TrackingMoreException(ErrorEnums.ErrMissingCourierCode);
            }
        }

        String apiPath =  "/trackings/batch";
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, paramsList);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<BatchResults>>() {});
        return response;
    }

    public TrackingMoreResponse UpdateTrackingByID(String idSting,UpdateTrackingParams updateTrackingParams) throws TrackingMoreException,IOException{
        if(StrUtils.isEmpty(idSting)){
            throw new TrackingMoreException(ErrorEnums.ErrEmptyId);
        }
        String apiPath =  "/trackings/update/"+idSting;
        String body = requestHelper.sendApiRequest(apiPath, "PUT",null, updateTrackingParams);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<UpdateTracking>>() {});
        return response;
    }

    public TrackingMoreResponse DeleteTrackingByID(String idSting) throws TrackingMoreException,IOException{
        if(StrUtils.isEmpty(idSting)){
            throw new TrackingMoreException(ErrorEnums.ErrEmptyId);
        }
        String apiPath =  "/trackings/delete/"+idSting;
        String body = requestHelper.sendApiRequest(apiPath, "DELETE",null, null);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<Tracking>>() {});
        return response;
    }

    public TrackingMoreResponse RetrackTrackingByID(String idSting) throws TrackingMoreException,IOException{
        if(StrUtils.isEmpty(idSting)){
            throw new TrackingMoreException(ErrorEnums.ErrEmptyId);
        }
        String apiPath =  "/trackings/retrack/"+idSting;
        String body = requestHelper.sendApiRequest(apiPath, "POST",null, null);
        TrackingMoreResponse response = objectMapper.readValue(body, new TypeReference<TrackingMoreResponse<Tracking>>() {});
        return response;
    }


}
