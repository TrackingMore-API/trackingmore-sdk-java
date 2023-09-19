package com.trackingmore.service.impl;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.tracking.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrackingImplTest {

    private TrackingMore trackingMore;

    @Before
    public void setUp() throws TrackingMoreException {
        String apiKey = "apiKey";
        trackingMore = new TrackingMore(apiKey);
    }

    @Test
    public void testCreateTrackingSuccess() throws IOException, TrackingMoreException {
        CreateTrackingParams createTrackingParams = new CreateTrackingParams();
        createTrackingParams.setTrackingNumber("12345678902");
        createTrackingParams.setCourierCode("usps");

        TrackingMoreResponse response = trackingMore.trackings.CreateTracking(createTrackingParams);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            Tracking trackingData = (Tracking) response.getData();
            assertNotNull(trackingData);
        }
    }

    @Test(expected = TrackingMoreException.class)
    public void testCreateTrackingMissingTrackingNumber() throws IOException, TrackingMoreException {
        CreateTrackingParams createTrackingParams = new CreateTrackingParams();
        createTrackingParams.setCourierCode("usps");
        trackingMore.trackings.CreateTracking(createTrackingParams);
    }

    @Test(expected = TrackingMoreException.class)
    public void testCreateTrackingMissingCourierCode() throws IOException, TrackingMoreException {
        CreateTrackingParams createTrackingParams = new CreateTrackingParams();
        createTrackingParams.setTrackingNumber("1234567890");
        trackingMore.trackings.CreateTracking(createTrackingParams);
    }

    @Test
    public void testGetTrackingResults() throws IOException {
        GetTrackingResultsParams trackingResultsParams = new GetTrackingResultsParams();
        TrackingMoreResponse response = trackingMore.trackings.GetTrackingResults(trackingResultsParams);

        assertNotNull(response);
        if(response.getMeta().getCode() == 200){
            List<Tracking> trackingList = (List<Tracking>) response.getData();
            assertNotNull(trackingList);
        }

    }

    @Test
    public void testBatchCreateTrackings() throws IOException, TrackingMoreException {
        List<CreateTrackingParams> paramsList = new ArrayList<>();

        CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
        createTrackingParams1.setTrackingNumber("92632903279511573030094832");
        createTrackingParams1.setCourierCode("usps");

        CreateTrackingParams createTrackingParams2 = new CreateTrackingParams();
        createTrackingParams2.setTrackingNumber("92642903289511563039994932");
        createTrackingParams2.setCourierCode("usps");

        paramsList.add(createTrackingParams1);
        paramsList.add(createTrackingParams2);

        TrackingMoreResponse response = trackingMore.trackings.BatchCreateTrackings(paramsList);

        assertNotNull(response);
        if(response.getMeta().getCode() == 200) {
            BatchResults batchResults = (BatchResults) response.getData();
            assertNotNull(batchResults);
        }

    }

    @Test(expected = TrackingMoreException.class)
    public void testBatchCreateTrackingsWithTooManyParams() throws IOException, TrackingMoreException {
        List<CreateTrackingParams> paramsList = new ArrayList<>();
        for (int i = 0; i < 41; i++) {
            CreateTrackingParams params = new CreateTrackingParams();
            params.setTrackingNumber("92632903279511573030094832");
            params.setCourierCode("usps");
            paramsList.add(params);
        }
        trackingMore.trackings.BatchCreateTrackings(paramsList);
    }

    @Test(expected = TrackingMoreException.class)
    public void testCreateTrackingWithEmptyTrackingNumber() throws IOException, TrackingMoreException {
        List<CreateTrackingParams> paramsList = new ArrayList<>();
        CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
        createTrackingParams1.setTrackingNumber("92632903279511573030094832");
        createTrackingParams1.setCourierCode("");
        paramsList.add(createTrackingParams1);

        trackingMore.trackings.BatchCreateTrackings(paramsList);
    }

    @Test(expected = TrackingMoreException.class)
    public void testCreateTrackingWithEmptyCourierCode() throws IOException, TrackingMoreException {
        List<CreateTrackingParams> paramsList = new ArrayList<>();
        CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
        createTrackingParams1.setTrackingNumber("");
        createTrackingParams1.setCourierCode("usps");
        paramsList.add(createTrackingParams1);
        trackingMore.trackings.BatchCreateTrackings(paramsList);
    }

    @Test(expected = TrackingMoreException.class)
    public void testUpdateTrackingByIDWithEmptyId() throws IOException, TrackingMoreException {
        String idString = "";
        UpdateTrackingParams updateParams = new UpdateTrackingParams();
        trackingMore.trackings.UpdateTrackingByID(idString, updateParams);
    }

    @Test
    public void testUpdateTrackingByIDWithValidData() throws IOException, TrackingMoreException {
        String idString = "9a1d4297af041fc4165206016d108130";
        UpdateTrackingParams updateParams = new UpdateTrackingParams();
        updateParams.setCustomerName("New name");
        updateParams.setNote("New tests order note");

        TrackingMoreResponse response = trackingMore.trackings.UpdateTrackingByID(idString, updateParams);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            UpdateTracking updateTracking = (UpdateTracking) response.getData();
            assertNotNull(updateTracking);
        }
    }

    @Test(expected = TrackingMoreException.class)
    public void testDeleteTrackingByIDWithEmptyId() throws IOException, TrackingMoreException {
        String idString = "";
        trackingMore.trackings.DeleteTrackingByID(idString);
    }

    @Test
    public void testDeleteTrackingByIDWithValidId() throws IOException, TrackingMoreException {
        String idString = "9a1d4297af041fc4165206016d108130";

        TrackingMoreResponse response = trackingMore.trackings.DeleteTrackingByID(idString);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            Tracking tracking = (Tracking) response.getData();
            assertNotNull(tracking);
        }
    }

    @Test(expected = TrackingMoreException.class)
    public void testRetrackTrackingByIDWithEmptyId() throws IOException, TrackingMoreException {
        String idString = "";
        trackingMore.trackings.RetrackTrackingByID(idString);
    }

    @Test
    public void testRetrackTrackingByIDWithValidId() throws IOException, TrackingMoreException {
        String idString = "123456";

        TrackingMoreResponse response = trackingMore.trackings.RetrackTrackingByID(idString);

        assertNotNull(response);
        if( response.getMeta().getCode() == 200){
            Tracking tracking = (Tracking) response.getData();
            assertNotNull(tracking);
        }
    }

}
