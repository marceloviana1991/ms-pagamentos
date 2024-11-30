# PagamentoControllerApi

All URIs are relative to *http://192.168.9.212:35949*

Method | HTTP request | Description
------------- | ------------- | -------------
[**aprovaPagamento**](PagamentoControllerApi.md#aprovaPagamento) | **PUT** /pagamentos/pedidos/{id} | 
[**getPagamento**](PagamentoControllerApi.md#getPagamento) | **GET** /pagamentos/{id} | 
[**getPagePagamentos**](PagamentoControllerApi.md#getPagePagamentos) | **GET** /pagamentos | 
[**retornaPorta**](PagamentoControllerApi.md#retornaPorta) | **GET** /pagamentos/porta | 
[**savePagamento**](PagamentoControllerApi.md#savePagamento) | **POST** /pagamentos | 

<a name="aprovaPagamento"></a>
# **aprovaPagamento**
> aprovaPagamento(id)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PagamentoControllerApi;


PagamentoControllerApi apiInstance = new PagamentoControllerApi();
Long id = 789L; // Long | 
try {
    apiInstance.aprovaPagamento(id);
} catch (ApiException e) {
    System.err.println("Exception when calling PagamentoControllerApi#aprovaPagamento");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getPagamento"></a>
# **getPagamento**
> PagamentoResponseDto getPagamento(id)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PagamentoControllerApi;


PagamentoControllerApi apiInstance = new PagamentoControllerApi();
Long id = 789L; // Long | 
try {
    PagamentoResponseDto result = apiInstance.getPagamento(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PagamentoControllerApi#getPagamento");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**PagamentoResponseDto**](PagamentoResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getPagePagamentos"></a>
# **getPagePagamentos**
> List&lt;PagamentoResponseDto&gt; getPagePagamentos(pageable)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PagamentoControllerApi;


PagamentoControllerApi apiInstance = new PagamentoControllerApi();
Pageable pageable = new Pageable(); // Pageable | 
try {
    List<PagamentoResponseDto> result = apiInstance.getPagePagamentos(pageable);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PagamentoControllerApi#getPagePagamentos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pageable** | [**Pageable**](.md)|  |

### Return type

[**List&lt;PagamentoResponseDto&gt;**](PagamentoResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="retornaPorta"></a>
# **retornaPorta**
> String retornaPorta(porta)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PagamentoControllerApi;


PagamentoControllerApi apiInstance = new PagamentoControllerApi();
String porta = "porta_example"; // String | 
try {
    String result = apiInstance.retornaPorta(porta);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PagamentoControllerApi#retornaPorta");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **porta** | **String**|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="savePagamento"></a>
# **savePagamento**
> PagamentoResponseDto savePagamento(body)



### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PagamentoControllerApi;


PagamentoControllerApi apiInstance = new PagamentoControllerApi();
PagamentoRequestDto body = new PagamentoRequestDto(); // PagamentoRequestDto | 
try {
    PagamentoResponseDto result = apiInstance.savePagamento(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PagamentoControllerApi#savePagamento");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**PagamentoRequestDto**](PagamentoRequestDto.md)|  |

### Return type

[**PagamentoResponseDto**](PagamentoResponseDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

