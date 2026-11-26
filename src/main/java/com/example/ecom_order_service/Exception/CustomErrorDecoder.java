package com.example.ecom_order_service.Exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder{

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status()==404){
            return new RuntimeException("Product Not Found");
        }
        System.out.println(
        "Feign call failed. Status: " + response.status()
    );
        return new RuntimeException("Unexpected error occurred");
    }
}
