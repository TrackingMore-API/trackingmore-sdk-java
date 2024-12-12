package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateTracking {

    @JsonProperty("id")
    private String id;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("courier_code")
    private String courierCode;

    @JsonProperty("courier_code_new")
    private String courierCodeNew;

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("order_date")
    private String orderDate;

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("destination_country")
    private String destinationCountry;

    @JsonProperty("origin_country")
    private String originCountry;

    @JsonProperty("tracking_postal_code")
    private String trackingPostalCode;

    @JsonProperty("tracking_ship_date")
    private String trackingShipDate;

    @JsonProperty("tracking_courier_account")
    private String trackingCourierAccount;

    @JsonProperty("tracking_destination_country")
    private String trackingDestinationCountry;

    @JsonProperty("tracking_origin_country")
    private String trackingOriginCountry;

    @JsonProperty("tracking_key")
    private String trackingKey;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_sms")
    private String customerSms;

    @JsonProperty("recipient_postcode")
    private String recipientPostcode;

    @JsonProperty("title")
    private String title;

    @JsonProperty("logistics_channel")
    private String logisticsChannel;

    @JsonProperty("note")
    private String note;

    @JsonProperty("label")
    private String label;

    @JsonProperty("archived_status")
    private String archivedStatus;
}
