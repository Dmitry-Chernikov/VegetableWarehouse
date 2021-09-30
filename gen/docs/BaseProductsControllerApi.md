# BaseProductsControllerApi

All URIs are relative to *http://localhost:8080/sware*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createBaseProductsUsingPOST**](BaseProductsControllerApi.md#createBaseProductsUsingPOST) | **POST** /baseProducts | createBaseProducts
[**getAllBaseProductsUsingGET**](BaseProductsControllerApi.md#getAllBaseProductsUsingGET) | **GET** /baseProducts | getAllBaseProducts


<a name="createBaseProductsUsingPOST"></a>
# **createBaseProductsUsingPOST**
> BaseProductsDto createBaseProductsUsingPOST(baseProductsDto)

createBaseProducts

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaseProductsControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/sware");

    BaseProductsControllerApi apiInstance = new BaseProductsControllerApi(defaultClient);
    BaseProductsDto baseProductsDto = new BaseProductsDto(); // BaseProductsDto | 
    try {
      BaseProductsDto result = apiInstance.createBaseProductsUsingPOST(baseProductsDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaseProductsControllerApi#createBaseProductsUsingPOST");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **baseProductsDto** | [**BaseProductsDto**](BaseProductsDto.md)|  | [optional]

### Return type

[**BaseProductsDto**](BaseProductsDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="getAllBaseProductsUsingGET"></a>
# **getAllBaseProductsUsingGET**
> List&lt;BaseProductsDto&gt; getAllBaseProductsUsingGET()

getAllBaseProducts

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BaseProductsControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/sware");

    BaseProductsControllerApi apiInstance = new BaseProductsControllerApi(defaultClient);
    try {
      List<BaseProductsDto> result = apiInstance.getAllBaseProductsUsingGET();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BaseProductsControllerApi#getAllBaseProductsUsingGET");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;BaseProductsDto&gt;**](BaseProductsDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

