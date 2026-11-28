package com.example.ecom_inventory_service.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecom_inventory_service.Entity.Inventory;
import com.example.ecom_inventory_service.Repository.InventoryRepository;
import org.springframework.http.HttpStatus;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory checkStock(Long productId) {
        return inventoryRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found with ID: " + productId));
    }

    public Inventory addProduct(Inventory inventory) {
        return inventoryRepository.save(inventory);
        
    }

    public String updateProduct(Inventory inventory) {
        Optional<Inventory> inv = inventoryRepository.findById(inventory.getProductId());
        if(inv.isPresent()){
            Inventory existingInventory = inv.get();
            existingInventory.setQuantity(inventory.getQuantity());
            inventoryRepository.save(existingInventory);
            return "Product updated successfully";
        } else {
            return "Product not found";
        }
    }

}
