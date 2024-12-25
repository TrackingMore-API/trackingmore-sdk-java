package com.trackingmore.model.tracking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracking {

    @JsonProperty("id")
    private String id;

    @JsonProperty("tracking_number")
    private String trackingNumber;

    @JsonProperty("courier_code")
    private String courierCode;

    @JsonProperty("order_number")
    private String orderNumber;

    @JsonProperty("order_date")
    private String orderDate;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("update_at")
    private String updateAt;

    @JsonProperty("delivery_status")
    private String deliveryStatus;

    @JsonProperty("archived")
    private String archived;

    @JsonProperty("updating")
    private boolean updating;

    @JsonProperty("destination_country")
    private String destinationCountry;

    @JsonProperty("destination_state")
    private String destinationState;

    @JsonProperty("destination_city")
    private String destinationCity;

    @JsonProperty("origin_country")
    private String originCountry;

    @JsonProperty("origin_state")
    private String originState;

    @JsonProperty("origin_city")
    private String originCity;

    @JsonProperty("tracking_postal_code")
    private String trackingPostalCode;

    @JsonProperty("tracking_ship_date")
    private String trackingShipDate;

    @JsonProperty("tracking_destination_country")
    private String trackingDestinationCountry;

    @JsonProperty("tracking_origin_country")
    private String trackingOriginCountry;

    @JsonProperty("tracking_key")
    private String trackingKey;

    @JsonProperty("tracking_courier_account")
    private String trackingCourierAccount;

    @JsonProperty("customer_name")
    private String customerName;

    @JsonProperty("customer_email")
    private String customerEmail;

    @JsonProperty("customer_sms")
    private String customerSms;

    @JsonProperty("order_id")
    private String orderId;

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

    @JsonProperty("signed_by")
    private String signedBy;

    @JsonProperty("service_code")
    private String serviceCode;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("weight_kg")
    private String weightKg;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("pieces")
    private String pieces;

    @JsonProperty("dimension")
    private String dimension;

    @JsonProperty("previously")
    private String previously;

    @JsonProperty("destination_track_number")
    private String destinationTrackNumber;

    @JsonProperty("exchange_number")
    private String exchangeNumber;

    @JsonProperty("scheduled_delivery_date")
    private String scheduledDeliveryDate;

    @JsonProperty("scheduled_address")
    private String scheduledAddress;

    @JsonProperty("substatus")
    private String substatus;

    @JsonProperty("status_info")
    private String statusInfo;

    @JsonProperty("latest_event")
    private String latestEvent;

    @JsonProperty("latest_checkpoint_time")
    private String latestCheckpointTime;

    @JsonProperty("transit_time")
    private int transitTime;

    @JsonProperty("origin_info")
    private OriginInfo originInfo;

    @JsonProperty("destination_info")
    private DestinationInfo destinationInfo;

}
