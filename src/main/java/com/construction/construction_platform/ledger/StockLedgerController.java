package com.construction.construction_platform.ledger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockLedgerController {

    private final StockLedgerService stockLedgerService;

    public StockLedgerController(StockLedgerService stockLedgerService) {
        this.stockLedgerService = stockLedgerService;
    }

    // Endpoint to record a new stock transaction (POST)
    @PostMapping("/transaction")
    public ResponseEntity<StockLedgerEntry> recordTransaction(@RequestBody StockTransactionRequest request) {
        StockLedgerEntry savedEntry = stockLedgerService.recordTransaction(
                request.getItemId(),
                request.getQuantityChange(),
                request.getTransactionType(),
                request.getReferenceId()
        );
        return ResponseEntity.ok(savedEntry);
    }

    // Endpoint to view running balance ledger for an item (GET)
    @GetMapping("/ledger/{itemId}")
    public ResponseEntity<List<Object[]>> getStockLedger(@PathVariable Long itemId) {
        List<Object[]> ledger = stockLedgerService.getLedgerWithRunningBalance(itemId);
        return ResponseEntity.ok(ledger);
    }
}

// Simple Request DTO class for receiving JSON data
class StockTransactionRequest {
    private Long itemId;
    private Integer quantityChange;
    private StockTransactionType transactionType;
    private String referenceId;

    // Getters and Setters
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public Integer getQuantityChange() { return quantityChange; }
    public void setQuantityChange(Integer quantityChange) { this.quantityChange = quantityChange; }

    public StockTransactionType getTransactionType() { return transactionType; }
    public void setTransactionType(StockTransactionType transactionType) { this.transactionType = transactionType; }

    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
}