package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTrackingResultsParams {

    @JsonProperty("archived_status")
    private String archivedStatus;

    @JsonProperty("courier_code")
    private String courierCode;

    @JsonProperty("created_date_max")
    private String createdDateMax;

    @JsonProperty("created_date_min")
    private String createdDateMin;

    @JsonProperty("delivery_status")
    private String deliveryStatus;

    @JsonProperty("items_amount")
    private Integer itemsAmount;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("pages_amount")
    private Integer pagesAmount;

    @JsonProperty("tracking_numbers")
    private String trackingNumbers;

    @JsonProperty("updated_date_max")
    private String updatedDateMax;

    @JsonProperty("updated_date_min")
    private String updatedDateMin;

}
