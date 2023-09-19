package com.trackingmore.model.airWaybill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirWaybillParams {

    @JsonProperty("awb_number")
    private String awbNumber;

}
