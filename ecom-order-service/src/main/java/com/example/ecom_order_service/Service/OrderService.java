package com.example.ecom_order_service.Service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.example.ecom_order_service.Client.InventoryClient;
import com.example.ecom_order_service.Dto.Inventorydto;
import com.example.ecom_order_service.Exception.MyCustomRuntimeException;

import lombok.RequiredArgsConstructor;
//@RequiredArgsConstructor
@Service
public class OrderService {

    private final InventoryClient inventoryClient;
    private final RestTemplate restTemplate;
    private final RestClient restClient;
    private final InventoryService inventoryService;
    public OrderService(
        InventoryClient inventoryClient,
        RestTemplate restTemplate,
        RestClient restClient,
        InventoryService inventoryService) {

    this.inventoryClient = inventoryClient;
    this.restTemplate = restTemplate;
    this.restClient = restClient;
    this.inventoryService = inventoryService;
}
    public String placeOrders(Long id) throws ExecutionException, InterruptedException {
        // String url = "http://localhost:8081/inventory/" + id;
        // String response = restTemplate.getForObject(url,String.class);
        // return response.equals("Products Present") ? "Order Placed Successfully" : "Order Failed";

                // 1. Get inventory details from Inventory Service
        // ResponseEntity<Inventorydto> res = restClient.get()
        //         .uri("http://localhost:8081/inventory/{id}", id)
        //         .retrieve()
        //         .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
        //             throw new MyCustomRuntimeException(response.getStatusCode(),response.getHeaders());
        //         })
        //         .toEntity(Inventorydto.class);

        System.out.println("========== BEFORE INVENTORY GET ==========");

Inventorydto inventory = inventoryService.getInventory(id).get();

System.out.println("========== AFTER INVENTORY GET ==========");

        // 2. Check whether product exists and quantity is available
        if (inventory != null && inventory.getQuantity() > 0) {

            // 3. Reduce quantity by 1
            inventory.setQuantity(inventory.getQuantity() - 1);

            // 4. Update the Inventory DB
            inventoryClient.addInventory(inventory);

            // 5. Order successfully placed
            return "Order Placed Successfully";
        }

        // Product doesn't exist or quantity is 0
        return "Order Failed";
    }
    
}
