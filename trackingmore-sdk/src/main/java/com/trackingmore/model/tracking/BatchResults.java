package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchResults {

    @JsonProperty("success")
    private List<BatchItem> success;

    @JsonProperty("error")
    private List<BatchItem> error;

}
