package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinationInfo {

    @JsonProperty("courier_code")
    private String courierCode;

    @JsonProperty("courier_phone")
    private String courierPhone;

    @JsonProperty("weblink")
    private String weblink;

    @JsonProperty("reference_number")
    private String referenceNumber;

    @JsonProperty("milestone_date")
    private MilestoneDate milestoneDate;

    @JsonProperty("pickup_date")
    private String pickupDate;

    @JsonProperty("departed_airport_date")
    private String departedAirportDate;

    @JsonProperty("arrived_abroad_date")
    private String arrivedAbroadDate;

    @JsonProperty("customs_received_date")
    private String customsReceivedDate;

    @JsonProperty("arrived_destination_date")
    private String arrivedDestinationDate;

    @JsonProperty("trackinfo")
    private List<TrackInfo> trackinfo;

}
