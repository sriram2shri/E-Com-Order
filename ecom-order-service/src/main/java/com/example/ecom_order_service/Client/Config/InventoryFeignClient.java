package com.example.ecom_order_service.Client.Config;
import java.time.Duration;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ecom_order_service.Exception.CustomErrorDecoder;

import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;

@Configuration
public class InventoryFeignClient {
    
    @Bean
    public Logger.Level InventoryLogger(){
        return Logger.Level.FULL;
    } 

    @Bean
    public Request.Options options(){
        return new Request.Options(Duration.ofMillis(3000), Duration.ofMillis(30000),true);
    }


    @Bean
    public Retryer retryer(){
        return Retryer.NEVER_RETRY;
    }

    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate->{
            requestTemplate.header("Authorization","Bearer token");
            requestTemplate.header("X-CorrelationId",UUID.randomUUID().toString());
        };
        }

        @Bean
        public ErrorDecoder errorDecoder(){
            return new CustomErrorDecoder();
        }
    }
