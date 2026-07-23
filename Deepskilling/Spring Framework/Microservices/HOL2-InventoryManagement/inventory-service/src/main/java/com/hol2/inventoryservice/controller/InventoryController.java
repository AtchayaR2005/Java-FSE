package com.hol2.inventoryservice.controller;

import com.hol2.inventoryservice.model.Inventory;
import com.hol2.inventoryservice.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) { this.inventoryService = inventoryService; }

    @GetMapping
    public List<Inventory> getAllInventory() { return inventoryService.getAllInventory(); }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public List<Inventory> getByProductId(@PathVariable Long productId) { return inventoryService.getInventoryByProductId(productId); }

    @GetMapping("/product/{productId}/availability")
    public String checkAvailability(@PathVariable Long productId) { return inventoryService.checkProductAvailability(productId); }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) { return inventoryService.createInventory(inventory); }

    @PutMapping("/{id}/quantity")
    public ResponseEntity<Inventory> updateQuantity(@PathVariable Long id, @RequestParam Integer quantity) {
        return ResponseEntity.ok(inventoryService.updateQuantity(id, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id); return ResponseEntity.noContent().build();
    }
}
