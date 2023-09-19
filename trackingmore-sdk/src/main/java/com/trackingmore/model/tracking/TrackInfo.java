package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackInfo {

    @JsonProperty("checkpoint_date")
    private String checkpointDate;

    @JsonProperty("checkpoint_delivery_status")
    private String checkpointDeliveryStatus;

    @JsonProperty("checkpoint_delivery_substatus")
    private String checkpointDeliverySubstatus;

    @JsonProperty("tracking_detail")
    private String trackingDetail;

    @JsonProperty("location")
    private String location;

    @JsonProperty("country_iso2")
    private String countryIso2;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("zip")
    private String zip;

    @JsonProperty("raw_status")
    private String rawStatus;

}
