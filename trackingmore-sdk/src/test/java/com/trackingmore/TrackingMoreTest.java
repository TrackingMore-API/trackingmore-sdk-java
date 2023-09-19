package com.trackingmore;

import com.trackingmore.exception.TrackingMoreException;
import org.junit.Before;
import org.junit.Test;

public class TrackingMoreTest {

    private TrackingMore trackingMore;

    @Before
    public void setUp() throws TrackingMoreException {
        String apiKey = "apiKey";
        trackingMore = new TrackingMore(apiKey);
    }

    @Test(expected = TrackingMoreException.class)
    public void testConstructorWithEmptyApiKey() throws TrackingMoreException {
        new TrackingMore("");
    }

}
