package com.trackingmore.model.airWaybill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightInfo {

    @JsonProperty("plan_arrival_time")
    private String planArrivalTime;

    @JsonProperty("arrival_time")
    private String arrivalTime;

    @JsonProperty("arrival_station")
    private String arrivalStation;

    @JsonProperty("plan_depart_time")
    private String planDepartTime;

    @JsonProperty("depart_time")
    private String departTime;

    @JsonProperty("depart_station")
    private String departStation;

}
