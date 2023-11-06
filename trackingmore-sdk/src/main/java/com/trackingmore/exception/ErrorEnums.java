package com.trackingmore.exception;

public class ErrorEnums {
    public static final String ErrEmptyAPIKey = "API Key is missing";
    public static final String ErrMissingTrackingNumber      = "Tracking number cannot be empty";
    public static final String ErrMissingCourierCode         = "Courier Code cannot be empty";
    public static final String ErrMissingAwbNumber           = "Awb number cannot be empty";
    public static final String ErrMaxTrackingNumbersExceeded = "Max. 40 tracking numbers create in one call";
    public static final String ErrEmptyId                    = "Id cannot be empty";
    public static final String ErrInvalidAirWaybillFormat    = "The air waybill number format is invalid";

    private ErrorEnums() {

    }
}
