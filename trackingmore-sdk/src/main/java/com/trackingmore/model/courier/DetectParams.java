package com.trackingmore.model.courier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DetectParams {

    @JsonProperty("tracking_number")
    private String trackingNumber;

}
