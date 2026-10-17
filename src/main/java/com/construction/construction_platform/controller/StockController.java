package com.construction.construction_platform.controller;

import com.construction.construction_platform.model.StockItem;
import com.construction.construction_platform.service.StockItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockItemService stockItemService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_SITE_SUPERVISOR', 'ROLE_FINANCE_OFFICER', 'ROLE_PROJECT_MANAGER')")
    public ResponseEntity<List<StockItem>> getInventory() {
        return ResponseEntity.ok(stockItemService.getAllStock());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_SITE_SUPERVISOR')")
    public ResponseEntity<StockItem> updateStock(@RequestBody StockItem stockItem) {
        StockItem saved = stockItemService.addOrUpdateStock(stockItem);
        return ResponseEntity.ok(saved);
    }
}