package com.trackingmore.model.courier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Courier<T> {

    @JsonProperty("courier_name")
    private String courierName;

    @JsonProperty("courier_code")
    private String courierCode;

    @JsonProperty("courier_country_iso2")
    private String courierCountryIso2;

    @JsonProperty("courier_url")
    private String courierUrl;

    @JsonProperty("courier_phone")
    private String courierPhone;

    @JsonProperty("courier_type")
    private String courierType;

    @JsonProperty("tracking_required_fields")
    private T trackingRequiredFields;

    @JsonProperty("optional_fields")
    private T optionalFields;

    @JsonProperty("default_language")
    private String defaultLanguage;

    @JsonProperty("support_language")
    private List<String> supportLanguage;

    @JsonProperty("courier_logo")
    private String courierLogo;

}
