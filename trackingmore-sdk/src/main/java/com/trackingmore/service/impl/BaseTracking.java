package com.trackingmore.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trackingmore.request.RequestHelper;

public class BaseTracking {
    protected RequestHelper requestHelper;

    protected ObjectMapper objectMapper;
    public BaseTracking(){
        this.requestHelper = new RequestHelper();
        this.objectMapper = new ObjectMapper();
    }
}
