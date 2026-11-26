package com.example.ecom_order_service.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ecom_order_service.Client.Config.InventoryFeignClient;
import com.example.ecom_order_service.Dto.Inventorydto;

@FeignClient(name ="ecom-inventory-service",configuration = InventoryFeignClient.class)
public interface InventoryClient {
    @GetMapping("/inventory/{id}")
    public Inventorydto getInventory(@PathVariable Long id);

    @PostMapping("/inventory")
    public Inventorydto addInventory(@RequestBody Inventorydto inventorydto);
}
