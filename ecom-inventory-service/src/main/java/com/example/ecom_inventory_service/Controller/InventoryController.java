package com.example.ecom_inventory_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom_inventory_service.Entity.Inventory;
import com.example.ecom_inventory_service.Service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping("/{productId}")
    public Inventory checkInventory(@PathVariable Long productId) throws Exception{
        System.out.println("Inventory START " + productId);
        Thread.sleep(3000);
        System.out.println("Inventory END " + productId);
        //throw new Exception("Inventory Service Down"); // Simulate a delay of 1 second
        return inventoryService.checkStock(productId);
    }

    @PostMapping()
    public Inventory addProduct(@RequestBody Inventory inventory) throws Exception{
        Thread.sleep(3000);
        return inventoryService.addProduct(inventory);
    }

    @PutMapping()
    public String updateProduct(@RequestBody Inventory inventory){
        return inventoryService.updateProduct(inventory);
    }
}
