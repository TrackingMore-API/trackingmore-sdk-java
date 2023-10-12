package com.trackingmore.model.airWaybill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirWaybill {

    @JsonProperty("awb_number")
    private String awbNumber;

    @JsonProperty("status_number")
    private String statusNumber;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("piece")
    private String piece;

    @JsonProperty("origin")
    private String origin;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("flight_way_station")
    private String[] flightWayStation;

    @JsonProperty("last_event")
    private String lastEvent;

    @JsonProperty("flight_info_new")
    private FlightInfoNew[] flightInfoNew;

    @JsonProperty("flight_info")
    private Map<String, FlightInfo> FlightInfo;

    @JsonProperty("track_info")
    private TrackInfo[] trackInfo;

    @JsonProperty("airline_info")
    private AirlineInfo airlineInfo;

}
