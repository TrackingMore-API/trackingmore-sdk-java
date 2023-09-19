package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchItem {

    @JsonProperty("id")
    private String id;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("courier_code")
    private String courierCode;

    @JsonProperty("errorCode")
    private Integer errorCode;

    @JsonProperty("errorMessage")
    private String errorMessage;

}
