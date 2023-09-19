package com.trackingmore.model.airWaybill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackInfo {

    @JsonProperty("plan_date")
    private String planDate;

    @JsonProperty("actual_date")
    private String actualDate;

    @JsonProperty("event")
    private String event;

    @JsonProperty("station")
    private String station;

    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("status")
    private String status;

    @JsonProperty("piece")
    private String piece;

    @JsonProperty("weight")
    private String weight;

}
