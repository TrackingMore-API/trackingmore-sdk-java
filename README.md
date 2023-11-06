trackingmore-sdk-java
=================

The Java SDK of Trackingmore API

Contact: <manage@trackingmore.org>

## Official document

[Document](https://www.trackingmore.com/docs/trackingmore/d5ac362fc3cda-api-quick-start)

## Index
1. [Installation](https://github.com/TrackingMores/trackingmore-sdk-java#installation)
2. [Testing](https://github.com/TrackingMores/trackingmore-sdk-java#testing)
3. [Error Handling](https://github.com/TrackingMores/trackingmore-sdk-java#error-handling)
4. SDK
    1. [Couriers](https://github.com/TrackingMores/trackingmore-sdk-java#couriers)
    2. [Trackings](https://github.com/TrackingMores/trackingmore-sdk-java#trackings)
    3. [Air Waybill](https://github.com/TrackingMores/trackingmore-sdk-java#air-waybill)


## Installation

### Maven

```
<dependency>
   <groupId>io.github.trackingmores</groupId>
   <artifactId>trackingmore-sdk-java</artifactId>
   <version>1.0.2</version>
</dependency>
```

### Gradle

```
implementation "io.github.trackingmores:trackingmore-sdk-java:1.0.2"
```


## Quick Start

```java
package com.trackingmore.example.courier;

import com.trackingmore.TrackingMore;
import com.trackingmore.exception.TrackingMoreException;
import com.trackingmore.model.TrackingMoreResponse;
import com.trackingmore.model.courier.Courier;

import java.io.IOException;
import java.util.List;

public class DetectCourierExample {

   public static void main(String[] args) {
      try {
         String apiKey = "you api key";
         TrackingMore trackingMore = new TrackingMore(apiKey);
         TrackingMoreResponse<List<Courier>> result = trackingMore.couriers.getAllCouriers();
         System.out.println(result.getMeta().getCode());
         List<Courier> couriers = result.getData();
         for (Courier courier : couriers) {
            String courierName = courier.getCourierName();
            String courierCode = courier.getCourierCode();
            System.out.println(courierName+"---"+courierCode);
         }
      } catch (TrackingMoreException e) {
         System.err.println("error：" + e.getMessage());
      } catch (IOException e) {
         System.err.println("error：" + e.getMessage());
      }
   }

}

```

## Testing
```
mvn test  or  ./gradlew test
```

## Error handling

**Throw** by the new SDK client

```java

try {
    
   String apiKey = "";
   TrackingMore trackingMore = new TrackingMore(apiKey);

} catch (TrackingMoreException e) {
  System.err.println("error：" + e.getMessage());
} 

/*
API Key is missing
*/
```

**Throw** by the parameter validation in function

```java

try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   DetectParams detectParams = new DetectParams();
   detectParams.setTrackingNumber("");
   TrackingMoreResponse<List<Courier>> result = trackingMore.couriers.detect(detectParams);
} catch (TrackingMoreException e) {
    System.err.println("error：" + e.getMessage());
} catch (IOException e) {
    System.err.println("error：" + e.getMessage());
}

/*
Tracking number cannot be empty
*/
```
## Examples

### Couriers
##### Return a list of all supported couriers.
https://api.trackingmore.com/v4/couriers/all
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   TrackingMoreResponse<List<Courier>> result = trackingMore.couriers.getAllCouriers();
   System.out.println(result.getMeta().getCode());
   List<Courier> couriers = result.getData();
   for (Courier courier : couriers) {
       String courierName = courier.getCourierName();
       String courierCode = courier.getCourierCode();
       System.out.println(courierName+"---"+courierCode);
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### Return a list of matched couriers based on submitted tracking number.
https://api.trackingmore.com/v4/couriers/detect
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   DetectParams detectParams = new DetectParams();
   detectParams.setTrackingNumber("92642903289511563030094932");
   TrackingMoreResponse<List<Courier>> result = trackingMore.couriers.detect(detectParams);
   System.out.println(result.getMeta().getCode());
   List<Courier> couriers = result.getData();
   for (Courier courier : couriers) {
       String courierName = courier.getCourierName();
       String courierCode = courier.getCourierCode();
       System.out.println(courierName+"---"+courierCode);
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

### Trackings
##### Create a tracking.
https://api.trackingmore.com/v4/trackings/create
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   CreateTrackingParams createTrackingParams = new CreateTrackingParams();
   createTrackingParams.setTrackingNumber("92612903029511573030094537");
   createTrackingParams.setCourierCode("usps");
   TrackingMoreResponse<Tracking> result = trackingMore.trackings.CreateTracking(createTrackingParams);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null){
       Tracking trackings = result.getData();
       System.out.println(trackings);
       System.out.println(trackings.getTrackingNumber());
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### Get tracking results of multiple trackings.
https://api.trackingmore.com/v4/trackings/get
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   GetTrackingResultsParams trackingParams = new GetTrackingResultsParams();
   trackingParams.setTrackingNumbers("92612903029511573030094537,92612903029511573030094531");
   trackingParams.setCourierCode("usps");
   trackingParams.setCreatedDateMin("2023-08-23T06:00:00+00:00");
   trackingParams.setCreatedDateMax("2023-09-18T06:00:00+00:00");
   TrackingMoreResponse<List<Tracking>> result = trackingMore.trackings.GetTrackingResults(trackingParams);
   System.out.println(result.getMeta().getCode());
   List<Tracking> trackings = result.getData();
   for (Tracking tracking : trackings) {
       String trackingNumber = tracking.getTrackingNumber();
       String courierCode = tracking.getCourierCode();

       System.out.println("Tracking Number: " + trackingNumber);
       System.out.println("Courier Code: " + courierCode);
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### Create multiple trackings (Max. 40 tracking numbers create in one call).
https://api.trackingmore.com/v4/trackings/batch
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   List<CreateTrackingParams> paramsList = new ArrayList<>();

   CreateTrackingParams createTrackingParams1 = new CreateTrackingParams();
   createTrackingParams1.setTrackingNumber("92632903279511573030094832");
   createTrackingParams1.setCourierCode("usps");

   CreateTrackingParams createTrackingParams2 = new CreateTrackingParams();
   createTrackingParams2.setTrackingNumber("92642903289511563039994932");
   createTrackingParams2.setCourierCode("usps");

   paramsList.add(createTrackingParams1);
   paramsList.add(createTrackingParams2);

   TrackingMoreResponse<BatchResults> result = trackingMore.trackings.BatchCreateTrackings(paramsList);
   System.out.println(result.getMeta().getCode());
   BatchResults batchResults = result.getData();
   if(result.getData() != null){
       System.out.println(batchResults);
       for (BatchItem batchItem : batchResults.getSuccess()) {
           String trackingNumber = batchItem.getTrackingNumber();
           String courierCode = batchItem.getCourierCode();
           System.out.println("Tracking Number: " + trackingNumber);
           System.out.println("Courier Code: " + courierCode);
       }
       for (BatchItem batchItem : batchResults.getError()) {
           String trackingNumber = batchItem.getTrackingNumber();
           String courierCode = batchItem.getCourierCode();
           System.out.println("Tracking Number: " + trackingNumber);
           System.out.println("Courier Code: " + courierCode);
       }
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### Update a tracking by ID.
https://api.trackingmore.com/v4/trackings/update/{id}
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   String idString = "9a035f5cdd0437c55d48e223c705a66c";
   UpdateTrackingParams updateTrackingParams = new UpdateTrackingParams();
   updateTrackingParams.setCustomerName("New name");
   updateTrackingParams.setNote("New tests order note");
   TrackingMoreResponse<UpdateTracking> result = trackingMore.trackings.UpdateTrackingByID(idString, updateTrackingParams);
   System.out.println(result.getMeta().getCode());
   System.out.println(result.getData());
   if(result.getData() != null){
       UpdateTracking  updateTracking= result.getData();
       System.out.println(updateTracking);
       System.out.println(updateTracking.getTrackingNumber());
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### Delete a tracking by ID.
https://api.trackingmore.com/v4/trackings/delete/{id}
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   String idString = "9a28d8ba030596de70c1b0134cdc8b0d";
   TrackingMoreResponse<Tracking> result = trackingMore.trackings.DeleteTrackingByID(idString);
   System.out.println(result);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null) {
       Tracking trackings = result.getData();
       System.out.println(trackings);
       System.out.println(trackings.getTrackingNumber());
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}

```

##### Retrack expired tracking by ID.
https://api.trackingmore.com/v4/trackings/retrack/{id}
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   String idString = "9a035f5cdd0437c55d48e223c705a66c";
   TrackingMoreResponse<Tracking> result = trackingMore.trackings.RetrackTrackingByID(idString);
   System.out.println(result);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null){
       Tracking  tracking= result.getData();
       System.out.println(tracking);
       System.out.println(tracking.getTrackingNumber());
   }
} catch (TrackingMoreException e) {
   System.err.println("error：" + e.getMessage());
} catch (IOException e) {
   System.err.println("error：" + e.getMessage());
}
```
### Air Waybill
##### Create an air waybill.
https://api.trackingmore.com/v4/awb
```java
try {
   String apiKey = "you api key";
   TrackingMore trackingMore = new TrackingMore(apiKey);
   AirWaybillParams airWaybillParams = new AirWaybillParams();
   airWaybillParams.setAwbNumber("235-69030430");
   TrackingMoreResponse result = trackingMore.airWaybills.CreateAnAirWayBill(airWaybillParams);
   System.out.println(result.getMeta().getCode());
   if(result.getData() != null){
      AirWaybill airWaybills = (AirWaybill) result.getData();
      System.out.println(airWaybills);
      System.out.println(airWaybills.getAwbNumber());
      System.out.println(airWaybills.getAirlineInfo().getName());
      System.out.println(airWaybills.getFlightInfo().get("TK0721").getDepartStation());
   }

} catch (TrackingMoreException e) {
    System.err.println("error：" + e.getMessage());
} catch (IOException e) {
    System.err.println("error：" + e.getMessage());
}

```

## Response Code

Trackingmore uses conventional HTTP response codes to indicate success or failure of an API request. In general, codes in the 2xx range indicate success, codes in the 4xx range indicate an error that resulted from the provided information (e.g. a required parameter was missing, a charge failed, etc.), and codes in the 5xx range indicate an TrackingMore's server error.


Http CODE|META CODE|TYPE | MESSAGE
----|-----|--------------|-------------------------------
200    |200     | <code>Success</code>        |    Request response is successful
400    |400     | <code>BadRequest</code>     |    Request type error. Please check the API documentation for the request type of this API.
400    |4101    | <code>BadRequest</code>     |    Tracking No. already exists.
400    |4102    | <code>BadRequest</code>     |    Tracking No. no exists. Please use 「Create a tracking」 API first to create shipment.
400    |4103    | <code>BadRequest</code>     |    You have exceeded the shipment quantity of API call. The maximum quantity is 40 shipments per call.
400    |4110    | <code>BadRequest</code>     |    The value of tracking_number is invalid.
400    |4111    | <code>BadRequest</code>     |    Tracking_number is required.
400    |4112    | <code>BadRequest</code>     |    Invalid Tracking ID.
400    |4113    | <code>BadRequest</code>     |    Retrack is not allowed. You can only retrack an expired tracking.
400    |4120    | <code>BadRequest</code>     |    The value of courier_code is invalid.
400    |4121    | <code>BadRequest</code>     |    Cannot detect courier.
400    |4122    | <code>BadRequest</code>     |    Missing or invalid value of the special required fields for this courier.
400    |4130    | <code>BadRequest</code>     |    The format of Field name is invalid.
400    |4160    | <code>BadRequest</code>     |    The awb_number is required or invaild format.
400    |4161    | <code>BadRequest</code>     |    The awb airline does not support yet.
400    |4190    | <code>BadRequest</code>     |    You are reaching the maximum quota limitation, please upgrade your current plan.
401    |401     | <code>Unauthorized</code>   |    Authentication failed or has no permission. Please check and ensure your API Key is correct.
403    |403     | <code>Forbidden</code>      |    Access prohibited. The request has been refused or access is not allowed.
404    |404     | <code>NotFound</code>       |    Page does not exist. Please check and ensure your link is correct.
429    |429     | <code>TooManyRequests</code>|    Exceeded API request limits, please try again later. Please check the API documentation for the limit of this API.
500    |511     | <code>ServerError</code>    |    Server error. Please contact us: service@trackingmore.org.
500    |512     | <code>ServerError</code>    |    Server error. Please contact us: service@trackingmore.org.
500    |513     | <code>ServerError</code>    |    Server error. Please contact us: service@trackingmore.org.