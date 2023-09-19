package com.trackingmore.model;

import lombok.Data;

@Data
public class TrackingMoreResponse<T>  {

    private Meta meta;
    private T data;

    public TrackingMoreResponse() {}

    public TrackingMoreResponse(T data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }
}
