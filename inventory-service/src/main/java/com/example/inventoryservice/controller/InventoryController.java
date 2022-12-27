package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStuck(@PathVariable("skuCode") String skuCode) {
        return inventoryService.isInStuck(skuCode);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }
}
