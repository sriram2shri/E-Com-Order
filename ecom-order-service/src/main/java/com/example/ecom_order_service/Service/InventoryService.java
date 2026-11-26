package com.example.ecom_order_service.Service;

import org.springframework.retry.annotation.Retryable;

import java.util.concurrent.CompletableFuture;

import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import com.example.ecom_order_service.Client.InventoryClient;
import com.example.ecom_order_service.Dto.Inventorydto;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
//import lombok.RequiredArgsConstructor;

@Service 
//@RequiredArgsConstructor
public class InventoryService {
    private final InventoryClient inventoryClient;
    public InventoryService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }
    
    // @Retryable(retryFor = {Exception.class}, 
    //     maxAttempts = 3, 
    //     backoff = @Backoff(delay = 2000))
    // @RateLimiter (name = "inventoryProducts", fallbackMethod = "fallbackGetInventory")
    // @CircuitBreaker (name = "inventoryService", fallbackMethod = "fallbackGetInventory")
    // @TimeLimiter(name = "inventoryService", fallbackMethod = "fallbackGetInventory")
    // @Bulkhead (name = "inventoryService",type = Bulkhead.Type.THREADPOOL,fallbackMethod = "fallbackGetInventory")
    public CompletableFuture<Inventorydto> getInventory(Long id) {
    //    public Inventorydto getInventory(Long id) {
    //     System.out.println(
    //     "START id=" + id +
    //     " THREAD=" + Thread.currentThread().getName() +
    //     " TIME=" + System.currentTimeMillis()
    // );

    Inventorydto inventory = inventoryClient.getInventory(id);

    // System.out.println(
    //     "END id=" + id +
    //     " THREAD=" + Thread.currentThread().getName() +
    //     " TIME=" + System.currentTimeMillis()
    // );

    return CompletableFuture.completedFuture(inventory);
    }

    // public CompletableFuture<Inventorydto> fallbackGetInventory(Long id, Exception e) {
    // //     System.out.println(
    // //     "FALLBACK id=" + id +
    // //     " THREAD=" + Thread.currentThread().getName() +
    // //     " REASON=" + e.getClass().getName()
    // // );
    // System.out.println("FALLBACK REASON: " + e);
    //     // You can return a default Inventorydto or handle the fallback logic as needed
    //     Inventorydto inventory=new Inventorydto(id, 0); // Assuming quantity is 0 in fallback
    //     return CompletableFuture.completedFuture(inventory);
    //     // return inventory;
    // }

    public CompletableFuture<Inventorydto> fallbackGetInventory(
        Long id, Throwable e) {

    System.out.println("========== FALLBACK EXECUTED ==========");
    System.out.println("Product ID: " + id);
    System.out.println("Exception Type: " + e.getClass().getName());
    System.out.println("Exception Message: " + e.getMessage());

    e.printStackTrace();

    if (e.getCause() != null) {
        System.out.println("Root Cause: " + e.getCause());
    }

    Inventorydto inventory = new Inventorydto(id, 0);

    return CompletableFuture.completedFuture(inventory);
}
}
