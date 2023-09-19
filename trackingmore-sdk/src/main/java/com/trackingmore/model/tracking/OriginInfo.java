package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginInfo {

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

    @JsonProperty("pickup_date (Lagacy)")
    private String pickupDateLagacy;

    @JsonProperty("departed_airport_date (Lagacy)")
    private String departedAirportDateLagacy;

    @JsonProperty("arrived_abroad_date (Lagacy)")
    private String arrivedAbroadDateLagacy;

    @JsonProperty("customs_received_date (Lagacy)")
    private String customsReceivedDateLagacy;

    @JsonProperty("arrived_destination_date (Lagacy)")
    private String arrivedDestinationDateLagacy;

    @JsonProperty("trackinfo")
    private List<TrackInfo> trackinfo;

}
