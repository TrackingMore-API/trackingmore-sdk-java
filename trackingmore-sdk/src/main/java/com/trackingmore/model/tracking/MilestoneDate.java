package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MilestoneDate {

    @JsonProperty("inforeceived_date")
    private String inforeceivedDate;

    @JsonProperty("pickup_date")
    private String pickupDate;

    @JsonProperty("outfordelivery_date")
    private String outfordeliveryDate;

    @JsonProperty("delivery_date")
    private String deliveryDate;

    @JsonProperty("returning_date")
    private String returningDate;

    @JsonProperty("returned_date")
    private String returnedDate;

}
