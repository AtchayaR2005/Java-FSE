package com.hol2.inventoryservice.service;

import com.hol2.inventoryservice.dto.ProductResponse;
import com.hol2.inventoryservice.model.Inventory;
import com.hol2.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final RestTemplate restTemplate;
    private static final String PRODUCT_SERVICE_URL = "http://localhost:8083/api/products";

    public InventoryService(InventoryRepository inventoryRepository, RestTemplate restTemplate) {
        this.inventoryRepository = inventoryRepository;
        this.restTemplate = restTemplate;
    }

    public List<Inventory> getAllInventory() { return inventoryRepository.findAll(); }
    public Optional<Inventory> getInventoryById(Long id) { return inventoryRepository.findById(id); }
    public List<Inventory> getInventoryByProductId(Long productId) { return inventoryRepository.findByProductId(productId); }

    public Inventory createInventory(Inventory inventory) {
        if (inventory.getQuantity() != null && inventory.getQuantity() <= 0) {
            inventory.setStatus("OUT_OF_STOCK");
        }
        return inventoryRepository.save(inventory);
    }

    public Inventory updateQuantity(Long id, Integer quantity) {
        Inventory inv = inventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventory not found"));
        inv.setQuantity(quantity);
        inv.setStatus(quantity <= 0 ? "OUT_OF_STOCK" : "IN_STOCK");
        return inventoryRepository.save(inv);
    }

    public String checkProductAvailability(Long productId) {
        ProductResponse product = restTemplate.getForObject(PRODUCT_SERVICE_URL + "/" + productId, ProductResponse.class);
        List<Inventory> inventories = inventoryRepository.findByProductId(productId);
        int totalQty = inventories.stream().mapToInt(Inventory::getQuantity).sum();
        return "Product: " + (product != null ? product.getName() : "Unknown") + ", Available: " + totalQty;
    }

    public void deleteInventory(Long id) { inventoryRepository.deleteById(id); }
}
