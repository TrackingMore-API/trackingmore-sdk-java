package com.trackingmore.service;

import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.CreateTrackingParams;
import com.trackingmore.model.tracking.GetTrackingResultsParams;
import com.trackingmore.model.tracking.UpdateTrackingParams;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Trackings {

    TrackingMoreResponse CreateTracking(CreateTrackingParams createTrackingParams) throws TrackingMoreException,IOException;

    TrackingMoreResponse GetTrackingResults(GetTrackingResultsParams trackingResultsParams) throws IOException;

    TrackingMoreResponse BatchCreateTrackings(List<CreateTrackingParams> paramsList) throws TrackingMoreException,IOException;

    TrackingMoreResponse UpdateTrackingByID(String idSting, UpdateTrackingParams updateTrackingParams) throws TrackingMoreException,IOException;

    TrackingMoreResponse DeleteTrackingByID(String idSting) throws TrackingMoreException,IOException;

    TrackingMoreResponse RetrackTrackingByID(String idSting) throws TrackingMoreException,IOException;

}
