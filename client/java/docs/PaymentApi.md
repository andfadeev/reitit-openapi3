# PaymentApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**paymentsGet**](PaymentApi.md#paymentsGet) | **GET** /payments/ | Get list of payments |
| [**paymentsIdGet**](PaymentApi.md#paymentsIdGet) | **GET** /payments/{id} | Get payment by id |
| [**paymentsPost**](PaymentApi.md#paymentsPost) | **POST** /payments/ |  |


<a id="paymentsGet"></a>
# **paymentsGet**
> PaymentsGet200Response paymentsGet(limit)

Get list of payments

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PaymentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PaymentApi apiInstance = new PaymentApi(defaultClient);
    Integer limit = 10; // Integer | Max n of payments to return in the response
    try {
      PaymentsGet200Response result = apiInstance.paymentsGet(limit);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentApi#paymentsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **limit** | **Integer**| Max n of payments to return in the response | [default to 10] |

### Return type

[**PaymentsGet200Response**](PaymentsGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/transit+msgpack, application/transit+json, application/edn

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="paymentsIdGet"></a>
# **paymentsIdGet**
> PaymentsPost201Response paymentsIdGet(id)

Get payment by id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PaymentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PaymentApi apiInstance = new PaymentApi(defaultClient);
    Integer id = 56; // Integer | 
    try {
      PaymentsPost201Response result = apiInstance.paymentsIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentApi#paymentsIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**|  | |

### Return type

[**PaymentsPost201Response**](PaymentsPost201Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/transit+msgpack, application/transit+json, application/edn

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** |  |  -  |

<a id="paymentsPost"></a>
# **paymentsPost**
> PaymentsPost201Response paymentsPost(paymentsPostRequest)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PaymentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    PaymentApi apiInstance = new PaymentApi(defaultClient);
    PaymentsPostRequest paymentsPostRequest = new PaymentsPostRequest(); // PaymentsPostRequest | 
    try {
      PaymentsPost201Response result = apiInstance.paymentsPost(paymentsPostRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PaymentApi#paymentsPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **paymentsPostRequest** | [**PaymentsPostRequest**](PaymentsPostRequest.md)|  | [optional] |

### Return type

[**PaymentsPost201Response**](PaymentsPost201Response.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/transit+msgpack, application/transit+json, application/edn
 - **Accept**: application/json, application/transit+msgpack, application/transit+json, application/edn

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** |  |  -  |

