package com.example.ecom_inventory_service.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ecom_inventory_service.Entity.Inventory;
import com.example.ecom_inventory_service.Repository.InventoryRepository;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory checkStock(Long productId) {
        Optional<Inventory> inv = inventoryRepository.findById(productId);
        return inv.get();
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
